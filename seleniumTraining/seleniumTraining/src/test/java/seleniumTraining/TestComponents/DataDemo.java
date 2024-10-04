package seleniumTraining.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDemo
//extends BaseTest 
{

	BaseTest bt = new BaseTest();
//	@DataProvider(name = "getData")
//	public Object[][] getData() {
//		return new Object[][] { { "email", "password" }, { "email", "password" }, { "email", "password" } };
//	}
//
	@Test(dataProvider = "getData")
	public void printData(String email, String password) {
		System.out.println(email);
		System.out.println(password);
	}

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = bt.getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//seleniumtraining//Data//LoginCredentials.json");
		return new Object[][] { { data.get(0) } };

	}
	
	@Test
	public void printDatas() throws IOException {
		System.out.println("-------");
		System.out.println(getData());
	
	}
	
	
	
	
	
	

//	@Test
//	public void returnData() throws IOException {
//		System.out.println(getData().toString());
//	}

}
