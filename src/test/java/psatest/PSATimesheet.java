package psatest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PSATimesheet {
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10000));
	@Test
	public void LoginToPsa() {
	WebDriverManager.chromedriver().setup();
	driver.get("https://polarislogin-so.replicon.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("CompanyNameTextBox")).sendKeys("Apollopsa2");
    driver.findElement(By.id("NextButton")).click();
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginNameTextBox"))).sendKeys("usertest1");
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTextBox"))).sendKeys("Replicon@123");
    driver.findElement(By.id("LoginButton")).click(); 
	}
	public void Timesheet()
	{
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit']/span)[1]"))).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-new-timeline']"))).sendKeys(Keys.ENTER);
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[1]"))).sendKeys("8");   
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[2]"))).sendKeys("8");
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[3]"))).sendKeys("8");
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[4]"))).sendKeys("8");
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[5]"))).sendKeys("8");
		driver.findElement(By.xpath("//button[@aria-label='Submit for Approval']")).click();
		driver.close();
		}

}
