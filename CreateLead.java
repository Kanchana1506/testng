package week5.day2.assignment;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@BeforeTest
	public void setfile()
	{excelname="createlead";}
	
	@Test(dataProvider = "fetchdata")
	public  void RunCreateLead(String company,String fname,String lname) {
		//6. Click on create Lead Button
		WebElement createlead = driver.findElementByLinkText("Create Lead");
		createlead.click();
		
		//7. Enter CompanyName using id Locator
		WebElement cmpnyname = driver.findElementById("createLeadForm_companyName");
		cmpnyname.sendKeys(company);

		//8. Enter FirstName using id Locator
		WebElement frstname = driver.findElementById("createLeadForm_firstName");
		frstname.sendKeys(fname);
		
		//9. Enter LastName using id Locator
		WebElement lastname = driver.findElementById("createLeadForm_lastName");
		lastname.sendKeys(lname);
		
		 //10. Select value as Employee in Source Using SelectbyVisible text
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select dropdown1  = new Select(source);
		dropdown1.selectByVisibleText("Employee");
	
		 //11. Select value as Pay Per Click Advertising in MarketingCampaignId Using SelectbyValue
		WebElement cmpngid = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdown2 = new Select(cmpngid);
		dropdown2.selectByValue("9001");
		
		 //12. Select value as Telecommunications from the bottom (size-2) in Industry using SelectByIndex
		WebElement indust = driver.findElementById("createLeadForm_industryEnumId");
		Select dropdown3 = new Select(indust);
		dropdown3.selectByIndex(15);
		
		 //13. Select value as Corporation in OwnerShip field Using SelectbyIndex
		WebElement ownr = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropdown4 = new Select(ownr);
		dropdown4.selectByIndex(5);
		
		 //14. Select value as India in Country Field Using SelectbyVisibletext
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdown5  = new Select(country);
		dropdown5.selectByVisibleText("India");
		
		 //15. Click on create Lead Button Using name Locator
		WebElement submitcreatelead = driver.findElementByName("submitButton");
		submitcreatelead.click();
		
		//16. Get the Title of the resulting Page
		String Leadtitle = driver.getTitle();
		System.out.println (Leadtitle);
		}

	
}
