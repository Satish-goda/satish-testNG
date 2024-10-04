package aimnxt.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableList;

import objectComponents.BaseObject;

public class HomePage extends BaseObject {
	WebDriver driver;
	Actions actions;
	SoftAssert softAssert;
	JavascriptExecutor js;
	DevTools devtools;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = super.driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		devtools = ((HasDevTools) driver).getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("1hb16tum5")));
	}

	@FindBy(css = "#navbar > ul > li")
	private List<WebElement> menuItemSelector;

	@FindBy(css = "nav > ul > li > a")
	private List<WebElement> menusAnchorTag;

	@FindBy(css = "#navbar > ul > li:nth-child(4) > ul > li > a")
	private List<WebElement> partnersinnerMenus;

	@FindBy(css = "#navbar > ul > li:nth-child(2) > ul > li > a")
	private List<WebElement> CourseinnerMenus;

	@FindBy(css = "#navbar > ul > li:nth-child(6) > ul > li > a")
	private List<WebElement> exposureinnerMenus;

	@FindBy(css = "#navbar > ul > li:nth-child(7) > ul > li > a")
	private List<WebElement> formsinnerMenus;

	@FindBy(css = "#navbar > ul > li:nth-child(8) > ul > li > a")
	private List<WebElement> contactinnerMenus;

	@FindBy(css = "nav ul li ul li")
	private List<WebElement> dropdownItem;

	@FindBy(css = ".logo.me-auto")
	private WebElement logo;

	@FindBy(css = "#infinite-scroll > div > div.d-flex.scroll-child.primary.align-items-center")
	private WebElement scrollingOne;

	@FindBy(css = "#infinite-scroll > div > div.d-flex.scroll-child.secondary.align-items-center")
	private WebElement scrollingTwo;

	@FindBy(css = "#image-modal")
	private WebElement popUpInHomePage;

	@FindBy(css = "#image-modal > button")
	private WebElement dismisbtnpopUpInHomePage;

	@FindBy(css = "body > main > section.container.pt-0.pb-0")
	private WebElement carouselItem;

	@FindBy(css = "#navbar > ul > li:nth-child(2) > a")
	private WebElement studyMenuItem;

	@FindBy(css = "#navbar > ul > li:nth-child(2) > ul > li")
	private List<WebElement> studyMenuItemDropDown;

	@FindBy(css = "#navbar > ul > li:nth-child(4) > a")
	private WebElement partnersMenuItem;

	@FindBy(css = "#navbar > ul > li:nth-child(4) > ul > li")
	private List<WebElement> partnerMenuItemDropDown;

	@FindBy(css = "#navbar > ul > li:nth-child(6) > a")
	private WebElement ExposureMenuItem;

	@FindBy(css = "#navbar > ul > li:nth-child(6) > ul > li")
	private List<WebElement> ExposureMenuItemDropDown; //

	@FindBy(css = "#navbar > ul > li:nth-child(7) > a")
	private WebElement FormsMenuItem;

	@FindBy(css = "#navbar > ul > li:nth-child(7) > ul > li")
	private List<WebElement> FormsMenuItemDropDown;

	@FindBy(css = "#navbar > ul > li:nth-child(8) > a")
	private WebElement ContactMenuItem;

	@FindBy(css = "#navbar > ul > li:nth-child(8) > ul > li")
	private List<WebElement> ContactMenuItemDropDown;

	@FindBy(css = "#about > div")
	private WebElement LearnAndGrow;

	@FindBy(css = "#counts> div > div")
	private WebElement counts;

	@FindBy(css = "#why-us> div > div")
	private WebElement whyUs;

	@FindBy(css = "#features > div")
	private WebElement features;

	@FindBy(css = "#popular-courses > div")
	private WebElement popularCourses;

	@FindBy(css = "#hiring-partners-slideshow > div")
	private WebElement hiringPartSlideShow;

	@FindBy(css = "#Success_slide_carousel > div")
	private WebElement successSlideShow;

	@FindBy(css = "#tab-response > div")
	private WebElement leadersSlider;

	@FindBy(css = "#footer >.footer-top > .container > .row ")
	private WebElement footer;

	String[] dropDownItems = { "Study at AimNxt", "Partners", "Exposure", "Forms", "Contact" };

	public void forLoopForHoverEle(WebElement hoverbaleEle, List<WebElement> listelement, ArrayList<String> menuItems) {
		actions.moveToElement(hoverbaleEle).perform();
		waitToAppearWebelement(hoverbaleEle);
		for (WebElement Ele : listelement) {
			menuItems.add(Ele.getText());
		}
	}

	public ArrayList<String> hoverElement(ArrayList<String> menuItems, WebElement menuItem) {
		menuItems.add(menuItem.getText());
		if (menuItem.getText().equalsIgnoreCase(dropDownItems[0])) {
			forLoopForHoverEle(studyMenuItem, studyMenuItemDropDown, menuItems);
		} else if (menuItem.getText().equalsIgnoreCase(dropDownItems[1])) {
			forLoopForHoverEle(partnersMenuItem, partnerMenuItemDropDown, menuItems);
		} else if (menuItem.getText().equalsIgnoreCase(dropDownItems[2])) {
			forLoopForHoverEle(ExposureMenuItem, ExposureMenuItemDropDown, menuItems);
		} else if (menuItem.getText().equalsIgnoreCase(dropDownItems[3])) {
			forLoopForHoverEle(FormsMenuItem, FormsMenuItemDropDown, menuItems);
		} else if (menuItem.getText().equalsIgnoreCase(dropDownItems[4])) {
			forLoopForHoverEle(ContactMenuItem, ContactMenuItemDropDown, menuItems);
		}
		return menuItems;
	}

	ArrayList<String> menuItems = new ArrayList<String>();

	public ArrayList<String> getActualMenuItems() {
		waitToAppearListWebelement(menuItemSelector);
		for (WebElement menuItem : menuItemSelector) {
			hoverElement(menuItems, menuItem);
		}
		return menuItems;
	}

	public void openWebsite() {
		driver.get("https://an.client.godainfotech.com");
	}

	public String expectedUrl() {
		return "https://an.client.godainfotech.com/";
	}

	public boolean islogoDisplaying() {
		boolean logoDisplay = logo.isDisplayed();
		return logoDisplay;
	}

	public boolean isScrollingOneDisplaying() {
		boolean scrollOneDisplay = scrollingOne.isDisplayed();
		return scrollOneDisplay;
	}

	public boolean isScrollingTwoDisplaying() {
		boolean scrollTwoDisplay = scrollingTwo.isDisplayed();
		return scrollTwoDisplay;
	}

	public boolean isHomePopupDisplaying() {
		waitToAppearPopUp(popUpInHomePage);
		Boolean isDisplayed = popUpInHomePage.isDisplayed();
		return isDisplayed;
	}

	public boolean isDismisbtnHomePopUpDisplaying() {
		waitToAppearPopUp(dismisbtnpopUpInHomePage);
		Boolean isDisplayed = dismisbtnpopUpInHomePage.isDisplayed();
		return isDisplayed;
	}

	public void clickDismisBtnHomepagePopUp() {
		waitToAppearPopUp(dismisbtnpopUpInHomePage);
		dismisbtnpopUpInHomePage.click();
	}

	public Boolean disappearHomepagePopUp() {
		waitToDisppearWebelement(popUpInHomePage);
		Boolean isDisplayed = popUpInHomePage.isDisplayed();
		return isDisplayed;
	}

	public Boolean iscarouselItemDisplaying() {
		Boolean isDisplayed = carouselItem.isDisplayed();
		return isDisplayed;
	}

	public Boolean isLearnAndGrowDisplaying() {
		Boolean isDisplayed = LearnAndGrow.isDisplayed();
		return isDisplayed;
	}

	public Boolean isCountsDisplaying() {
		Boolean isDisplayed = counts.isDisplayed();
		return isDisplayed;
	}

	public Boolean iswhyUsDisplaying() {
		Boolean isDisplayed = whyUs.isDisplayed();
		return isDisplayed;
	}

	public Boolean isFeaturesDisplaying() {
		Boolean isDisplayed = features.isDisplayed();
		return isDisplayed;
	}

	public Boolean ispopularCoursesDisplaying() {
		Boolean isDisplayed = popularCourses.isDisplayed();
		return isDisplayed;
	}

	public Boolean ishiringPartSlideShowDisplaying() {
		Boolean isDisplayed = hiringPartSlideShow.isDisplayed();
		return isDisplayed;
	}

	public Boolean issuccessSlideShowSlideShowDisplaying() {
		Boolean isDisplayed = successSlideShow.isDisplayed();
		return isDisplayed;
	}

	public Boolean isleadersSliderShowDisplaying() {
		Boolean isDisplayed = leadersSlider.isDisplayed();
		return isDisplayed;
	}

	public Boolean isfooterDisplaying() {
		Boolean isDisplayed = footer.isDisplayed();
		return isDisplayed;
	}

	public void brokenLinks() throws MalformedURLException, IOException {
		List<WebElement> footerLinks = driver.findElements(By.cssSelector(".footer-links li a"));
		softAssert = new SoftAssert();

		for (WebElement link : footerLinks) {
			System.out.println(footerLinks.get(0).getText());
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			softAssert.assertTrue(respCode < 400,
					"The link with Text" + link.getText() + " is broken with code" + respCode);
		}
		softAssert.assertAll();
	}

	public String[][] getAllTitles() throws InterruptedException {
		String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int j = 0; j < menusAnchorTag.size(); j++) {
			WebElement parentLi = menusAnchorTag.get(j).findElement(By.xpath("..")); // get the parent of "a" menus
			if (parentLi.getAttribute("class").equalsIgnoreCase("dropdown")) {
				if (menusAnchorTag.get(j).getText().equalsIgnoreCase("Study at AimNxt")) {
					innerLoopForTitles(menusAnchorTag, j, CourseinnerMenus, keys, js);
				} else if (menusAnchorTag.get(j).getText().equalsIgnoreCase("Partners")) {
					innerLoopForTitles(menusAnchorTag, j, partnersinnerMenus, keys, js);
				} else if (menusAnchorTag.get(j).getText().equalsIgnoreCase("Exposure")) {
					innerLoopForTitles(menusAnchorTag, j, exposureinnerMenus, keys, js);
				} else if (menusAnchorTag.get(j).getText().equalsIgnoreCase("Forms")) {
					innerLoopForTitles(menusAnchorTag, j, formsinnerMenus, keys, js);
				} else if (menusAnchorTag.get(j).getText().equalsIgnoreCase("Contact")) {
					innerLoopForTitles(menusAnchorTag, j, contactinnerMenus, keys, js);
				}
			} else if (j > 0 && !parentLi.getAttribute("class").equalsIgnoreCase("dropdown")) {
				actions.moveToElement(menusAnchorTag.get(j)).build().perform();
				menusAnchorTag.get(j).sendKeys(keys);
			}
		}
		// List<String> pageTitles = new ArrayList<>();
		Set<String> windowhandlesWithoutSort = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<>(windowhandlesWithoutSort);
		Collections.sort(windowHandles);
		String[][] pageURls = new String[windowHandles.size()][];
		Iterator<String> it = windowHandles.iterator();
		int g = 0;
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			devtools = ((HasDevTools) driver).getDevTools();
			WebElement bodyTag = driver.findElement(By.tagName("body"));
			waitToAppearWebelement(bodyTag);
//			pageTitles.add(driver.getTitle() + " " + driver.getCurrentUrl());
			pageURls[g] = new String[] { driver.getTitle(), driver.getCurrentUrl() };
//			}
			g++;
		}

		for (String[] pageUrl : pageURls) {
			System.out.print("ExpectedTitle :" + pageUrl[0] + "ExpectedUrl   :" + pageUrl[1]);
		}
		return pageURls;

	}

	public void innerLoopForTitles(List<WebElement> menusAnchorTag, int j, List<WebElement> innerMenus, String keys,
			JavascriptExecutor js) throws InterruptedException {

		actions.moveToElement(menusAnchorTag.get(j)).build().perform();
		waitToAppearListWebelement(innerMenus);
		for (WebElement eachMenu : innerMenus) {
			eachMenu.sendKeys(keys);
//			js.executeScript("arguments[0].style.border='1px groove red'", eachMenu);
//			Thread.sleep(1000); // wait for see blinking
//			js.executeScript("arguments[0].style.border=''", eachMenu);

		}
	}
}
