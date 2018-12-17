package com.aconexAutomationTests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aconexAutomation.helper.LoggerHelper;
import com.aconexAutomation.helper.WaitHelper;
import com.aconexAutomation.pageObjects.DocumentRegisterPage;
import com.aconexAutomation.pageObjects.HotelVIPResortPage;
import com.aconexAutomation.pageObjects.LoginPage;
import com.aconexAutomation.pageObjects.UploadDocumentPage;
import com.aconexAutomation.pageObjects.WorldGamesPage;
import com.aconexAutomation.testBase.Config;
import com.aconexAutomation.testBase.TestBase;

public class AconexTests extends TestBase {

	private final Logger log = LoggerHelper.getLogger(AconexTests.class);
	WaitHelper wait;
	LoginPage loginPage;
	HotelVIPResortPage hotelVIPResortPage;
	DocumentRegisterPage DocumentRegisterPage;
	UploadDocumentPage uploadDocumentPage;
	WorldGamesPage worldGamesPage;
	long docNum;
	boolean actualCountval;

	@BeforeMethod
	public void testLoginToAconex() {

		log.info(LoginPage.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);

		loginPage.loginToAconex(config.getUserName(), config.getPassword());

		boolean status = loginPage.verifyLoginPageText();
		if (status) {
			log.info("login is sucessful");

		} else {
			Assert.assertTrue(false, "login is not sucessful");
		}

	}

	@Test(enabled=false)
	public void testHotelVIPResprt() throws InterruptedException, IOException {

		loginPage.clickprojectChangerArrow();

		loginPage.clickhotelVIPResort();

		boolean projectselstatus = loginPage.verifyProjectSelectedPagehotel();
		if (projectselstatus) {
			log.info("Hotel VIP Resort is clicked successfully");

		} else {
			Assert.assertTrue(false, "click Hotel VIP Resort is not sucessful");
		}

		log.info(HotelVIPResortPage.class.getName() + " started");
		hotelVIPResortPage = new HotelVIPResortPage(driver);

		hotelVIPResortPage.clickDocument();
		hotelVIPResortPage.clickUploadDocument();

		log.info(UploadDocumentPage.class.getName() + " started");
		uploadDocumentPage = new UploadDocumentPage(driver);

		docNum = (long) (Math.random() * 100000 + 3333300000L);
		log.info("docNum------------" + docNum);

		uploadDocumentPage.fillDocumentDetails(docNum, "111", "testpro");

		hotelVIPResortPage.clickDocument();
		hotelVIPResortPage.clickDocumentRegister();

		log.info(DocumentRegisterPage.class.getName() + " started");
		DocumentRegisterPage = new DocumentRegisterPage(driver);

		String strdocNum = String.valueOf(docNum);
		DocumentRegisterPage.enterDocumentNumber(strdocNum);

		String actualResult = DocumentRegisterPage.getDocNumberfromSearchTable();
		log.info("actual Document number------------" + actualResult);
		Assert.assertEquals(actualResult, strdocNum);

	}

	@Test(enabled=true)
	public void testWordGames() {

		loginPage.clickprojectChangerArrow();

		loginPage.clickworldGames();
		

		boolean projectselstatus = loginPage.verifyProjectSelectedPageWorldgames();
		if (projectselstatus) {
			log.info("World games is clicked successfully");

		} else {
			Assert.assertTrue(false, "clicking World games is not sucessful");
		}

		log.info(WorldGamesPage.class.getName() + " started");
		worldGamesPage = new WorldGamesPage(driver);
		
		worldGamesPage.clickWorkFlow();
		
		worldGamesPage.clickWorkFlowAssigned();

	   actualCountval = worldGamesPage.getWorkFlowsfromTable();
		if (actualCountval) {
			log.info("World games is clicked successfully");

		} else {
			Assert.assertTrue(false, "World games is not sucessful");
		}

	}

}
