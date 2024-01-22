package cleanTest;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CleanTests {
    
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10000));
	
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
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginNameTextBox"))).sendKeys("admin");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTextBox"))).sendKeys("Replicon@123");
		driver.findElement(By.id("LoginButton")).click();
	}
    @Test
	public void navigateTOPayroll() {
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Payroll']"))).click();
	//driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='itslmpumtext']"))).sendKeys("testuser1");
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Select All Timesheet List']"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Delete']"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='buttonActionSubmit']"))).click();
	driver.quit();
    }
}
