//package StepDefinition;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import Pages.HomePageOutbound;
//import Pages.LoginPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//
//
//public class Out {
//	WebDriver driver;
//	LoginPage login;
//	HomePageOutbound home;
//	
//	@Given("^using (.*) and (.*) user can login into wms application$")
//	public void using_jzzg_and_3200jeeva_user_can_login_into_wms_application(String username,String password) throws Exception {
//		System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver.exe");
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");
//		driver=new ChromeDriver(co);
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		driver.get("https://mia-wms-uat.corp.boeingdistribution.com/manh/index.html?_dc=1679547165816&i=289&idp=uat_mip_mia_2017");
//		Thread.sleep(2000);
//		login = new LoginPage(driver);
//		login.Login_page_credentials_enter(username, password);
//		Thread.sleep(2000);
//		Robot robot =new Robot();
//		for(int i=0;i<2;i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//		}
//	}
//
//	@Given("will search for task in RF menu")
//	public void will_search_for_task_in_rf_menu() throws Exception {
//		home=new HomePageOutbound(driver);
//		home.search_for_Rf_menu();
//		Thread.sleep(2000);
//	}
//
//	@And("^will enter the (.*),ilpn and (.*) and weight$")
//	public void will_enter_the_o_lpn_ilpn_and_quantity_and_weight(String olpn,String qty) throws Exception {
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
//		Thread.sleep(2000);
//		home.select_pack_order_and_enter_lpns_and_other_details1(olpn,qty);
//	}
//
//	@And("order status will be moved to packed")
//	public void order_status_will_be_moved_to_packed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//}
