package stepDefinitions;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class LoginstepDefinition extends TestBase {
	
	//public WebDriver driver;
	@Before
	public void setup()
		{
	
		}
	@After
	public void teardown()
		{
			//driver.close();
		}
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
	    driver=new ChromeDriver();
	    driver.get("https://www.amazon.in/");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Hello. Sign in']")).click();
	    String actual= driver.getTitle();
	    Assert.assertEquals("Amazon Sign In", actual);
	   
	}

	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(String UserName,String Password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(UserName,Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(Password,Keys.ENTER);
	
	}

	@Then("^Validate logged \"([^\"]*)\"$")
	public void validate_logged_user(String user) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String username=driver.findElement(By.xpath("//span[@class='nav-line-1' and contains(text(),user)]")).getText();
		System.out.println("Username is:"+username);

	}
	
	@Then("^check title of the homepage$")
	public void check_title_of_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String title=driver.getTitle();
	    System.out.println("Title of the page:"+title);
	}
	

	@Then("^User enters UserName$")
	public void user_enters_UserName() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("bhadrebalaji@gmail.com",Keys.ENTER);
	}
	
	@Then("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("bhadrebalaji@gmail.com",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("jodha@123",Keys.ENTER);
	}
	
	@Then("^Validate logged user$")
	public void validate_logged_user() throws Throwable {
		String username=driver.findElement(By.xpath("//span[@class='nav-line-1' and contains(text(),'balaji')]")).getText();
	
	}
	
	@Then("^Enter IOS Product$")
	public void enter_IOS_Product(DataTable table) throws Throwable {
		List<List<String>> data=table.raw();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' and @tabindex='19']")).sendKeys(data.get(0).get(0),Keys.ENTER);
		
	}

	@Then("^Print product name and Price of first product$")
	public void print_product_name_and_Price() {
	
		String product_name=driver.findElement(By.xpath("//li[@id='result_0']/div[@class='s-item-container']/div/div/child::div[@class='a-fixed-left-grid-col a-col-right']/child::div/child::div/a")).getAttribute("title");
		System.out.println("First IOS product in list:"+product_name);
		
		String product_price=driver.findElement(By.xpath("//li[@id='result_0']/div[@class='s-item-container']/div/div/child::div[@class='a-fixed-left-grid-col a-col-right']/child::div/child::div[@class='a-column a-span7']/child::div/a/child::span[@class='a-size-base a-color-price s-price a-text-bold']")).getText();
		System.out.println("First IOS product price in list:"+product_price);
	}
	
	@Then("^User enters username and password$")
	public void user_enters_username_and_password(DataTable arg1) throws Throwable {
		for (Map<String, String> data : arg1.asMaps(String.class, String.class)) {
			
			driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(data.get("username"),Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(data.get("password"),Keys.ENTER);
			/*driver.findElement(By.xpath("//*[contains(text(),'Hello')]")).click();
			driver.findElement(By.xpath("//*[text()='Sign Out']")).click();*/
			
		
			}
	}
//	@Then("^Validate logged users$")
//	public void validate_logged_users(DataTable arg1) throws Throwable {
//			for (Map<String, String> data : arg1.asMaps(String.class, String.class)) {
//			
//				String username=driver.findElement(By.xpath("//span[@class='nav-line-1' and contains(text(),user)]")).getText();
//				System.out.println("Username is:"+username);
//				Assert.assertEquals(username, data.get("user"));
//				driver.findElement(By.xpath("//*[contains(text(),'Hello')]")).click();
//				driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
//				
//			}
	//}

}
