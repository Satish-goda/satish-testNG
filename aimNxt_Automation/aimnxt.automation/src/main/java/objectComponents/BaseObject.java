package objectComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseObject {

	protected WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public BaseObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);

	}

	public void waitToAppearPopUp(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(16));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitToDisppearWebelement(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void waitToAppearWebelement(WebElement hoverbaleEle) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElements(hoverbaleEle));
	}

	public void waitToAppearListWebelement(List<WebElement> courseinnerMenus) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElements(courseinnerMenus));
	}

	public void hoverCoursesClickCourse(WebElement coursesMenu, WebElement course) {
		actions.moveToElement(coursesMenu);
		course.click();
	}

}
