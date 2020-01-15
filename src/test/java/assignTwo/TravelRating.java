package assignTwo;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.LaunchLogin;
import utilities.ReusableFunctions;
import webPages.TravelAdvisor;

public class TravelRating extends LaunchLogin {

	
	@BeforeMethod
	public void setUp() throws Exception {
		initilizeBrowser(setEnv().getProperty("browser"));
	}
  @Test(description = "writing review")
  public void giveRating() throws Exception{
	  ReusableFunctions reuse=new ReusableFunctions();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		launchApplication("TripAdvisorURL");
		TravelAdvisor trav = new TravelAdvisor(driver);
		trav.clickOnsearchbox();
		trav.entervalueinSearchBoxAndClickOnwriteReview("Club Mahindra");
		reuse.switchToWindow("Write a review - TripAdvisor",driver);
		trav.fillTheMandortyfields();
		trav.entertheRandomValueInDescription(220);
		trav.clcikOnRatingButton(driver);
		
		trav.selectTheSubmitCheckbox();
		trav.clickOnsubmitButton();
  }
	
	
	@AfterMethod
	public void tearDown() {

		//driver.quit();
	}

}
