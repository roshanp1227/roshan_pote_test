package Com.qa.question1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Question_Google_Maps {

	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShriGajanan\\eclipse-workspace\\Com.Qa.Test.Roshan.Pote\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/maps/");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void tasks() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Search Google Maps']")).sendKeys("Wankhede Stadium");

		driver.findElement(
				By.xpath("//div[@class='searchbox-searchbutton-container']//button[@class='searchbox-searchbutton']"))
				.click();

		Thread.sleep(10000);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("C:\\Users\\ShriGajanan\\eclipse-workspace\\Com.Qa.Test.Roshan.Pote\\Output\\result.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

		String Veri_Text = driver.findElement(By.xpath("//button[contains(text(),'Stadium')]")).getText();
		System.out.println(Veri_Text);
		Assert.assertEquals(Veri_Text, "Stadium");

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Wankhede Stadium - Google Maps");

		String star_rate = driver.findElement(By.xpath("//span[@class='section-star-display']")).getText();
		System.out.println(star_rate);

		String Rating_Text = driver.findElement(By.xpath("//button[@jsaction='pane.rating.moreReviews']")).getText();
		System.out.println(Rating_Text);
	}

	@AfterMethod
	public void close_browser() {

		driver.quit();
	}
}
