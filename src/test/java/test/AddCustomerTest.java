package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	@Test
	@Parameters({"UserName", "password", "dashboardHeaderText", "addContactHeaderText", "FullName", "CompanyName", "Email", "Phone","Address", "City","State", "Zip", "Country"})
	public void userShouldBeAbleToAddCustomer(String userName, String password, String dashboardHeaderText,String addCustomerValidationText, String fullName, String company,String email, String phone, String address, String city, String state,String zip,String country) throws InterruptedException {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderText);
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyName(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickOnSaveButton();
		
		dashboardPage.clickListCustomerButton();
		
		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.validateInsertedNameAndDelete();
		
	}

}
