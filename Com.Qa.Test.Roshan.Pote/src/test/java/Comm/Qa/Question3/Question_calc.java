package Comm.Qa.Question3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Question_calc {

	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() {

		System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://ata123456789123456789.appspot.com/");

	}

	@Test
	public void result() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("ID_nameField1")).sendKeys("7");
		driver.findElement(By.id("ID_nameField2")).sendKeys("4");
		driver.findElement(By.id("gwt-uid-7")).click();
		driver.findElement(By.id("ID_calculator")).click();
		Thread.sleep(500);
		String result = driver.findElement(By.id("ID_nameField3")).getAttribute("value");
		System.out.println(result);

	}
}
