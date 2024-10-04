package seleniumTraining.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage; // the object power we took from launchAplication method then tranferred to this
									// varible

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//training//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser"); // if some is giving the property through cammands get that propertyt if
												// not get th eglobal property.

//		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"//home//ctuser//Downloads//geckodriver-v0.35.0-linux-aarch64//geckodriver");
			driver = new FirefoxDriver();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenshot(String testCasename, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCasename + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchAplication() throws IOException {   //work of this,
		driver = initializeDriver(); //calling the driver initialization
		landingPage = new LandingPage(driver); //instasiation of landin page
		landingPage.goTo(); // laiunching the webpage 
		return landingPage; // returning the landing page
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
