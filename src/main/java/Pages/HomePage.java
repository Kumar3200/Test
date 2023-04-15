package Pages;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

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


public class HomePage {
	public WebDriver driver;
	String genAsn;

	@FindBy(xpath="//body/div/div[@role='presentation']/div[@role='presentation']/a[1]/span[1]/span[1]/span[1]")
	WebElement btn_menu;

	@FindBy(xpath ="//input[@role='combobox']")
	WebElement btn_search;

	@FindBy(id ="dataForm:xmlString")
	WebElement txt_posting_xml;

	@FindBy(xpath ="//input[@value='Send']")
	WebElement btn_send;

	@FindBy(id="button-1025-btnIconEl")
	WebElement btn_right_top;

	@FindBy(xpath="//*[text()='Close']")
	WebElement btn_close;

	@FindBy(xpath="//a[normalize-space()='Inbound']")
	WebElement btn_inbound;

	@FindBy(xpath="//a[normalize-space()='Recv Conversion']")
	WebElement btn_RecvConversion;

	@FindBy(id="shipinpId")
	WebElement txt_conv_asn;

	@FindBy(id="dataForm:processBatch")
	WebElement txt_batch;

	@FindBy(id="sLb_Input")
	WebElement txt_locn;

	@FindBy(xpath="//body//div//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//div[1]//div[1]//div[1]//div[1]//input[1]")
	WebElement asnui_asn;

	@FindBy(xpath="//input[@name='asnId']")
	WebElement asnui_enter_asn;

	@FindBy(xpath="//span[contains(text(),'Apply')]")
	WebElement asnui_apply;

	@FindBy(xpath="//div[@class='x-grid-row-checker']")
	WebElement asnui_checkbox;

	@FindBy(xpath="//span[contains(text(),'More')]")
	WebElement asnui_more;

	@FindBy(xpath="//body/div/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[contains(@role,'presentation')]/div[1]/a[1]")
	WebElement asnui_more_verfiy_asn;

	@FindBy(xpath="//input[contains(@value,'Verify ASN')]")
	WebElement asnui_verify;

