package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	
	@FindBy(name="username")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement butn_submit;

	//action methods
	
    public void test_login(String username,String password) {
    	txt_username.sendKeys(username);
    	txt_password.sendKeys(password);
    }
    
    public void test_submit() {
    	butn_submit.click();
    }
}
