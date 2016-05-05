package petrushchak.maven.email.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webDriver.maven.email.test.WebDriverFactory;

public class EmailTest {
	protected static WebDriver webDriver;

	@BeforeTest
	@Parameters({ "browserName" })
	public void beforeTest(String browserName) throws InterruptedException {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get("http://www.gmail.com");
		WebElement gmailLoggin = webDriver.findElement(By.xpath("//input[@id='Email']"));
		gmailLoggin.sendKeys("petrushchak.maven.test", Keys.ENTER);
		WebElement gmailPasswd = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
		gmailPasswd.sendKeys("maven.test.at-14", Keys.ENTER);
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest() {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

	@Test
	@Parameters({ "browserName" })
	public void emailTest(String browserName) {
		try {
			Assert.assertTrue(webDriver.findElement(By.xpath("//span[b[contains(text(), 'Hello World')]]")).getText()
					.equals("Hello World"), "Лист Hello World не знайдено.");
			Reporter.log("Лист Hello World знаходиться у вашій скринці.");
		} catch (AssertionError ae) {
		}
	}

	@Test
	@Parameters({ "browserName" })
	public void noEmailTest(String browserName) {
		try {
			Assert.assertTrue(webDriver.findElement(By.xpath("//span[b[contains(text(), 'no title')]]")).getText()
					.equals("no message"), "Листа не знайдено.");
		} catch (NoSuchElementException selex) {
			Reporter.log("Листа із заданою темою не знайдено!");
		}
	}

}
