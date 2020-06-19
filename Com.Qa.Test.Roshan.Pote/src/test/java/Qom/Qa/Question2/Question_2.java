package Qom.Qa.Question2;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class Question_2 {

	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShriGajanan\\eclipse-workspace\\Com.Qa.Test.Roshan.Pote\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.qaagility.com ");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void task() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "QAAgility Technologies – Passionately Agile Solutions");

		Dimension size = driver.findElement(By.xpath("//nav[@id='site-navigation']//div[@class='site-logo']"))
				.getSize();
		System.out.println(size);

		Boolean displayy = driver.findElement(By.xpath("//i[@class='fab fa-twitter']")).isDisplayed();
		System.out.println(displayy);
		Assert.assertTrue(true);

		String footer_text1 = driver.findElement(By.xpath("//div[@class='copyright-bar']")).getText();
		System.out.println(footer_text1);
		Assert.assertEquals(footer_text1, "QAAgility Technologies © 2020. All Rights Reserved");

		String footer_text = driver.findElement(By.xpath("//div[@class='copyright-bar']")).getText();
		System.out.println(footer_text);
		Assert.assertEquals(footer_text, "QAAgility Technologies Pvt. Ltd. © 2018. All Rights Reserved");

	}

	@AfterMethod
	public void close_brower() {
		driver.quit();
	}

}
