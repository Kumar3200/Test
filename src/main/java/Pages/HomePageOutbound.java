package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class HomePageOutbound {
	public WebDriver driver;
	String Ilpn;
	List<String>olpnValues;
	List<String>qtyValues;

	public HomePageOutbound(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//a[1]//span[1]//span[1]//span[1]")
	WebElement btn_Menu;

	@FindBy(xpath = "//input[@role='combobox']")
	WebElement btn_SearchField;

	@FindBy(xpath="//body/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div/div/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement btn_ord_filter;

	@FindBy(xpath="//div[@data-ref='containerEl']//div[@role='presentation']//div[@role='presentation']//div//input[@role='combobox']")
	WebElement txt_ord_num;

	@FindBy(xpath="//span[@data-ref='btnInnerEl'][normalize-space()='Apply']")
	WebElement btn_apply;

	@FindBy(xpath="//div[@class='x-grid-row-checker']")
	WebElement btn_checkbox;

	@FindBy(xpath="//span[contains(text(),'More')]")
	WebElement btn_more;

	@FindBy(xpath="//span[normalize-space()='Wave']")
	WebElement opt_wave;

	@FindBy(xpath="//span[normalize-space()='Collins Wave']")
	WebElement opt_collins_wave;

	@FindBy(xpath="//input[contains(@value,'Submit')]")
	WebElement btn_submit;

	@FindBy(id="button-1025-btnIconEl")
	WebElement btn_right_top;

	@FindBy(xpath="//*[text()='Close']")
	WebElement btn_close;

	@FindBy(xpath="//body/div[contains(@class,'x-container wt-unifiedpanel x-layer x-container-default x-layout-fit x-border-box x-resizable x-container-resizable x-container-default-resizable')]/div[contains(@class,'x-fit-item x-panel-default')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]")
	WebElement btn_doubletab_close;

	@FindBy(xpath="//span[contains(@data-ref,'btnInnerEl')][normalize-space()='View']")
	WebElement btn_view;

	@FindBy(xpath="//a[normalize-space()='LPNs']")
	WebElement btn_lpntab;

	@FindBy(xpath="//span[@id='dataForm:DODetailsLpnList_lv:LPNListTable:0:LPNListTPM_Link_NameText_param_out']")
	WebElement value_olpn;

	@FindBy(xpath="//a[normalize-space()='Bulk']")
	WebElement btn_bulk;

	@FindBy(xpath="//a[normalize-space()='Order Fill']")
	WebElement btn_orderFill;

	@FindBy(xpath="//a[normalize-space()='Pck Cubed Dir']")
	WebElement btn_pck_cubed_dir;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_input_search;

	@FindBy(xpath="//div[@class='caption']//span[@class='captionData']")
	WebElement txt_ilpn_copy;

	@FindBy(xpath="//span[contains(@title,'Ctrl-A Accpt/Proceed')]")
	WebElement btn_accept_proceed;

	@FindBy(xpath="//body[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement btn_error_accept;

	@FindBy(xpath="//a[normalize-space()='Outbound']")
	WebElement btn_outbound;


	public void clickOnMenuButton()
	{
		btn_Menu.click();
	}

	public void clickForSearch() throws InterruptedException
	{
		btn_SearchField.sendKeys("Distribution Orders");
		Thread.sleep(1000);
		btn_SearchField.sendKeys(Keys.ENTER);
	}
	public void search_for_order(String order) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn_ord_filter));
		btn_ord_filter.click();
		Thread.sleep(1000);
		btn_ord_filter.sendKeys("Distribution Order");
		Thread.sleep(2000);
		btn_ord_filter.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		txt_ord_num.sendKeys(order);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("Order :"+order, ExtentColor.GREEN));
		Thread.sleep(2000);
		btn_apply.click();

	}
	public void to_wave_the_order() throws InterruptedException {
		btn_checkbox.click();
		Thread.sleep(2000);
		btn_more.click();
		Thread.sleep(2000);
		opt_wave.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.doubleClick(opt_collins_wave).perform();
		Thread.sleep(2000);
		btn_submit.click();
		Thread.sleep(2000);
	}

	public void double_tab_close() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		btn_right_top.click();
		Thread.sleep(2000);
		btn_doubletab_close.click();
		Thread.sleep(2000);
		btn_doubletab_close.click();

	}

	public void close_the_screen() throws InterruptedException {
		btn_right_top.click();
		Thread.sleep(2000);
		btn_close.click();
	}

	public void copy_the_olpn() throws InterruptedException {
		btn_checkbox.click();
		Thread.sleep(2000);
		btn_view.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		btn_lpntab.click();
		Thread.sleep(2000);
		List<WebElement> olpnCol=driver.findElements(By.xpath("//body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[3]/div[11]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/table[1]//tr/td[2]"));
		List<WebElement> qtyCol=driver.findElements(By.xpath("//body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[3]/div[11]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/table[1]//tr/td[7]"));
		qtyValues=new ArrayList<>();
		olpnValues=new ArrayList<>();
		for(WebElement columnValue : olpnCol) {
			olpnValues.add(columnValue.getText());
		}
		for(String value:olpnValues) {
			System.out.println(value);
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("OLPN :"+value, ExtentColor.GREEN));
		}
		for(WebElement columnValue : qtyCol) {
			qtyValues.add(columnValue.getText());
		}
		for(String value:qtyValues) {
			System.out.println(value);
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("OLPN :"+value, ExtentColor.GREEN));
		}
		//Olpn=value_olpn.getText();


	}

	public void search_for_Rf_menu() throws InterruptedException {
		btn_Menu.click();
		Thread.sleep(2000);
		btn_SearchField.sendKeys("RF Menu");
		Thread.sleep(2000);
		btn_SearchField.sendKeys(Keys.ENTER);
	}
	public void select_pack_order_and_enter_lpns_phw() throws InterruptedException {
		btn_outbound.click();
		Thread.sleep(2000);
		btn_pck_cubed_dir.click();
		Thread.sleep(2000);
		for(int i=0;i<olpnValues.size() && i<qtyValues.size();i++) {
			txt_input_search.sendKeys(olpnValues.get(i));
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Ilpn=txt_ilpn_copy.getText();
			Thread.sleep(2000);
			txt_input_search.sendKeys(Ilpn);
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			txt_input_search.sendKeys(qtyValues.get(i));
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement error=driver.findElement(By.id("dataForm"));
			String element=error.getText();
			String str="Warning!"+'\n'+"Is ILPN consumed Enter Accept/proceed for Yes and Prev for NO";
			if(element.contains(str)) {
				btn_error_accept.click();
			}
			Thread.sleep(2000);
			txt_input_search.sendKeys("1");
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			btn_accept_proceed.click();
			Thread.sleep(2000);
		}
	}

	public void select_pack_order_and_enter_lpns_and_other_details() throws InterruptedException {
		btn_bulk.click();
		Thread.sleep(2000);
		btn_orderFill.click();
		Thread.sleep(2000);
		btn_pck_cubed_dir.click();
		Thread.sleep(2000);
		for(int i=0;i<olpnValues.size() && i<qtyValues.size();i++) {
			txt_input_search.sendKeys(olpnValues.get(i));
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Ilpn=txt_ilpn_copy.getText();
			Thread.sleep(2000);
			txt_input_search.sendKeys(Ilpn);
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			txt_input_search.sendKeys(qtyValues.get(i));
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement error=driver.findElement(By.id("dataForm"));
			String element=error.getText();
			String str="Warning!"+'\n'+"Is ILPN consumed Enter Accept/proceed for Yes and Prev for NO";
			if(element.contains(str)) {
				btn_error_accept.click();
			}
			Thread.sleep(2000);
			txt_input_search.sendKeys("1");
			Thread.sleep(2000);
			txt_input_search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			btn_accept_proceed.click();
			Thread.sleep(2000);
		}
	}

	
}
