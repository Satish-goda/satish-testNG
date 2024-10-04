package devTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOnhover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Actions act = new Actions(driver);
		WebElement  ele = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
		act.moveToElement(ele).build().perform();
		

	}



}
