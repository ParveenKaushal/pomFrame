package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.TDLoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TDLogin {
  WebDriver driver;
  TDLoginPage tlp= new TDLoginPage();
  DataFile df= new DataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\Selenium_Jars\\geckodriver.exe");
      //driver= new FirefoxDriver();
      //driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
      //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 tlp.openBrowser();
     tlp.openLogin();
	  
  }

 @AfterMethod
  public void afterMethod() {
	  //driver.quit();
	  tlp.closeBrowser();
  }
  
  
  @Test
  public void login() throws InterruptedException {
//	  driver.findElement(By.id("username")).sendKeys("wertyug");
//	  driver.findElement(By.id("uapPassword")).sendKeys("tewuywtuy");
//	  driver.findElement(By.xpath("//button[@class='btn btn-block td-button-secondary']")).click();
//       Thread.sleep(2000);
	  tlp.login("hghagkjhakj", "hgdjasgkah");
      //String expectedGlobalError="This should be working, but something's gone wrong. Please try again soon. [500.GENERIC]";
    	//String actualerror=tlp.globalError();//driver.findElement(By.xpath("//span[@id='error']")).getText();	   
  //System.out.println(actualerror);
       
 Assert.assertEquals(tlp.globalError(), df.globalError);
	 
  }
  

  @Test
  public void loginWithEmptyPass() throws InterruptedException {
	  tlp.login("hdjhdbjsdfi","");
       //String expectedGlobalError="Please enter your password";
      //String actualerror=tlp.passwordError();//driver.findElement(By.xpath("//span[@id='PASSWORD']/span[3]")).getText();	   
  //System.out.println(actualerror);
Assert.assertEquals(tlp.passwordError(), df.passwordError);
  }

  
 @Test
  public void loginWithEmptyEmail() throws InterruptedException {
	  tlp.login("", "sdgjshuij");
       //String expectedGlobalError="Please enter your Username or Access Card number.";
      //String actualerror=tlp.emailError();//driver.findElement(By.xpath("//span[@id='USERNAME']/span[3]")).getText();	   
  //System.out.println(actualerror);
  Assert.assertEquals(tlp.emailError(), df.emailError);
  }

}
