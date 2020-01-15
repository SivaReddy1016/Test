

	package webPages;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	public class FlipKartPage {
	// Constructor
	public FlipKartPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//*[text()='Enter Email/Mobile number']//preceding::button[1]")
		private WebElement loginclosebutton;

	@FindBy(xpath = "//*[@title='Search for products, brands and more']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//*[@title='Search for products, brands and more']//following::button")
		private WebElement searchButton;

	@FindBy(xpath = "//*[contains(@data-tkid,'SEARCH')]")
		public List<WebElement> listOfItems;

	@FindBy(xpath = "//*[contains(@data-tkid,'SEARCH')]//following::*[@class='_1uv9Cb']")
	private List<WebElement> price;

	@FindBy(xpath = "//*[contains(@data-tkid,'SEARCH')]//following::*[@class='_3wU53n']")
	private List<WebElement> phone;

	public void clickOnLoginClosebutton() {
		loginclosebutton.click();
	}

	public void enterSearchValue(String name) {
		searchTextBox.sendKeys(name);
	}

	public void clickOnSearchButton() {
		searchButton.submit();
	}

	public List getAllItems(List<WebElement> list) {

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

