package seleniumTraining.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import seleniumTraining.TestComponents.Retry;
import seleniumTraining.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void errorValidation() {
		landingPage.loginAplication("username", "password"); 																	// the power of class call is getting from landingpage
																															// varible // parent class that is baseTest
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

}
