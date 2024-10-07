package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	

	WebDriver driver;
	public Home_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//strong[contains(text(),'Congratulations student. You successfully logged i')]")
	WebElement txt_msg;
	
	
	public String getMsgText() {
		String text=txt_msg.getText();
		return text;
	}

}
