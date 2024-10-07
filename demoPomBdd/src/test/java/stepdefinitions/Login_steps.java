package stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

@SuppressWarnings("deprecation")
public class Login_steps {
	
	WebDriver driver;
	Home_Page home;
	Login_Page login;
//	Hooks hooks;
	
	public Login_steps() {
    	driver=Hooks.driver;
		login=new Login_Page(driver);
		home=new Home_Page(driver);
	}
	
	

	@Given("user is on login page")
	public void user_is_on_login_page() {
	 
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	}

	@When("user logs in using credentials from Excel file {string} and sheet {string}")
	public void user_logs_in_using_credentials_from_excel_file_and_sheet(String filePath, String sheetName) throws IOException, InterruptedException {
		
		// Load Excel file
		ExcelUtility.loadExcelFile(filePath, sheetName);
		
		// Retrieve user name and password from Excel
        String userName = ExcelUtility.getCellData(1, 0);
        String passWord=ExcelUtility.getCellData(1, 1);
//        login=new Login_Page(driver);
        login.test_login(userName, passWord);
        Thread.sleep(2000);
	 
	}

	@And("clicks Submit button")
	public void clicks_submit_button() {
//		 login=new Login_Page(driver);
	     login.test_submit();
	     
	}

	@Then("Verify the url of logged in page")
	public void verify_the_url_of_logged_in_page() {
	
		String actual_Url=driver.getCurrentUrl();
		String expected_Url="https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(expected_Url, actual_Url);
		Assert.assertTrue(true);
		System.out.println("Actual url is "+actual_Url);
		System.out.println("Expected url is "+expected_Url);
		
		
	}

	@And("Verify the message printed on login page")
	public void verify_the_message_printed_on_login_page() {
//		home=new Home_Page(driver);
		String actual_text=home.getMsgText();
		String expected_text="Congratulations student. You successfully logged in!";
		Assert.assertEquals(expected_text, actual_text);
		Assert.assertTrue(true);
	    System.out.println("Actual text "+actual_text);
	    System.out.println("Expected text "+expected_text);
	}



}
