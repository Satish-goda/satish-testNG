package devTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(true, 3000, 20000, 100000, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));//false to accesss internet
		
		devtools.addListener(Network.loadingFailed(), loadingFailed -> {
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		long startTime = System.currentTimeMillis();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
				.click();
		String title = driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey.euy28770")).getText();
		System.out.println(title);
		long endTIme = System.currentTimeMillis();
		System.out.println(startTime-endTIme);
		driver.quit(); 
		

		
	}

}
