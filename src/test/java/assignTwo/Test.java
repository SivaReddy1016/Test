package assignTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//Resource//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in/UserReviewEdit-g297677-d3875625-Moskva_Hotel-Madurai_Madurai_District_Tamil_Nadu.html");
		WebElement element=driver.findElement(By.xpath("//*[@id='bubble_rating']"));
		WebElement element1=driver.findElement(By.xpath("(//div[@class='detailsRatings'])[1]"));

		Actions act=new Actions(driver);
		act.moveToElement(element);
		Thread.sleep(1000);
		System.out.println("GetLocation "+element1.getLocation());
		System.out.println("getSize "+element1.getSize());
		System.out.println("getRect "+element1.getRect().getX());
		System.out.println("getRect "+element1.getRect().getY());
		System.out.println("getRect "+element1.getRect().getWidth());
		System.out.println("getRect "+element1.getRect().getHeight());
		//act.moveToElement(element, 160, 33).click().perform();
		//Thread.sleep(3000);
		act.moveToElement(element, 130, 20).click().perform();
		
				act.moveToElement(element1, 100,15).click().perform();
		
	}

}
