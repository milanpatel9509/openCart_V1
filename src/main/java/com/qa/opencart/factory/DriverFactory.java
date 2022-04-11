package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	public OptionManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) 
	{
		String browserName=prop.getProperty("browser").trim();
		System.out.println("Browser Name : "+browserName);
		
		optionManager=new OptionManager(prop); 
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{	
			WebDriverManager.edgedriver().setup();
			
			tlDriver.set(new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
		}
		else if(browserName.equalsIgnoreCase("safari")) 
		{
			tlDriver.set(new SafariDriver());
		}
		else 
		{
			System.out.println("Please pass the right browser name : "+browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties init_prop() 
	{
		prop= new Properties();
		
		try 
		{
			FileInputStream ip=new FileInputStream("./resources/config/config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	
	
	
}
