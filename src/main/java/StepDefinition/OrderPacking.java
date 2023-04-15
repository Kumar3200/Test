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
import Pages.HomePageOutbound;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OrderPacking {

	WebDriver driver;
	LoginPage login;
	HomePageOutbound home;
	String environment;
	String miw="MIW";
	
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
	
	String filepath=System.getProperty("filepath");
	@Given("By using username and password user can login into wms application")
	public void by_using_user_id_and_password_user_can_login_into_wms_application() throws Exception {
		System.out.print(filepath);
		Properties prop=new Properties();
		OutboundXmlextract.xmlExtract(filepath);
		environment=OutboundXmlextract.env;
	    InputStream input = new FileInputStream("src/test/resources/config.properties");
	    prop.load(input);
	    String username=prop.getProperty(environment+".username");
	    String password=prop.getProperty(environment+".password");
	    String url=prop.getProperty(environment+".url");
		System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(url);
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
		Robot robot =new Robot();
		for(int i=0;i<2;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	@Then("search for distribution order UI")
	public void search_for_distribution_order_ui() throws InterruptedException {
		home=new HomePageOutbound(driver);
		Thread.sleep(2000);
		home.clickOnMenuButton();
		Thread.sleep(2000);
		home.clickForSearch();
	}

	@And("search for the specific order")
	public void search_for_the_specific_order() throws InterruptedException {
		home.search_for_order(OutboundXmlextract.orderId);

	}

	@Then("wave the order")
	public void wave_the_order() throws InterruptedException {
		Thread.sleep(2000);
		home.to_wave_the_order();
		Thread.sleep(2000);
		home.double_tab_close();
	}

	@Then("copy the olpn from order")
	public void copy_the_olpn_from_order() throws InterruptedException {
		Thread.sleep(2000);
		home.clickOnMenuButton();
		Thread.sleep(2000);
		home.clickForSearch();
		home.search_for_order(OutboundXmlextract.orderId);
		Thread.sleep(2000);
		home.copy_the_olpn();
		Thread.sleep(2000);
		home.double_tab_close();
	}

	@And("User will search for task in RF menu")
	public void user_will_search_for_task_in_rf_menu() throws InterruptedException {
		home.search_for_Rf_menu();
		Thread.sleep(2000);
	}

	@Then("user will enter the oLpn,ilpn and quantity and weight")
	public void user_will_enter_the_i_lpn_and_quantity_and_weight() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		Thread.sleep(2000);
		if(environment.equals(miw)) {
		home.select_pack_order_and_enter_lpns_and_other_details();
		}
		else {
			home.select_pack_order_and_enter_lpns_phw();
		}

	}

	@And("the order status will be moved to packed")
	public void the_order_status_will_be_moved_to_packed() {
		System.out.println("Order is packed");
	}
}
