package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LogInPage;
import util.BrowserFactory;

public class addCustomerTest {
	
	WebDriver driver;
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
		
		driver = BrowserFactory.init();
		LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
		logInPage.enterUserName(userName);
		logInPage.enterPassword(password);
		logInPage.clickToSignin();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickOnCustomerField();
		addCustomerPage.clickAddCustomerField();
		
		addCustomerPage.insertUserName(fullName);
		addCustomerPage.insertCompanyName(companyName);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertStreetAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.enterCountryName(country);
		addCustomerPage.selectGroupName("AUG 2020");
		addCustomerPage.clickToSave();
		Thread.sleep(3000);
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.insertEnteredNameInSearchBarOnListCustomerPage();
//		DashBoardPage dashbaoBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
//		dashbaoBoardPage.validateDashboardHeader();
		addCustomerPage.verifyEnteredNameAndDelete();
		addCustomerPage.clickToDelete();
		BrowserFactory.tearDown();

		
	}

}
