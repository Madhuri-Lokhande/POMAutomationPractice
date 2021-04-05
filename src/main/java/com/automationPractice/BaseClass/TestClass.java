package com.automationPractice.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automationPractice.utility.WebEventListener;

public class TestClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener evntListener;

	public TestClass() {
		try {
			String filepath = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automationPractice\\config\\config.properties";
			FileInputStream ip = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void InitialSetup() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please pass the correct browser value: " + browserName);
		}
		
		e_driver=new EventFiringWebDriver(driver);
		evntListener=new WebEventListener();
		e_driver.register(evntListener);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
