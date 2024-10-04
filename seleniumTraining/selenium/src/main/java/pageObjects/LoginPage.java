package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailEle;

	@FindBy(id = "password")
	WebElement passwordEle;

	@FindBy(css = "[data-testid=\"submit-btn\"]")
	WebElement loginBtn;

	@FindBy(css = "[data-testid=\"submit-btn\"]")
	WebElement errorMesssage;
	

	public void loginAplication(String email, String password) {
		emailEle.sendKeys(email);
		passwordEle.sendKeys(password);
		loginBtn.click();

	}

	public String getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMesssage));
		return errorMesssage.getText();

	}

}
