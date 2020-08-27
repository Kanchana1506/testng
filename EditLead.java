package week5.day2.assignment;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {

	@BeforeTest
	public void setfile()
	{excelname="editlead";}
	
	
	@Test(dataProvider = "fetchdata")
	public void RunEditLead(String fname, String newcmpny) throws InterruptedException {

		//7. click find leads
		WebElement findlead = driver.findElementByLinkText("Find Leads");
		findlead.click();
		
		//8. enter first name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(fname);
		
		//9. click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();;
		
		//to resolve error like "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document"
		Thread.sleep(2000);
		
		//10. click on first resulting lead
		WebElement leadlist = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		leadlist.click();
	
		
		//11. verify title of the page
		System.out.println("title of the page is : " + driver.getTitle());
		
		//12. click edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		//get existing company name and store in string variable oldcmpny
		String oldcmpny = driver.findElementById("updateLeadForm_companyName").getAttribute("value");
		System.out.println("old company name is " + oldcmpny );
				
		
		  //clear the existing company name if any
		  driver.findElementById("updateLeadForm_companyName").clear();
		  
		  //13. change company name 
		  String bb= "Laks tech";
		  driver.findElementById("updateLeadForm_companyName").sendKeys(newcmpny);
		  System.out.println("new company name provided is " + bb );
		  
		  //14. click update
		  driver.findElementByXPath("//input[@type=\"submit\"][@value=\"Update\"]").
		  click();
		  
		  //15. confirm the changed name appears 
		  String newcmpname = driver.findElementById("viewLead_companyName_sp").getText();
		  System.out.println("new company name in view lead page is: " + newcmpname );
		  
		  //comparing is name is changed or not
		  if ( oldcmpny.equals(bb)) 
			 { System.out.println ("name is not changed");} 
			 else
			 {System.out.println ("name is changed"); 
			 System.out.println("new name of the company is : "+ newcmpname);
			 }
			 
		  
			}

}
