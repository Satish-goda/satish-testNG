package seleniumTraining.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductCatalogue;
import seleniumTraining.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	
	public void submitOrder(HashMap<String, String> data) throws InterruptedException, IOException {

		ProductCatalogue productCataloguec = landingPage.loginAplication(data.get("email"), data.get("password")); //landing.loginaplication is working just because of inheritance
		List<WebElement> products = productCataloguec.getProductsList();
		productCataloguec.addProductToCard(data.get("productName"));
		CartPage cartPage = productCataloguec.goToCartpage();
		Boolean match = cartPage.verifyProductsDisplayed(productName);
		Assert.assertTrue(match);
		CheckOutPage CheckOutPage = cartPage.goToCheckout();
		CheckOutPage.selectCountry("india");
		ConfirmationPage ConfirmationPage = CheckOutPage.submitOrder();
		String ConfirmationMessage = ConfirmationPage.getConfirmation();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}

	
	
	
	
	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistorypageTest() throws InterruptedException {

		ProductCatalogue productCataloguec = landingPage.loginAplication("satishpractice8@gmail.com", "Satish@123");
		OrderHistoryPage orderHistoryPage = productCataloguec.GotoOrderPage();
		Assert.assertTrue(orderHistoryPage.verifyOrderDisplayed(productName));
	}


//	public Object[][] getData() {
//		return new Object[][] { { "satishpractice8@gmail.com", "Satish@123", "IPHONE 13 PRO" },{ "satishpractice88@gmail.com", "Satish@123", "IPHONE 13 PRO" } };
//	}

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//seleniumtraining//Data//LoginCredentials.json");
		return new Object[][] { { data.get(0) } };

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "satishpractice8@gmail.com");
//		map.put("password", "Satish@123");
//		map.put("productName", "IPHONE 13 PRO");
//		return new Object[][] { { map } };
	}

}
