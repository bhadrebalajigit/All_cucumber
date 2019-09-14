

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.amazon.in");
	  driver.findElement(By.xpath("//*[text()='Hello. Sign in']")).click();
	  driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("bhadrebalaji@gmail.com",Keys.ENTER);
	  driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("jodha@123",Keys.ENTER);
	  String product_in_cart=driver.findElement(By.xpath("//*[@class='nav-cart-count nav-cart-1']")).getText();
	  driver.findElement(By.xpath("//*[@class='nav-cart-count nav-cart-1']")).click();
	  int number_of_products=Integer.parseInt(product_in_cart);
	  List<WebElement> webelement=driver.findElements(By.xpath("//input[contains(@name,'submit.delete')]"));
	  System.out.println(webelement.size());
	 
	  
	  if(number_of_products>0)
	  {
		 /*for(WebElement e:webelement)
		 {
			 
			 e.click();
			 Thread.sleep(10000);
			 WebDriverWait wait=new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[contains(@name,'submit.delete')]")));
			
		 }*/
		  
		  Iterator<WebElement> itr=webelement.iterator();
		  while(itr.hasNext())
		  {
			  itr.next().click();
			  String name=driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")).getText();
			  System.out.println("Deleting "+name+"");
			  Thread.sleep(10000);
		  }
		
	  }
	  
  }
}
