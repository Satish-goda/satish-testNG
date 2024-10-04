package autoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		driver.findElement(By.cssSelector("#pickfiles")).click();
		Runtime.getRuntime().exec("C:\\Users\\ctuser\\Downloads\\uploadFile.exe"); // runtime.getRuntime().exec is used
																					// to run exe files in java

	}

}
