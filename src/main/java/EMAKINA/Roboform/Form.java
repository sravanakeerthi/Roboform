package EMAKINA.Roboform;

import org.openqa.selenium.WebDriver;

public class Form extends Basepage{	
	
	public Form(WebDriver Driver) {
		super(Driver);	
	}

	private String salutationdrop="//select[@name='ttl_select']";
	private String salutationradio="//input[@value='Mr']";
	private String message="//div[text()='Message']//following::input";
	private String comment="//div[text()='Comments']//following::input";
	private String yourcomment="//*[@name='field3']";
	private String Sayithere="//*[@name='field4']";
	private String Resume="//*[@name='field5']";
	private String Agecheckbox="//*[@name='field6']";
	private String advertisecheck="//*[@name='field7']";
	private String MaritalStatusradio="//input[@value='maritalstatus']";
	private String MaritalStatusdrop="//select[@name='field4']";
	private String Unknownimagelabel="//input[@name='attitude']";
    private String submit="//input[@value='Submit']";
    private String reset="//input[@value='Reset']";
    private String Id="//input[@name='field_9']";
    private String cookiesalert="//span[text()='Got it']";
    private String Incomeselect="//select[@name='Income']";
    private String Annualincome="//input[@value='number']";
	 
    public void formfilling(
    		String salutation,
    		String Message,
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
    	dropdown(salutationdrop, salutation);
     	ReplaceandClick(salutationradio, "Mr",salutation);
       	findelementbyxpath(message).sendKeys(Message);
       	findelementbyxpath(comment).sendKeys(comments);
       	findelementbyxpath(yourcomment).sendKeys(yourcomments);
       	findelementbyxpath(Sayithere).sendKeys(sayithere);
       	findelementbyxpath(Resume).sendKeys(resume);
       	Click(cookiesalert);
       	if(age>=18) {
       		Click(Agecheckbox);
       	 }
       	if(Advertise=="yes")
       	{
       		Click(advertisecheck);
       	}
       	Scrollpagedown();
       	ReplaceandClick(MaritalStatusradio, "maritalstatus", Marital);
       	dropdown(MaritalStatusdrop, Marital);
       	findelementbyxpath(Unknownimagelabel).sendKeys(unknown);
       	findelementbyxpath(Id).sendKeys(id);
       	dropdown(Incomeselect, income);
       	
       	if(Annualsalary.equalsIgnoreCase("$0 - $25K")){
       		ReplaceandClick(Annualincome, "number", "1");
       	}
       	else if(Annualsalary.equalsIgnoreCase("$25K - $50K")){
       		ReplaceandClick(Annualincome,"number", "2");
       	}
       	else if(Annualsalary.equalsIgnoreCase("$50K+")){
       		ReplaceandClick(Annualincome,"number", "3");
       	}       	 
      }
    
    public void submitform() {
    	Click(submit);
    }
    
    public void Resetform() {
    	Click(reset);
    }
    
    public String getMaritalStatus() {
    	return getSelectedOption(MaritalStatusdrop).getText();
    }
}
