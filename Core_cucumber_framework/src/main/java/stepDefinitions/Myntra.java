package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Runner.myntra;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;

public class Myntra {

	public WebDriver driver;
	
	@Given("^Navigate to myntra site$")
	public void navigate_to_myntra_site() throws Throwable {
		
		driver= new ChromeDriver();
		myntra my=new myntra();
	
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Reporter.addStepLog("Opening the browser");   
	}

	@When("^user clicked on profile menu$")
	public void user_clicked_on_profile_menu() throws Throwable {
	/*	WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(By.xpath("")))*/
		try
		{
	  driver.findElement(By.xpath("//span[@class='desktop-userTitle' and text()='Profile']")).click();
		}
		catch(ElementNotVisibleException e)
		{
			Reporter.addStepLog("failed to click on profile menu");
		}
	}

	@When("^user clicked on login button$")
	public void user_clicked_on_login_button() throws Throwable {
		
		driver.findElement(By.xpath("//a[@href='/login?referer=https://www.myntra.com/']")).click();
	    
	}

	@Then("^enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_and(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@class='login-user-input-email login-user-input']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='login-user-input-password login-user-input']")).sendKeys(password);
	   
	}


	@Then("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='login-login-button']")).click();
		driver.close();
	    
	}
	
	@Then("^validate Error message$")
	public void validate_Error_message() throws Throwable {
	    try
	    {
	    	driver.findElement(By.xpath("//button[@class='login-login-button']")).isDisplayed();
	    	System.out.println("User is not logged in");
	    }catch(Exception e)
	    {
	    	System.out.println("User logged with invalid credentials"+e.getMessage());
	    }
	}
	@When("^verify Hello word is present or not$")
	public void verify_Hello_word_is_present_or_not() throws Throwable {
	String validate_user= driver.findElement(By.xpath("//div[@class='desktop-infoTitle']")).getText();
	if(validate_user.contains("Hello"))
	{
		System.out.println("User is validated");
	} else
	{
		System.out.println("User is not validated");
	}
	}

	/*@After()
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
		 Date date=new Date();
		 SimpleDateFormat simpledate=new SimpleDateFormat("DD_MM_YYYY_HH_MM_SS");
		 String current_date=simpledate.format(date);
	 String screenshotName = scenario.getName().replaceAll(" ", "_").concat(current_date);
	 
	 try {
	 //This takes a screenshot from the driver at save it to the specified location
		 File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(src, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }*/

}