	@FindBy(xpath="//body[1]/form[1]/div[1]/table[1]/tbody[1]/tr[6]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	WebElement btn_revtran;

	@FindBy(xpath="//a[normalize-space()='Recv iLPN ASN']")
	WebElement btn_recv_ilpn_asn;

	@FindBy(xpath="//input[contains(@type,'text')]")
	WebElement txt_tran_asn;

	@FindBy(id="lpninput")
	WebElement txt_lpn;

	@FindBy(id="tb_567")
	WebElement btn_i;

	@FindBy(xpath="//span[contains(@title,'Ctrl-Z Verify ASN')]")
	WebElement btn_verify_asn;

	@FindBy(xpath="//input[contains(@type,'text')]")
	WebElement txt_enter_y;

	@FindBy(xpath="//span[@title='Ctrl-X Exit']")
	WebElement btn_exit;

	@FindBy(xpath="//span[@title='CTRL-F Find Tran']")
	WebElement btn_find_tran;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_transaction;

	@FindBy(id="containerEntryUserDirected")
	WebElement txt_ilpn_ptwy;

	@FindBy(id="subLocationEntryUserDirected_Input")
	WebElement txt_locn_ptwy;

	@FindBy(xpath="//a[normalize-space()='Pick Tower']")
	WebElement btn_pick_tower;

	@FindBy(xpath="//a[normalize-space()='MHE Receiving']")
	WebElement btn_mhe_recv;

	@FindBy(xpath="//a[normalize-space()='MHE Recv Conversion']")
	WebElement btn_mhe_rec_conv;

	@FindBy(xpath="//a[normalize-space()='MHE XO Recv Item Lvl']")
	WebElement btn_mhe_xo_rec;

	@FindBy(xpath="//span[@title='Ctrl-D Page Down']")
	WebElement btn_page_down;

	@FindBy(xpath="//a[normalize-space()='MHE Recv iLPN ASN']")
	WebElement btn_mhe_ilpn_asn;

	@FindBy(xpath="//input[@alt='Find Purchase Order']")
	WebElement txt_search_PO;

	@FindBy(xpath="//input[@id='dataForm:filterId:filterIdapply']")
	WebElement btn_apply;

	@FindBy(xpath="//input[@value='Add']")
	WebElement btn_add;

	@FindBy(xpath="//input[@value='Generate']")
	WebElement btn_generate;

	@FindBy(id="dataForm:asnidh1")
	WebElement txt_asn_field;

	@FindBy(xpath="//input[contains(@title,'Select date and time')]")
	WebElement btn_click_on_date;

	@FindBy(xpath="//td[normalize-space()='25']")
	WebElement btn_select_the_date;

	@FindBy(xpath="//input[@id='dataForm:sv']")
	WebElement btn_click_on_ok;

	@FindBy(xpath="//input[@title='PO']")
	WebElement btn_checkbox_po;

	@FindBy(xpath="//input[@name='dataForm:atreeTable:0:atreeB:aadaptor:0::aselectId']")
	WebElement btn_checkbox_asn;

	@FindBy(xpath="//input[@name='dataForm:cb5']")
	WebElement btn_arrow;

	@FindBy(xpath="//input[@value='Save']")
	WebElement btn_save;

	@FindBy(xpath="//a[normalize-space()='Recv Item Lvl']")
	WebElement btn_recv_item_lvl;

	@FindBy(xpath="//a[normalize-space()='MHE Recv Item Lvl']")
	WebElement btn_mhe_recv_item_lvl;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_Po_asn;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_Po;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_Bp;

	@FindBy(id="lpninput")
	WebElement txt_Po_ilpn;

	@FindBy(xpath="//span[@title='Ctrl-A Accpt/Proceed']")
	WebElement btn_accept;

	@FindBy(xpath="//input[@type='text']")
	WebElement txt_item;

	@FindBy(xpath="//body/form[@method='post']/div/input[1]")
	WebElement txt_lot;

	@FindBy(xpath="//form[@method='post']//div//div//input[@type='text']")
	WebElement txt_generate_control;

	@FindBy(xpath="//input[@value='0']")
	WebElement txt_po_qty;

	@FindBy(xpath="//a[normalize-space()='Bulk']")
	WebElement btn_bulk;

	@FindBy(xpath="//a[normalize-space()='Receiving']")
	WebElement btn_receiving;

	@FindBy(xpath="//body[1]/form[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	WebElement btn_receiveXo;
	
	@FindBy(xpath="//span[@class='captionData']")
	WebElement value_ilpn;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void search_for_create_asn_from_Po() throws InterruptedException {
		btn_search.sendKeys("Create ASN From Po");
		Thread.sleep(2000);
		btn_search.sendKeys(Keys.ENTER);
	}
	public void search_for_po(String po) throws InterruptedException{
		txt_search_PO.sendKeys(po);
		Thread.sleep(2000);
		btn_apply.click();
	}
	public void generate_asn() throws Exception {
		btn_add.click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		btn_generate.click();
		Thread.sleep(2000);
		txt_asn_field.sendKeys(Keys.CONTROL,"a");
		txt_asn_field.sendKeys(Keys.CONTROL,"c");
		genAsn=(String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ASN :"+genAsn, ExtentColor.GREEN));
		Thread.sleep(2000);
		btn_click_on_date.click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		btn_select_the_date.click();
		Thread.sleep(2000);
		btn_click_on_ok.click();
	}
	public void click_on_both_check_box() throws InterruptedException {
		btn_checkbox_po.click();
		Thread.sleep(2000);
		btn_checkbox_asn.click();
		Thread.sleep(2000);
		btn_arrow.click();
		Thread.sleep(2000);
		btn_save.click();	
	}
	public void click_on_mhe_recv_item_lvl() {
		btn_mhe_recv_item_lvl.click();
	}
	public void click_on_recv_item_lvl() {
		btn_recv_item_lvl.click();
	}

	public void click_on_menu() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn_menu));
		btn_menu.click();
	}
	public void searching_for_postmessage() throws InterruptedException {
		btn_search.sendKeys("Post Message");
		Thread.sleep(2000);
		btn_search.sendKeys(Keys.ENTER);
	}
	public void enter_the_xml_and_posting(String file) throws InterruptedException {
		txt_posting_xml.click();
		txt_posting_xml.sendKeys(file);
		Thread.sleep(5000);
		btn_send.click();
	}
	public void closing_the_screen() throws InterruptedException {
		btn_right_top.click();
		Thread.sleep(2000);
		btn_close.click();
	}
	public void search_for_rf() throws InterruptedException {
		btn_menu.click();
		Thread.sleep(2000);
		btn_search.sendKeys("RF menu");
		btn_search.sendKeys(Keys.ENTER);
	}
	public void click_on_inbound() {
		btn_inbound.click();
	}
	public void click_on_pick_tower() {
		btn_pick_tower.click();
	}
	public void click_on_bulk() {
		btn_bulk.click();
	}
	public void click_on_receiving() {
		btn_receiving.click();
	}
	public void click_on_revconversion() {
		btn_RecvConversion.click();
	}
	public void click_on_mhe_receiving() {
		btn_mhe_recv.click();
	}
	public void click_on_mhe_rec_conv() {
		btn_mhe_rec_conv.click();
	}
	//	public void click_on_mhe_rec_xo() {
	//		btn_mhe_xo_rec.click();
	//	}
	public void click_on_mhe_rec_ilpn_asn() {
		btn_mhe_ilpn_asn.click();
	}

	public void enter_the_conv_asn(String conAsnId) throws InterruptedException {
		txt_conv_asn.sendKeys(conAsnId);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ASN :"+conAsnId, ExtentColor.GREEN));
		Thread.sleep(2000);
		txt_conv_asn.sendKeys(Keys.ENTER);
	}


