

package week5.day2.assignment;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {

	@BeforeTest
	public void setfile()
	{excelname="deletelead";}
	
	
	@Test(dataProvider = "fetchdata")
	public void RunDeleteLead(String phn) throws InterruptedException {
	

//7	Click Find leads
	WebElement findlead = driver.findElementByLinkText("Find Leads");
	findlead.click();

	//8	Click on Phone
	driver.findElementByXPath("//span[text()='Phone']").click();
	
//9	Enter phone number
	String oldphn = "1111111111";
	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phn);
		
//10	Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
//11	Capture lead ID of First Resulting lead
	WebElement leadid = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		String leadids = leadid.getText();
		System.out.println(" lead ID of First Resulting lead: " + leadid.getText());
		
Thread.sleep(2000);
		
		  
		  //12 Click First Resulting lead driver.
		  driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		  
		
		  Thread.sleep(2000);
		  
		  //13 Click Delete
	driver.findElementByClassName("subMenuButtonDangerous").click();
	System.out.println("Delete button is clicked");
		  	  
		  //14 Click Find leads
		  driver.findElementByXPath("//a[text()='Find Leads']").click();
		  
		  //15 Enter captured lead ID
		  driver.findElementByXPath("//input[@name='id']").sendKeys(leadids);
		  
		  
		  //16 Click find leads button
		  driver.findElementByXPath("//button[text()='Find Leads']").click();
		//button[@class='x-btn-text'][7]
		  
		  //17 Verify message "No records to display" in the Lead List. This message
		  //confirms the successful deletion 
		  Thread.sleep(2000);
		  
		 String text = driver.findElementByClassName("x-paging-info").getText();
		  //System.out.println(text);
		 
			if (text.equals("No records to display")) {
				System.out.println("record deleted");
			} else {
				System.out.println("record not deleted");
			}
		  
		 	}

}
