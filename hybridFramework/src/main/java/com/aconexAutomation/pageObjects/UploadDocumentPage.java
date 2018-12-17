package com.aconexAutomation.pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aconexAutomation.helper.GenericHelper;
import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class UploadDocumentPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(UploadDocumentPage.class);
	WaitHelper waitHelper;
	JavascriptExecutor jexe;
	Select select;

	@FindBy(xpath = "//iframe[@id='frameMain']")
	WebElement documentFrame;

	@FindBy(xpath = "//input[@id='docno_0']")
	WebElement documentNo;
	
	@FindBy(xpath = "//input[@name='revision_0']")
	WebElement documentRev;
	
	@FindBy(xpath = "//input[@name='title_0']")
	WebElement documentTitle;
	
	@FindBy(xpath = "//select[@name='doctype_0']")
	WebElement documentType;
	
	@FindBy(xpath = "//select[@name='docstatus_0']")
	WebElement documentStatus;
	
	@FindBy(xpath = "//div[@id='attribute1_0']")
	WebElement documentAttribute;
	
	@FindBy(xpath = "//select[@class='isRequired']")
	WebElement documentAttribute1;
	
	@FindBy(xpath = "//button[@id='attribute1_0_bidi_add']")
	WebElement buttonArrow;
	
	@FindBy(xpath = "//button[@id='attribute1_0_panel-commit']")
	WebElement buttonOk;
	
	@FindBy(xpath = "//button[@id='FileSourceChooser']")
	WebElement chooseSource;
	
	@FindBy(xpath = "//ul[@class='uiMenu']")
	WebElement uploadFile;
	
	@FindBy(xpath = "//button[@id='btnUploadDocument']")
	WebElement btnupload;

	public UploadDocumentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, documentFrame, new Config(TestBase.OR).getExplicitWait());
	}

	public void fillDocumentDetails(long docNum,String revision, String title) throws IOException, InterruptedException {
		log.info("Entering details to upload the document...");
		driver.switchTo().frame("frameMain");
		waitHelper.setImplicitWait(60, null);
		jexe = (JavascriptExecutor) driver;

		jexe.executeScript("arguments[1].value = arguments[0]; ", docNum, documentNo);
		jexe.executeScript("arguments[1].value = arguments[0]; ", revision, documentRev);
		jexe.executeScript("arguments[1].value = arguments[0]; ", title, documentTitle);
		
		select = new Select(documentType);
		select.selectByIndex(1);
		
		select = new Select(documentStatus);
		select.selectByIndex(1);
		
		documentAttribute.click();
		waitHelper.setImplicitWait(60, null);
		documentAttribute1.click();
		waitHelper.setImplicitWait(60, null);
		buttonArrow.click();
		waitHelper.setImplicitWait(60, null);
		buttonOk.click();
		waitHelper.setImplicitWait(60, null);
		jexe.executeScript("window.scrollBy(0,500)", "");
		waitHelper.setImplicitWait(60, null);
		chooseSource.click();
		waitHelper.setImplicitWait(60, null);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='uiMenu']/li"));
	     for (WebElement opt : options) {
	         if (opt.getText().equals("Upload file from your computer")) {
	             opt.click();
	             waitHelper.setImplicitWait(60, null);
	             log.info("enter path...");
	             Thread.sleep(1000);
	             Runtime.getRuntime().exec("C:\\Program Files (x86)\\AutoIt3\\Examples\\Uploadfile.exe");
	            // chooseSource.sendKeys("D:\\prabitha\\seleniumHybridFramework-master\\src\\main\\java\\com\\aconexAutomation\\testfile\\test.pdf");
	             waitHelper.setImplicitWait(60, null);
	            // chooseSource.sendKeys(Keys.ENTER);
	             Thread.sleep(1000); 
	         }
	     }
	     log.info("click upload button...");
	     waitHelper.setImplicitWait(60, null);
	     btnupload.click();
	     waitHelper.setImplicitWait(60, null);
		 driver.switchTo().defaultContent();
		
		

	}
	
	
	

     

}
