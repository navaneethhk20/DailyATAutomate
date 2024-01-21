package myAT;

import org.testng.annotations.Test;

import java.time.Duration;

import org.apache.commons.compress.harmony.pack200.CPString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAT {
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15000));
@Test
	public void launch() {
		WebDriverManager.chromedriver().setup();	
		driver.get("https://login-so.replicon.com");
		driver.manage().window().maximize();
		
     }
  @Test
   public void enterLoginDetails() {
	  driver.findElement(By.id("CompanyNameTextBox")).sendKeys("navneeth1");
		driver.findElement(By.id("NextButton")).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginNameTextBox"))).sendKeys("testuser1");
      driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTextBox"))).sendKeys("Replicon@123");
		driver.findElement(By.id("LoginButton")).click();  
    }
   @Test
   public void verifyLogin() {
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-bind='text:getWelcomeText()']"))); 
    }
   @Test
   public void navigateToMyReplicon() {
	   driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='My Replicon']"))).click();
       driver.quit();
   }
  
}
