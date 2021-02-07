package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
public class DashBoardPage extends BasePage {
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver =  driver;
	}
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement Dashboard_Header_Element;

	public void validateDashboardHeader() {
		waitForTheElement(driver, 3, Dashboard_Header_Element);
		Assert.assertEquals(Dashboard_Header_Element.getText(), "Dashboard", "DashboardHeader not found!!" );
	}
}
