package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class Test {
	
	public WebDriver driver;
	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	    
	}

	@When("^User entered username and password$")
	public void user_entered_username_and_password() throws Throwable {
		/*WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hello, Sign in')]")));*/
		driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @type='email']")).sendKeys("bhadrebalaji@gmail.com",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password' and @type='password']")).sendKeys("jodha@123",Keys.ENTER);
	}

	@Then("^Validate username$")
	public void validate_username() throws Throwable {
		
		String username=driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 nav-truncate nav-active']/span[@class='nav-line-1']")).getText();
		if(username.equalsIgnoreCase("Hello, balaji"))
		{
			System.out.println("username:"+username+" logged ");
		}else
		{
			System.out.println("Wrong user is logged");
			driver.close();
		}

	}
	
	@When("^User entering username and password$")
	public void user_enter_and(String username, String password) throws Throwable {
	
		driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @type='email']")).sendKeys(username,Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password' and @type='password']")).sendKeys(password,Keys.ENTER);
	}
	
	@When("^User enter credentilals$")
	public void user_enter_credentilals(DataTable arg1) throws Throwable {
	   List<List<String>> data=arg1.raw();
	   driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @type='email']")).sendKeys(data.get(1).get(0),Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password' and @type='password']")).sendKeys(data.get(1).get(1),Keys.ENTER);
	}

	/*@When("^User entering  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entering_and(DataTable data) throws Throwable {
		for(Map<String, String> data1:data.asMaps(String.class, String.class))
		{
			driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
			driver.findElement(By.xpath("//input[@id='ap_email' and @type='email']")).sendKeys(data1.get("username"),Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='ap_password' and @type='password']")).sendKeys(data1.get("password"),Keys.ENTER);
		}
	    
	}*/
	
	@When("^User entering  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entering_and(String username, String password) throws Throwable {
		 driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]")).click();
			driver.findElement(By.xpath("//input[@id='ap_email' and @type='email']")).sendKeys(username,Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='ap_password' and @type='password']")).sendKeys(password,Keys.ENTER);
	}
	
}
