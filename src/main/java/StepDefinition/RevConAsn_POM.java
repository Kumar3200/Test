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
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RevConAsn_POM {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	String username;
	String password;
	String environment;
	String miw="MIW";
	String reserve;

	String filepath=System.getProperty("filepath");
	@Given("the user navigates to WMS Login Page")
	public void the_user_navigates_to_wms_login_page() throws Exception {
		System.out.print(filepath);
		Properties prop=new Properties();
		XmlExtractForCon.the_Conversion_asn_xml_extract(filepath);
		environment=XmlExtractForCon.env;
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
		Thread.sleep(2000);
		driver.get(url);

	}

	@When("the user needs to enter the username and password")
	public void the_user_needs_to_enter_the_username_and_password() throws Exception {
		Thread.sleep(2000);
		login = new LoginPage(driver);
		login.Login_page_credentials_enter(username, password);
		Thread.sleep(2000);
		if(environment.equals(miw)) {
			Thread.sleep(1000);
		}
		else {
			login.Login_page_phw();
		}
		Thread.sleep(2000);
	}

	@Then("user is taken to WMS homepage")
	public void user_is_taken_to_wms_homepage() throws Exception {
		System.out.print("User is on the home page");
		Robot robot =new Robot();
		for(int i=0;i<2;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	@When("user searches RF menu in WMS and selects inbound transaction")
	public void user_searches_rf_menu_in_wms_and_selects_inbound_transaction() throws Exception {
		home=new HomePage(driver);
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

	@Then("user selects Receive Conversion")
	public void user_selects_receive_conversion() throws Exception {
		Thread.sleep(2000);
		home.click_on_revconversion();
        Thread.sleep(2000);

	}

	@And("the user will enter the ASN")
	public void the_user_will_enter_ASN() throws Exception {
		home.enter_the_conv_asn(XmlExtractForCon.conAsnId);
	}

	@Then("the user enters the batch and location")
	public void the_user_enters_the_batch() throws Exception {
		home.enter_the_control_and_location(XmlExtractForCon.batchValues,XmlExtractForCon.qtyValues,reserve);
	}

	@Then("the user opens ASN menu and verify the asn")
	public void the_user_opens_asn_menu() throws Exception {
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		home.closing_the_screen();
		home.user_search_for_asnui();
		Thread.sleep(5000);
		home.user_enter_the_asn_and_Search_it(XmlExtractForCon.conAsnId);
		Thread.sleep(2000);
		home.closing_the_screen();
		Thread.sleep(2000);
	}

	@And("the ASN is verified")
	public void the_asn_is_verified() {
		System.out.println("Asn is receiving verified");
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
