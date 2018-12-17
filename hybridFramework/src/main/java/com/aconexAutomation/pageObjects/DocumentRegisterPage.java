package com.aconexAutomation.pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class DocumentRegisterPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(DocumentRegisterPage.class);
	WaitHelper waitHelper;
	String docNumUploaded;
	JavascriptExecutor jexe;
	String [] docNumarr;

	@FindBy(xpath = "//input[@id='searchQuery']")
	WebElement txtSearch;

	@FindBy(xpath = "//button[@id='btnSearch_page']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//table[@id='resultTable']")
	WebElement searchTable;
	
	
	public DocumentRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void enterDocumentNumber(String docNumber) {
		log.info("entering document number ...." + docNumber);
		driver.switchTo().frame("frameMain");
		waitHelper.setImplicitWait(60, null);
		jexe = (JavascriptExecutor) driver;
		jexe.executeScript("arguments[1].value = arguments[0]; ", docNumber, txtSearch);
		log.info("clicking search...");
		btnSearch.click();

	}
	
	public String getDocNumberfromSearchTable() {
		
		log.info("fetching document from search table...");
		List<WebElement> li = searchTable.findElements(By.tagName("th"));
		for(int i=0;i<li.size()-1;i++) {
			String fixcolumn = li.get(i).getText();
			if(fixcolumn.equals("Document No")) {
				List<WebElement> lirows = searchTable.findElements(By.tagName("tr"));
				docNumUploaded = lirows.get(1).getText();
				List<WebElement> lidata = searchTable.findElements(By.tagName("td"));
				docNumUploaded = lidata.get(2).getText();
				//docNumarr = docNumUploaded.split(" ");
				log.info("document id fetched from search table..."+ docNumUploaded);
				break;
				}
				
			
		}
		return docNumUploaded;
		
	}
	
	
	
}
