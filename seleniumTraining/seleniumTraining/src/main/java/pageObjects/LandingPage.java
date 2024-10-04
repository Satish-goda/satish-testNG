package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	ProductCatalogue ProductCatalogue;
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement usernameEle;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMesssage;

	public ProductCatalogue loginAplication(String email, String password) {
		usernameEle.sendKeys(email);
		passwordEle.sendKeys(password);
		loginBtn.click();
		ProductCatalogue = new ProductCatalogue(driver);
		return ProductCatalogue;
	}

	public String getErrorMessage() {
		waitfForWebElementToAppear(errorMesssage);
		return errorMesssage.getText();

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
