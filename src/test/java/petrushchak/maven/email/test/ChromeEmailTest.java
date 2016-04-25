//package petrushchak.maven.email.test;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class ChromeEmailTest {
//	protected static WebDriver webDriverChrome;
//	
//	@BeforeTest
//	public void setup() throws Exception {
//		setChromeDriver();
//		webDriverChrome = new ChromeDriver();
//        
//        webDriverChrome.manage().window().maximize();
//        webDriverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        webDriverChrome.get("http://www.gmail.com");
//        WebElement gmailLogginChrome = webDriverChrome.findElement(By.xpath("//input[@id='Email']"));
//        gmailLogginChrome.sendKeys("petrushchak.maven.test", Keys.ENTER);
//        WebElement gmailPasswdChrome = webDriverChrome.findElement(By.xpath("//input[@id='Passwd']"));
//        gmailPasswdChrome.sendKeys("maven.test.at-14", Keys.ENTER);
//        Thread.sleep(5000);
//        
//	}
//	
//	@AfterTest
//	public void quitChromeDriver() {
//		webDriverChrome.quit();
//	}
//	
//	@Test
//    public void incomingEmailChromeTest() throws InterruptedException {
//            try {Assert.assertTrue(webDriverChrome.findElement(By.xpath("//span[b[contains(text(), 'Hello World')]]")).getText()
//                    .equals("Hello World"), "Лист Hellp World не знайдено");
//            } catch (AssertionError ae) {
//    			ae.printStackTrace();
//            }
//	}
//	
//	@Test
//    public void noIncomingEmailChromeTest() throws InterruptedException {
//		try {Assert.assertFalse(webDriverChrome.findElement(By.xpath("//span[b[contains(text(), 'no email')]]")).getText()
//                .equals("expected email"), "Лист не знайдено!");
//        } catch (AssertionError ae) {
//			ae.printStackTrace();
//        }
//	}
//	
//	private void setChromeDriver() {
//		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
//		String chromeBinary = "c:/Java/workspace/email.test/src/drivers/chromedriver"
//				+ (os.equals("win") ? ".exe" : "");
//		System.setProperty("webdriver.chrome.driver", chromeBinary);
//	}
//
//}
