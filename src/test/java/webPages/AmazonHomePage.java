package webPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	// public static WebDriver driver = LaunchLogin.driver;
	// Constructor
	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//*[@value='Go' and @class='nav-input']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@class='s-result-list s-search-results sg-row']//following::div[contains(@data-cel-widget,'search_result')]")
	public List<WebElement> listOfItems;

	@FindBy(xpath = "//*[@class='a-price-whole']")
	private List<WebElement> price;

	@FindBy(xpath = "//*[@class='a-price-whole']//preceding::h2/a/span")
	private List<WebElement> phone; 

		public void enterSearchValue(String name) {
		searchTextBox.sendKeys(name);
	}

	public void clickOnSearchButton() {
		searchButton.submit();
	}

	public List getAllItems(List<WebElement> list ) {

		ArrayList arrlist = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			arrlist.add(list.get(i).getText());
		}
		return arrlist;
	}
	public List getPrices() {
		return getAllItems(price);
	}

	public List getPhones() {
		return getAllItems(phone);
	}


}
