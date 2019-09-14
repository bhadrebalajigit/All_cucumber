package stepDefinitions;

import java.util.Map;

import com.qa.utils.ExcelHandler;

import cucumber.api.java.en.*;
public class HomepageDefinition extends TestBase {
	
	LoginstepDefinition login=new LoginstepDefinition();
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.close();
	}
	
	@Given("^Read the Test data for TC_(\\d+)$")
	public void read_the_Test_data_for_TC_(int arg1) throws Throwable {
		
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap("E://Mobile_testing//Core_cucumber_framework//src//test//resources//Test_data.xlsx", "Sheet1", "TC_001");
		String browser=TestDataInMap.get("Browser");
		System.out.println("Testdata:"+browser);
	}


}
