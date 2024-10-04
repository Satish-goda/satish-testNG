package seleniumTraining.TestComponents;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.fetch.Fetch;

public class NetworkingMoking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty())); // Fetch.enable = Enables issuing of
																			// requestPaused events. A
																			// request will be paused until client calls
																			// one of failRequest, fulfillRequest or
																			// continueRequest/continueWithAuth.
		devTools.addListener(Fetch.requestPaused(), request -> {

			System.out.println("request.getRequest().getUrl()");
			System.out.println(request.getRequest().getUrl());
			if (request.getRequest().getUrl().endsWith("shetty")) {

				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("----mockedUrl-----");
				System.out.println(mockedUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.empty(), // continueRequest
																														// =
																														// Continues
																														// the
																														// request,
																														// optionally
																														// modifying
																														// some
																														// of
																														// its
																														// parameters.
						Optional.empty(), Optional.empty(), Optional.empty()));

			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

			}

		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());

	}

}
