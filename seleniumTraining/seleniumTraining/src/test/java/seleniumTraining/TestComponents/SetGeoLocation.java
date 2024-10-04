package seleniumTraining.TestComponents;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;
import org.openqa.selenium.devtools.v125.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.clearBrowserCache());
//		Map<String, Object> coordinates = new HashMap<String, Object>();
//		coordinates.put("latitude", 41);
//		coordinates.put("longitude", 105);
//		coordinates.put("accuracy", 1);
//		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		devtools.send(Emulation.setGeolocationOverride(
                Optional.of(38.2946),
                Optional.of(5.0341),
                Optional.of(338)));
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
				.click();
		String title = driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey.euy28770")).getText();
		System.out.println(title);
		driver.quit();

	}

}
