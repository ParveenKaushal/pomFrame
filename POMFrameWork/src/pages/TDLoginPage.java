package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TDLoginPage {
	WebDriver driver;
	@FindBy(id="username")
	public WebElement emailId;
	
	@FindBy(id="uapPassword")
	public WebElement passWord;
	
	@FindBy(xpath ="//span[@id='error']")
	public WebElement globalMessage;
	
	@FindBy(xpath ="//button[@class='btn btn-block td-button-secondary']")
	public WebElement logIn;
	
	@FindBy(xpath="//span[@id='USERNAME']/span[3]")
	public WebElement emailError;
	
	@FindBy(xpath="//span[@id='PASSWORD']/span[3]")
	public WebElement passwordError;
	
	
	
	public void openBrowser() throws IOException
	{
		FileInputStream f= new FileInputStream("C:\\Program Files\\Java\\Testing\\prop.properties");
		Properties prop=new Properties();
		prop.load(f);
		String browser= prop.getProperty("browser");
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\Selenium_Jars\\geckodriver.exe");
		 driver= new FirefoxDriver();
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		PageFactory.initElements(driver, this);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void openLogin()
	{
		driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
	}
	
	public void login(String username, String password) throws InterruptedException
	{
		 emailId.sendKeys(username);
		  //driver.findElement(By.id("uapPassword"))
		  passWord.sendKeys(password);
		  //driver.findElement(By.xpath("//button[@class='btn btn-block td-button-secondary']"))
		  logIn.click();
	       Thread.sleep(2000);
	}
	
	public String globalError()
	{
		String actualerror=globalMessage.getText();//driver.findElement(By.xpath("//span[@id='error']"))			   
		System.out.println(actualerror);
		return(actualerror);
	}
	
	public String emailError()
	{
		String actualerror=emailError.getText();	   //driver.findElement(By.xpath("//span[@id='USERNAME']/span[3]"))
		System.out.println(actualerror);
		return(actualerror);
	}
	
	public String passwordError()
	{
		String actualerror=passwordError.getText();	  //driver.findElement(By.xpath("//span[@id='PASSWORD']/span[3]"))	   
		System.out.println(actualerror);
		return(actualerror);
	}
	
	
	

}
