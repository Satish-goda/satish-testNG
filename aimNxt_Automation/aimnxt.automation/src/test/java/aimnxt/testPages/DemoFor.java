package aimnxt.testPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class DemoFor {
//	@FindBy(css = ".footer-links li")
//	List<WebElement> footerLinks;

//	List<WebElement> footerLinks = driver.findElements(By.cssSelector(".footer-links li"));
//	SoftAssert softAssert = new SoftAssert();

	public void brokenLinks() throws InterruptedException, MalformedURLException, IOException {
		try {

			ChromeOptions co = new ChromeOptions();
			co.setAcceptInsecureCerts(true);
			WebDriver driver = new ChromeDriver(co);
			driver.get("https://aimnxt.org/");
			List<WebElement> footerLinks = driver.findElements(By.cssSelector(".footer-links li a"));
			SoftAssert softAssert = new SoftAssert();

			for (WebElement link : footerLinks) {
//				System.out.println(footerLinks.get(0).getText());
				String url = link.getAttribute("href");
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int respCode = conn.getResponseCode();
				System.out.println(respCode);
				softAssert.assertTrue(respCode < 400,
						"The link with Text" + link.getText() + " is broken with code" + respCode);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//		Actions act = new Actions(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.get("https://aimnxt.org/");
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		softAssert = new SoftAssert();
//		System.out.println("-----footerLinks------");
//		for (int i = 0; i < footerLinks.size(); i++) {
//			System.out.println(footerLinks.get(i).getText());
//		}
//		System.out.println(footerLinks.size());
//		WebElement ele = driver.findElement(By.id("footer"));
//		js.executeScript("arguments[0].scrollIntoView(true)", ele);
//
//		for (WebElement link : footerLinks) {
//			String url = link.getAttribute("href");
//			System.out.println(url);
//			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//			conn.setRequestMethod("HEAD");
//			conn.connect();
//			int respCode = conn.getResponseCode();
//			System.out.println(respCode);
//			softAssert.assertTrue(respCode < 400,
//					"The link with Text" + link.getText() + " is broken with code" + respCode);
//		}
//		softAssert.assertAll();
//
//		driver.quit();

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		DemoFor df = new DemoFor();
		df.brokenLinks();

	}
}
