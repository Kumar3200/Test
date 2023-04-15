package StepDefinition;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RevTran_POM  {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	String username;
	String password;
	String environment;
	String miw="MIW";
	String nor="NOR";
	String reserve;
	
	String filepath=System.getProperty("filepath");
	@Given("the user goes to WMS Login Page")
	public void the_user_goes_to_wms_login_page() throws Exception {
		System.out.print(filepath);
		Properties prop=new Properties();
		XmlExtractForTran.transfer_asn_xml_extract(filepath);
		environment=XmlExtractForTran.env;
		InputStream input = new FileInputStream("src/test/resources/config.properties");
	    prop.load(input);
		username=prop.getProperty(environment+".username");
	    password=prop.getProperty(environment+".password");
	    String url=prop.getProperty(environment+".url");
		reserve=prop.getProperty(environment+".reserve");
		System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get(url);

	}

	@When("the user enters the username and password")
	public void the_user_enters_the_username_and_password() throws Exception {
		Thread.sleep(3000);
		login = new LoginPage(driver);
		login.Login_page_credentials_enter(username, password);
		Thread.sleep(2000);
		if(environment.equals(miw)) {
			Thread.sleep(1000);
		}
		else {
			login.Login_page_phw();
		}
	}

	@Then("user is in the WMS homepage")
	public void user_is_in_the_wms_homepage() throws Exception {
		System.out.print("User is on the home page");
		Robot robot =new Robot();
		for(int i=0;i<2;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	@When("the user searches RF menu and selects the inbound")
	public void the_user_search_for_rf_menu_and_selects_the_inbound() throws Exception {
		home=new HomePage(driver);
		Thread.sleep(2000);
		home.search_for_rf();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		if(environment.equals(miw)) {
			home.click_on_bulk();
			Thread.sleep(2000);
			home.click_on_receiving();
		}
		else {
			home.click_on_inbound();
		}

	}

	@Then("the user  selects the Receive XO")
	public void the_user_selects_the_receive_xo() throws Exception {
		Thread.sleep(3000);
		if(environment.equals(miw)||environment.equals(nor)) {
			home.click_on_page_down();
			Thread.sleep(2000);
			home.click_on_recXo_miami();
		}
		else {
			home.click_on_revXo();
		}

	}

	@And("the user selects the Receive ilpn ASN")
	public void the_user_selects_the_receive_ilpn_asn() throws Exception {
		Thread.sleep(3000);
			home.click_on_recv_ilpn_asn();
	}

	@When("the user enters the ASN")
	public void the_user_enters_the_asn() throws Exception {
		Thread.sleep(3000);
		home.enter_the_tran_asn(XmlExtractForTran.asnId);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ASN :"+XmlExtractForTran.asnId, ExtentColor.GREEN));
		Thread.sleep(3000);
	}

	@And("the user enters the ilpn")
	public void the_user_enters_the_ilpn_to_receive() throws Exception {
		home.enter_the_ilpn(XmlExtractForTran.ilpnValues);
	}

	@Then("the user verifies the ASN")
	public void the_user_verifies_the_asn() throws Exception {
		Thread.sleep(2000);
		home.verify_the_tran_asn();
	}

	@And("the status of ASN moves to receiveing verified")
	public void the_status_of_asn_moves_to_receiveing_verified() {
		System.out.print("ASN is receiving verified");
	}
	@Then("user will select Ptwy User Dir")
	public void user_will_select_ptwy_user_dir() throws Exception {
		Thread.sleep(2000);
		home.select_the_putaway_userdir();
	}

	@And("the user will enter iLpn and location")
	public void the_user_will_enter_i_lpn() throws Exception {
		Thread.sleep(3000);
		home.enter_the_ilpn_for_putaway(XmlExtractForTran.ilpnValues,reserve);
	}
	@And("the putaway is done")
	public void the_putaway_is_done() throws Exception {
		System.out.print("Putaway is done.");
		driver.switchTo().parentFrame();
		home.closing_the_screen();
	}
	@After
	public void before_or_after(Scenario scenario) {
		if(driver!=null) {
			if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot");
		}
			driver.quit();
	}
	}
}
