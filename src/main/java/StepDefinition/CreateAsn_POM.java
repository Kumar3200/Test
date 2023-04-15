package StepDefinition;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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

public class CreateAsn_POM {
	public String genAsn;
	public String createIlpn;
	WebDriver driver;
	LoginPage login;
	HomePage home;
	String environment;
	String miw="MIW";
	String nor="NOR";
	String reserve;
	ArrayList<String> ilpns=new ArrayList<String>();

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
	
	@Given("the user is able to login the WMS application sucessful with user id and password")
	public void the_user_is_able_to_login_the_wms_application_sucessful_with_user_id_and_password() throws Exception {
		System.out.print(filepath);
		Properties prop=new Properties();
		XmlExtractForPo.po_xml_extract_file(filepath);
		environment=XmlExtractForPo.env;
		InputStream input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		String username=prop.getProperty(environment+".username");
		String password=prop.getProperty(environment+".password");
		String url=prop.getProperty(environment+".url");
		reserve=prop.getProperty(environment+".reserve");
		System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
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
	}

	@When("the user search for Create ASN from PO menu and select it")
	public void the_user_search_for_create_asn_from_po_menu_and_select_it() throws Exception {
		Robot robot =new Robot();
		for(int i=0;i<2;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		home = new HomePage(driver);
		home.click_on_menu();
		Thread.sleep(2000);
		home.search_for_create_asn_from_Po();
	}

	@Then("the user paste the po and search it")
	public void the_user_paste_the_po_and_search_it() throws Exception {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		home.search_for_po(XmlExtractForPo.po);
	}

	@When("the user  click on  Generate ASN and select the date of delivery and click ok")
	public void the_user_click_on_generate_asn_and_select_the_date_of_delivery_and_click_ok() throws Exception {
		Thread.sleep(2000);
		home.generate_asn();
	}

	@Then("the genrated ASN will be on the screen")
	public void the_genrated_asn_will_be_on_the_screen() {
		System.out.println("The ASN is generated");
	}

	@When("the user click on check box for both ASN and PO and clicks on the arrow facing right side and clicks on save")
	public void the_user_click_on_check_box_for_both_asn_and_po_and_clicks_on_the_arrow_facing_right_side_and_clicks_on_save() throws Exception {
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		home.click_on_both_check_box();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		home.closing_the_screen();
	}

	@Then("the asn will be in transit")
	public void the_asn_will_be_in_transit() {
		System.out.println("ASN is in transit");
	}
	@When("the user search for RF menu and select it")
	public void the_user_search_for_rf_menu_and_select_it() throws Exception {
		driver.switchTo().parentFrame();
		home.search_for_rf();
		Thread.sleep(3000);

	}

	@Then("the user select the Inbound option")
	public void the_user_select_the_inbound_option() throws Exception {
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

	@And("the user select the Receive Item lvl menu")
	public void the_user_select_the_receive_item_lvl_menu() throws Exception {
		Thread.sleep(2000);
		home.click_on_recv_item_lvl();
	}

	@When("the user enters the ASN number")
	public void the_user_enter_the_ASN_number() throws Exception {
		Thread.sleep(2000);
		home.enter_the_Po_asn();
		Thread.sleep(2000);
	}

	@When("the user enter the PO")
	public void the_user_enter_the_po() {
		home.enter_the_PO(XmlExtractForPo.po);
	}

	@Then("the user enter the Business Partner")
	public void the_user_enter_the_business_partner() throws Exception {
		Thread.sleep(2000);
		home.enter_the_Bp(XmlExtractForPo.bp);

	}

	
	@Then("the ilpn and control number is generated and item and quantity entered")
	public void the_ilpn_and_control_is_generated() throws Exception {
		for(int i=0;i<XmlExtractForPo.itemValues.size() && i<XmlExtractForPo.qtyValues.size();i++) {
		Thread.sleep(2000);
		home.generate_the_ilpn();
		Thread.sleep(2000);
		home.click_on_accept();
		Thread.sleep(2000);
		createIlpn = driver.findElement(By.id("csid")).getText();
		String str[]=createIlpn.split("\n");
		createIlpn=str[1];
		System.out.println(createIlpn);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ILPN :"+createIlpn, ExtentColor.GREEN));
		ilpns.add(createIlpn);
		Thread.sleep(2000);
		home.enter_the_item_Po(XmlExtractForPo.itemValues.get(i));
		Thread.sleep(2000);
		home.enter_the_lot();
		Thread.sleep(2000);
		home.click_on_accept();
		Thread.sleep(2000);
		home.enter_the_po_quantity(XmlExtractForPo.qtyValues.get(i));
		
		}
	}

	@Then("Qty is confirmed and Asn moves to Receiving started")
	public void qty_is_confirmed_and_asn_moves_to_receiving_started() {
		System.out.println("Asn is in Receiving Started");
	}

	@And("the user clicks on verify ASN")
	public void the_user_clicks_on_verify_asn() throws Exception {
		home.verify_the_Po_asn();

	}

	@Then("the ASN is now in receiving verified status")
	public void the_asn_is_now_in_receiving_verified_status() throws Exception {
		System.out.print("The asn is in receiving verified");
	}
	@Then("user have to select Ptwy User Dir")
	public void user_have_to_select_ptwy_user_dir() throws Exception {
		Thread.sleep(2000);
		home.select_the_putaway_userdir();
	}

	@And("the user will have to enter iLpn and location")
	public void the_user_will_enter_i_lpn() throws Exception {
		Thread.sleep(3000);
		home.enter_the_ilpn_for_putaway(ilpns,reserve);
	}

	@And("the putaway has been done")
	public void the_putaway_is_done() throws Exception {
		System.out.print("Putaway is done.");
		driver.switchTo().parentFrame();
		home.closing_the_screen();
		Thread.sleep(2000);
	}

}
