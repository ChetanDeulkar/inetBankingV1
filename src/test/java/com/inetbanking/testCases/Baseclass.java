package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class Baseclass {
	//common
	Readconfig readConfig = new Readconfig();
	public static WebDriver driver;
	public String url =readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String passWord = readConfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = LogManager.getLogger("Baseclass");
		//PropertyConfigurator.configure("log4j2.properties");
		
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString() {
		String generatestring = RandomStringUtils.randomAlphabetic(8);
		return (generatestring);
	}
	
	public String randomNum() {
		String generatestring2 = RandomStringUtils.randomNumeric(4);
		return (generatestring2);
	}
	
	
}
