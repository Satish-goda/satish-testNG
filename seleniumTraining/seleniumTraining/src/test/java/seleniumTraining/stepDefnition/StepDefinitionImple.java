package seleniumTraining.stepDefnition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;
import seleniumTraining.TestComponents.BaseTest;

public class StepDefinitionImple extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchAplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void loged_in_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginAplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {

		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCard(productName);
	}
	@When ("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String prodcutName) throws InterruptedException {
		CartPage cartPage = productCatalogue.goToCartpage();
		Boolean match = cartPage.verifyProductsDisplayed(prodcutName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
		
	}
	
	@Then("{string} message is displayed on ConfirmPage")
	public void message_displayed_confirmationPage(String string) {
		String confirmMessage = confirmationPage.getConfirmation();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	

}
