package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="username")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="loginButton")
	WebElement btn_loginButton;
	
	@FindBy(id="list")
	WebElement btn_list;
	
	@FindBy(id="go")
	WebElement btn_go;
	
 
 public LoginPage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 
 
 public void Login_page_credentials_enter(String username,String password) {
	 txt_username.sendKeys(username);
	 txt_password.sendKeys(password);
	 btn_loginButton.click();
	 
 }
 
 public void Login_page_phw() {
	 btn_list.click();
	 btn_go.click();
 }
	

}
