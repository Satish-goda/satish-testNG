package abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderHistory  extends AbstractComponents {

	WebDriver driver;
	
	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	@FindBy(css = "");
	
	
	

}
