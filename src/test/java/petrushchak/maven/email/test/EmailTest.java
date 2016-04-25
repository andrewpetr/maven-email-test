package petrushchak.maven.email.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webDriver.maven.email.test.WebDriverFactory;

public class EmailTest {
	protected static WebDriver webDriver;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void beforeTest(String browserName) {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		
		
		
//		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
//		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get("http://www.gmail.com");
		WebElement gmailLoggin = webDriver.findElement(By.xpath("//input[@id='Email']"));
		gmailLoggin.sendKeys("petrushchak.maven.test", Keys.ENTER);
		WebElement gmailPasswd = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
		gmailPasswd.sendKeys("maven.test.at-14", Keys.ENTER);
	}

	@AfterMethod
	public void afterTest() {
//		webDriver.quit();
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

	@Test
	public void incomingEmailFFoxTest() throws InterruptedException {
		Thread.sleep(5000);
		try {
			Assert.assertTrue(webDriver.findElement(By.xpath("//span[b[contains(text(), 'Hello World')]]")).getText()
					.equals("Hellow World"), "Лист Hello World не знайдено.");
		} catch (AssertionError ae) {
			ae.printStackTrace();
		}

	}

//	@Test
//	public void noIncomingEmailFFoxTest() throws InterruptedException {
//		try {
//			Assert.assertTrue(webDriver.findElement(By.xpath("//span[b[contains(text(), 'no email')]]")).getText()
//					.equals("expected email"), "Лист не знайдено!");
//		} catch (AssertionError ae) {
////			ae.printStackTrace();
//		}
//	}

}
