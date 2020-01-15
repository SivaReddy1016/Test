package webPages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravelAdvisor {
	// Constructor
	public TravelAdvisor(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@title='Search']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//*[@id='mainSearch']")
	private WebElement mainSearchBox;

	@FindBy(xpath = "(//li[@class='displayItem result'])[1]")
	private WebElement firstList;

	@FindBy(xpath = "//*[text()='Write a review']")
	public WebElement WriteReview;

	@FindBy(xpath = "//*[@id='bubble_rating']")
	public WebElement overallRating;

	@FindBy(xpath = "(//div[@class='detailsRatings'])[1]")
	public WebElement hotelRatingsService;
	@FindBy(xpath = "(//div[@class='detailsRatings'])[2]")
	public WebElement hotelRatingsQuality;
	@FindBy(xpath = "(//div[@class='detailsRatings'])[3]")
	public WebElement hotelRatingsCleaness;

	@FindBy(xpath = "(//*[@id='ReviewText'])[1]")
	private WebElement reviewTextBox;

	@FindBy(xpath = "(//*[@id='noFraud'])")
	private WebElement submitYourReviewCheckbox;

	@FindBy(xpath = "//*[@id='ReviewTitle']")
	private WebElement reviewTitleBox;

	@FindBy(xpath = "//*[@data-category='Business']")
	private WebElement category;

	@FindBy(xpath = "//*[@id='trip_date_month_year']")
	private WebElement traveledMonthDropdown;

	@FindBy(xpath = "//*[@id='SUBMIT']")
	private WebElement submitYourReviewButton;

	public void clickOnsearchbox() {
		searchTextBox.click();
	}

	public void entervalueinSearchBoxAndClickOnwriteReview(String name) throws InterruptedException {
		mainSearchBox.sendKeys(name);
		firstList.click();
		Thread.sleep(3000);
		WriteReview.click();

	}

	public void entertheRandomValueInDescription(int Stringlength) {
		StringBuilder sb = new StringBuilder(Stringlength);
		Random random = new Random();
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		String ramdomString = CHAR_LOWER;
		for (int i = 0; i < Stringlength; i++) {
			int index = (int) (ramdomString.length() * Math.random());
			char rndChar = ramdomString.charAt(index);

			sb.append(rndChar);
		}
		reviewTextBox.sendKeys(sb.toString());
	}

	public void selectTheSubmitCheckbox() {
		if (!submitYourReviewCheckbox.isSelected())
			submitYourReviewCheckbox.click();
	}

	public void clickOnsubmitButton() {
		submitYourReviewButton.click();
	}

	public void clcikOnRatingButton(WebDriver driver) {
		Actions act = new Actions(driver);
		//System.out.println("===========" + element.getSize().height);
		//System.out.println("===========" + element.getSize().width);
		act.moveToElement(overallRating, 130, 20).click().perform();
		act.moveToElement(hotelRatingsService, 100,150).click().perform();
		act.moveToElement(hotelRatingsQuality, 100, 15).click().perform();
		act.moveToElement(hotelRatingsCleaness, 100, 15).click().perform();

		
	}

	public void fillTheMandortyfields() {
		reviewTitleBox.sendKeys("My company outing trip Rating");
		category.click();
		Select se = new Select(traveledMonthDropdown);
		se.selectByIndex(1);

	}

}
