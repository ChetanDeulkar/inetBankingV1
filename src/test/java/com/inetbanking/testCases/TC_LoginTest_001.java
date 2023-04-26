package com.inetbanking.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Baseclass {

	@Test
	public void loginTest() throws Exception {
		
		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("Entered username");

		lp.setPassword(passWord);
		logger.info("Entered password");

		lp.clickSubmit();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info("Test is passed");
		} else {
			captureScreen(driver, "loginTest");
			AssertJUnit.assertTrue(false);
			logger.info("Test is failed");
		}

	}

}
