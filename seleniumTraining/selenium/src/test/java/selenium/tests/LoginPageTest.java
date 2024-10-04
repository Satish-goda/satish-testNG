package selenium.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class LoginPageTest {

	WebDriver driver;
	LoginPage LoginPageObject;
		
	@BeforeMethod
	public void setUp() {
	//initial setup and all will be here	
	driver = new ChromeDriver(); 
	driver.get("http://localhost:5173/login");
	driver.manage().window().maximize();
	}
	
	
	@Test
	public void accesingThePageObjectMethods() {
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.loginAplication("email","password");
		System.out.println(LoginPageObject.getErrorMessage());
		
	
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
