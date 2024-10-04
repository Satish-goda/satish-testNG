package seleniumTraining.TestComponents;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	
	@DataProvider(name = "getData")
	public Object[][] getData() {
	return new Object[][] { 
		{ "satishpractice8@gmail.com", "Satish@126663" },
		{ "satishpractice88@gmail.com", "Satish@123" } 
	};
	}
	
	@Test(dataProvider = "getData")
	public void Data(String email,String emaill) {
		System.out.println(email);
		System.out.println(emaill);
		
		
	}
	
	 

	
//	@DataProvider(name = "data-provider")
//	  public Object[][] dataProviderMethod() {
//	    return new Object[][]{{"data one"}, {"data two"}};
//	  }
//
//	  @Test(dataProvider = "data-provider")
//	  public void testMethod(String data) {
//	    System.out.println("Data is: " + data);
//	  }
	
}