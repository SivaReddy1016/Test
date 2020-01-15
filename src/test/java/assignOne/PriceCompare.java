package assignOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.LaunchLogin;
import webPages.AmazonHomePage;
import webPages.FlipKartPage;

public class PriceCompare extends LaunchLogin {

	ArrayList amazonPhDetails = new ArrayList();
	HashMap amazonphoneprice = new HashMap();
	HashMap flikartphoneprice = new HashMap();
	String amazonXRPrice;

	@BeforeMethod
	public void setUp() throws Exception {
		initilizeBrowser(setEnv().getProperty("browser"));
	}

	@Test(enabled = false, description = "Search in Amazon")
	public void searchInAmazon() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		launchApplication("AmazonURL");
		AmazonHomePage ampage = new AmazonHomePage(driver);
		ampage.enterSearchValue("iPhone XR (64GB) - Yellow");
		ampage.clickOnSearchButton();

		for (int i = 0; i < ampage.getPhones().size(); i++) {
			amazonphoneprice.put(((String) ampage.getPhones().get(i)).trim(),
					((String) ampage.getPrices().get(i)).trim());
		}

		if (amazonphoneprice.containsKey("Apple iPhone XR (64GB) - Yellow")){
			amazonXRPrice = (String) amazonphoneprice.get("Apple iPhone XR (64GB) - Yellow");
		amazonXRPrice=amazonXRPrice.replaceAll(",", "");
		}
		else
			System.out.println("Amazon The searched ITEM in available");

	}

	@Test( dependsOnMethods = { "searchInAmazon" },description = "Search in flipkart")
	public void searchInFlipKart() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		launchApplication("FlipkartURL");
		FlipKartPage flippage = new FlipKartPage(driver);
		flippage.clickOnLoginClosebutton();
		flippage.enterSearchValue("iPhone XR (64GB) - Yellow");
		flippage.clickOnSearchButton();
		String flipkartXRPrice = null;
		for (int i = 0; i < flippage.getPhones().size(); i++) {
			flikartphoneprice.put(((String) flippage.getPhones().get(i)).trim(),
					((String) flippage.getPrices().get(i)).trim());
		}

		if (flikartphoneprice.containsKey("Apple iPhone XR (64GB) - Yellow"))
			flipkartXRPrice = (String) flikartphoneprice.get("Apple iPhone XR (64GB) - Yellow");
		else if (!flikartphoneprice.containsKey("Apple iPhone XR (64GB) - Yellow"))
			flipkartXRPrice = (String) flikartphoneprice.get("Apple iPhone XR (Yellow, 64 GB)");

		else
			System.out.println("FlipKart The searched ITEM in available");

		flipkartXRPrice = flipkartXRPrice.replaceAll("₹", "").replaceAll(",","");
		int flipkartrate = Integer.parseInt(flipkartXRPrice);
		int amazonrate = Integer.parseInt(amazonXRPrice);
		if (flipkartrate < amazonrate) {
			System.out.println("Go with Flipkart because in flipkart having low cost");
		}
		if (flipkartrate > amazonrate) {
			System.out.println("Go with Amazon because in amazon having low cost");
		}
		

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
