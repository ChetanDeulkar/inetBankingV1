package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddcustomerTest_003 extends Baseclass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("User name is provided");
		lp.setPassword(passWord);
		logger.info("Password is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		Thread.sleep(5000);
		
		Actions act = new Actions(driver);
//		act.doubleClick().build().perform();
		driver.switchTo().frame(0);
		act.doubleClick().build().perform();
		driver.switchTo().defaultContent();

		logger.info("providing customer details....");

		addcust.custName("Chetan");
		addcust.custgender("male");
		addcust.custdob("12", "10", "2004");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("Pune");
		addcust.custstate("MH");
		addcust.custpinno("411043");
		addcust.custtelephoneno("8785625416");

		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("acdef");
		addcust.custsubmit();

		Thread.sleep(5000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
