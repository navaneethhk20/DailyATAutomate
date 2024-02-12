package psatest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PSATimeoff {
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void LoginToReplicon() 
	{	
		String expectedTitle = "Welcome to the Replicon Customer Zone";
		String actualTitle = driver.getTitle();
		WebDriverManager.chromedriver().setup();
		driver.get("https://polarislogin-so.replicon.com/");
		driver.manage().window().maximize();
		softAssert.assertEquals(actualTitle, expectedTitle);
		driver.findElement(By.id("CompanyNameTextBox")).sendKeys("Apollopsa2");
		driver.findElement(By.id("NextButton")).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginNameTextBox"))).sendKeys("usertest1");
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTextBox"))).sendKeys("Replicon@123");
		driver.findElement(By.id("LoginButton")).click(); 
	}

	@Test
    public void TimeOffSubmit()
    { 
   	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit']/span)[3]"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookTimeOffBtn"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeOffSubmit"))).click();
	driver.close();
	}
}
