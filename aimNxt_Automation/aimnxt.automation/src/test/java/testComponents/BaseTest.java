package testComponents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableList;

import aimnxt.pageObjects.HomePage;

public class BaseTest {

	public WebDriver driver;
	public HomePage hp;
	public ChromeOptions chromeOptions;

	public WebDriver initializeDriver() {

//		Properties prop = new Properties();
//		FileInputStream fileIS = new FileInputStream();
//		DesiredCapabilities ch=DesiredCapabilities.chrome();
		// ch.acceptInsecureCerts();
//		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// Belows to your local browser
//		ChromeOptions c= new ChromeOptions();

		chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(chromeOptions);
		DevTools devtools = ((HasDevTools) driver).getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("1hb16tum5")));

		return driver;
	}

	public static ArrayList<String> getExpectedItems(String array) throws IOException {
		String jsonFile = new String(Files.readAllBytes(
				Paths.get(System.getProperty("user.dir") + "//src//test//java//aimnxt//data//data.json")));
		JSONObject jsonObject = new JSONObject(jsonFile);
		JSONArray itemsArray = jsonObject.getJSONArray(array);
//		System.out.println(contentArray);
		ArrayList<String> items = new ArrayList<String>();
		items.clear();
		for (int i = 0; i < itemsArray.length(); i++) {
			items.add(itemsArray.getString(i).toString());
		}
		return items;
	}

	@BeforeMethod
	public void setup() {
		driver = initializeDriver();
		hp = new HomePage(driver);
		hp.openWebsite();
		driver.manage().window().maximize();
		

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
//		if (this.driver != null) {
//			this.driver = null;
//			this.driver.quit();
//		}
		driver.quit();

	}

}
