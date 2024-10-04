package aimnxt.testPages;

import java.io.IOException;

import org.testng.annotations.Test;
import testComponents.Retry;
import junit.framework.Assert;
import testComponents.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void contentAssertions() throws IOException {
		Assert.assertTrue(hp.islogoDisplaying());
		Assert.assertEquals(hp.expectedUrl(), driver.getCurrentUrl());
		Assert.assertEquals(getExpectedItems("menuItems"), hp.getActualMenuItems());
		Assert.assertTrue(hp.isScrollingOneDisplaying());
		Assert.assertTrue(hp.isScrollingTwoDisplaying());
		Assert.assertTrue(hp.iscarouselItemDisplaying());
	}

	@Test
//	(retryAnalyzer = Retry.class)
	public void HomePagepopUp() throws InterruptedException, IOException {
		Assert.assertTrue(hp.isHomePopupDisplaying());
		Assert.assertTrue(hp.isDismisbtnHomePopUpDisplaying());
		hp.clickDismisBtnHomepagePopUp();
		Assert.assertFalse(hp.disappearHomepagePopUp());
		// Assert.assertEquals(getExpectedItems("expectedPageTitles"),
		// System.out.println(hp.getAllTitles().size());

	}

	@Test
	public void ContentDisplaying() {

		Assert.assertTrue(hp.isLearnAndGrowDisplaying());
		Assert.assertTrue(hp.isCountsDisplaying());
		Assert.assertTrue(hp.iswhyUsDisplaying());
		Assert.assertTrue(hp.isFeaturesDisplaying());
		Assert.assertTrue(hp.ispopularCoursesDisplaying());
		Assert.assertTrue(hp.ishiringPartSlideShowDisplaying());
		Assert.assertTrue(hp.issuccessSlideShowSlideShowDisplaying());
		Assert.assertTrue(hp.isleadersSliderShowDisplaying());
		Assert.assertTrue(hp.isfooterDisplaying());
	}

//	@Test(dependsOnMethods = { "ContentDisplaying" })
//	public void pageTItles() throws InterruptedException {
//		System.out.println(hp.getAllTitles());
//	}

//	@Test(dependsOnMethods = { "ContentDisplaying" })
//	public void footerLinks() throws MalformedURLException, IOException {
//		hp.brokenLinks();
//	}

}
