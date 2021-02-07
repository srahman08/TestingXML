package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import page.LogInPage;
import util.BrowserFactory;


public class loginTest {
	WebDriver driver;
	
//	String userName = null;
//	String password = null;
	@Test
	@Parameters ({"username", "password"})

	public void userLogInScenario(String userName, String password) {

		driver = BrowserFactory.init();

		LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
		logInPage.enterUserName(userName);
		logInPage.enterPassword(password);
		logInPage.clickToSignin();
		
		/*
		 * BrowserFactory browserFactory = PageFactory.initElements(driver,
		 * BrowserFactory.class); browserFactory.tearDown();
		 */
	}

}
