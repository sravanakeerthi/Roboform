package EMAKINA.Roboform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepdefintions {
	private WebDriver driver;
	private String projectDirPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name").toLowerCase();
	
	@Given("open page https://www.roboform.com/filling-test-custom-fields")
	public void openpage()  {
		String url="https://www.roboform.com/filling-test-custom-fields";
		
		if(osName.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", projectDirPath + "\\Resources\\chromedriver.exe");			
		} else if(osName.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", projectDirPath + "\\Resources\\chromedriver");
		}
		
        driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
   
	@When("Enter details \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"")
	public void enterdetails(
			String salutation,
			String Message ,
			String comments,
			String yourcomments,
			String sayithere,
			String resume,
			Integer age,
			String Advertise,
			String Marital,
			String unknown,
			String id,
			String income,
			String Annualsalary
			) {
	    Form ad=new Form(driver);
		ad.formfilling(
				salutation,
				Message,
				comments,
				yourcomments,
				sayithere,
				resume,
				age,
				Advertise,
				Marital,
				unknown,
				id,
				income,
				Annualsalary
				);
	}
		
	@Then("Submit the form successfully")
	public void submitForm() {
		Form ad=new Form(driver);
		ad.submitform();		
		Assert.assertEquals("(Select Status)", ad.getMaritalStatus());
		driver.quit();
	}
	@Then("Reset the form successfully")
	public void reset() {
		Form ad=new Form(driver);
		ad.Resetform();
		Assert.assertEquals("(Select Status)", ad.getMaritalStatus());
		driver.quit();
	}
	
}
