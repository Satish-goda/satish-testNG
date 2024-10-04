package devTools;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkCalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.webp")));    twk-chunk-bf24a88e.js
		devtools.send(Network.setBlockedURLs(ImmutableList.of("twk-chunk-*")));    

//		long startTime = System.currentTimeMillis();
		driver.get("https://aimnxt.org");
		

	}

}
