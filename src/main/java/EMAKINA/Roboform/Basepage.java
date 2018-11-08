package EMAKINA.Roboform;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Basepage {
	
	private WebDriver driver;

	public Basepage(WebDriver Driver) {
		this.driver=Driver;
	}	

	public WebElement findelementbyxpath(String xpath) {		
		return driver.findElement(By.xpath(xpath));
	}
	
	public void dropdown(String xpath,String salutation) {
		Select fromdropdown=new Select(findelementbyxpath(xpath));
		fromdropdown.selectByVisibleText(salutation);
	}
	
	public WebElement getSelectedOption(String xpath) {
		Select fromdropdown=new Select(findelementbyxpath(xpath));
		return fromdropdown.getFirstSelectedOption();
	}
	
	public void Click(String path) {		
		findelementbyxpath(path).click();
	}
	
	public void ReplaceandClick(String path,String keyword,String word) {
		Click(path.replace(keyword,word));
	}
	
    public void Scrollpagedown() {
		 JavascriptExecutor js= (JavascriptExecutor) driver;	
	     js.executeScript("window.scrollBy(0,500)");
	}
}
