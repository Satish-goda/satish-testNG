package abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/home/ctuser/Downloads/geckodriver-v0.35.0-linux-aarch64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("");
	}

}
