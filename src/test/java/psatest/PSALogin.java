package psatest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PSALogin {
	WebDriver driver = new ChromeDriver();
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void Launch() 
	{	
		String expectedTitle = "Welcome to the Replicon Customer Zone";
		String actualTitle = driver.getTitle();
		//String expectedname ="Customer Login";
		//String actualname = driver.findElement(By.id("CustLoginLabel")).getText();
		WebDriverManager.chromedriver().setup();
		driver.get("https://polarislogin-so.replicon.com/");
		driver.manage().window().maximize();
		softAssert.assertEquals(actualTitle, expectedTitle);
		//softAssert.assertEquals(actualname, expectedname);	
	}
	@Test
    public void Login()
    {
    driver.findElement(By.id("CompanyNameTextBox")).sendKeys("Apollopsa2");
    driver.findElement(By.id("NextButton")).click();
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginNameTextBox"))).sendKeys("usertest1");
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PasswordTextBox"))).sendKeys("Replicon@123");
    driver.findElement(By.id("LoginButton")).click(); 
    }
	@Test
	public void TimeSheet()
	{
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit']/span)[1]"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-new-timeline']"))).sendKeys(Keys.ENTER);
	driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[1]"))).sendKeys("8");   
	driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[2]"))).sendKeys("8");
	driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[3]"))).sendKeys("8");
	driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[4]"))).sendKeys("8");
	driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='day']/input)[5]"))).sendKeys("8");
	driver.findElement(By.xpath("//button[@aria-label='Submit for Approval']")).click();
	}
	@Test
    public void TimeOffSubmit()
    { 
   	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit']/span)[3]"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookTimeOffBtn"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeOffSubmit"))).click();
	driver.close();
	}
	@Test
	public void Expense()
	{
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit']/span)[6]"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNewExpenseButton"))).click();
	driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expenseDescription"))).sendKeys("tets123");
	driver.findElement(By.xpath("(//td[@class='m']/button)[1]")).click();
	}
	
}