	public void user_search_for_asnui() throws InterruptedException {
		btn_menu.click();
		Thread.sleep(2000);
		btn_search.sendKeys("ASN");
		Thread.sleep(2000);
		btn_search.sendKeys(Keys.ENTER);
	}
	public void user_enter_the_asn_and_Search_it(String conAsnId) throws Exception {
		asnui_asn.sendKeys("ASN");
		asnui_asn.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		asnui_enter_asn.sendKeys(conAsnId);
		asnui_enter_asn.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		asnui_apply.click();
		Thread.sleep(2000);
		asnui_checkbox.click();
		Thread.sleep(2000);
		asnui_more.click();
		Thread.sleep(2000);
		asnui_more_verfiy_asn.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(asnui_verify));
		asnui_verify.click();

	}
	public void click_on_revXo() {
		btn_revtran.click();
	}
	public void click_on_recXo_miami() {
		btn_receiveXo.click();
	}
	public void click_on_page_down() {
		btn_page_down.click();
	}
	public void click_on_recv_ilpn_asn() {
		btn_recv_ilpn_asn.click();
	}
	public void enter_the_tran_asn(String asnId) throws InterruptedException {
		txt_tran_asn.sendKeys(asnId);
		Thread.sleep(2000);
		txt_tran_asn.sendKeys(Keys.ENTER);
	}
	public void enter_the_ilpn(ArrayList<String> ilpnValues) throws InterruptedException {
		for(String value:ilpnValues) {
			txt_lpn.sendKeys(value);
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ILPN :"+value, ExtentColor.GREEN));
			Thread.sleep(2000);
			txt_lpn.sendKeys(Keys.ENTER);
		}
	}
	public void verify_the_tran_asn() throws InterruptedException {
		btn_i.click();
		Thread.sleep(2000);
		btn_verify_asn.click();
		Thread.sleep(2000);
		txt_enter_y.sendKeys("Y"+Keys.ENTER);

	}
	public void select_the_putaway_userdir() throws InterruptedException {
		btn_i.click();
		Thread.sleep(2000);
		btn_exit.click();
		Thread.sleep(2000);
		btn_i.click();
		Thread.sleep(2000);
		btn_find_tran.click();
		Thread.sleep(2000);
		txt_transaction.sendKeys("ptwy"+Keys.ENTER);
		Thread.sleep(2000);
		txt_transaction.sendKeys("1"+Keys.ENTER);

	}

	public void enter_the_ilpn_for_putaway(ArrayList<String> ilpnValues,String reserve) throws InterruptedException {
		for(String value:ilpnValues) {
			txt_ilpn_ptwy.sendKeys(value);
			Thread.sleep(2000);
			txt_ilpn_ptwy.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			txt_locn_ptwy.sendKeys(reserve+Keys.ENTER);
			Thread.sleep(2000);
		}

	}

	public void enter_the_resv_locn_for_ptwy(String locn) {
		txt_locn_ptwy.sendKeys(locn+Keys.ENTER);
	}

	public void enter_the_Po_asn() {
		txt_Po_asn.sendKeys(genAsn+Keys.ENTER);
	}
	public void enter_the_PO(String po) {
		txt_Po.sendKeys(po+Keys.ENTER);
	}
	public void enter_the_Bp(String Bp) {
		txt_Po.sendKeys(Bp+Keys.ENTER);
	}
	public void generate_the_ilpn() {
		txt_Po_ilpn.sendKeys(Keys.ENTER);
	}
	public void click_on_accept() {
		btn_accept.click();
	}
	public void enter_the_item_Po(String itemNum) throws Exception {
		txt_item.sendKeys(itemNum);
		Thread.sleep(2000);
		txt_item.sendKeys(Keys.ENTER);
	}
	public void enter_the_lot() throws InterruptedException {
		Random rnd=new Random();
		int number =rnd.nextInt(999999);
		String num=String.format("%06d",number);
		txt_lot.sendKeys(num);
		Thread.sleep(2000);
		txt_generate_control.sendKeys(Keys.ENTER);	
	}
	public void enter_the_po_quantity(String qty) throws InterruptedException {
		Actions act=new Actions(driver);
		act.doubleClick(txt_po_qty).perform();
		Thread.sleep(2000);
		txt_po_qty.sendKeys(qty);
		txt_po_qty.sendKeys(Keys.ENTER);
	}
	public void verify_the_Po_asn() throws InterruptedException {
		btn_i.click();
		Thread.sleep(2000);
		btn_verify_asn.click();
		Thread.sleep(2000);
		txt_enter_y.sendKeys("Y"+Keys.ENTER);

	}

	public void enter_the_control_and_location(ArrayList<String> batchValues, ArrayList<String> qtyValues,String locn) throws InterruptedException {
		for(int i=0;i<batchValues.size() && i<qtyValues.size();i++) {
			String bat=batchValues.get(i);
			int num=Integer.parseInt(qtyValues.get(i));
			String str=String.format("%06d",num);
			String cnl;
			cnl=bat+"E"+str;
			Thread.sleep(2000);
			txt_batch.sendKeys(cnl);
			Thread.sleep(2000);
			txt_batch.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String ilpn=value_ilpn.getText();
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("ILPN :"+ilpn, ExtentColor.GREEN));
			txt_locn.sendKeys(locn);
			Thread.sleep(2000);
			txt_locn.sendKeys(Keys.ENTER);
		}
	}

}
