package myReplicon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Timesheet {
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15000));
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
	   public void navigateToMyReplicon() {
		   driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='My Replicon']"))).click();
	   }
	  @Test
	   public void TimeEntry() {
		   driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Add New TimeLine']"))).click();
	       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day dayOff']/input)[1]"))).sendKeys("8");
	       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day dayOff']/input)[2]"))).sendKeys("8");
	       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day dayOff']/input)[3]"))).sendKeys("8");
	       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day dayOff']/input)[4]"))).sendKeys("8");
	       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day dayOff']/input)[5]"))).sendKeys("8");
		   
	       driver.findElement(By.xpath("//button[@class='important']")).click();
	  }
	  

}
