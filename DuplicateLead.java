package week5.day2.assignment;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {


//http://leaftaps.com/opentaps/control/main
//Duplicate Lead:

	@BeforeTest
	public void setfile()
	{excelname="duplicatelead";}
	
	
	@Test(dataProvider = "fetchdata")
	public void RunDuplicateLead(String email) throws InterruptedException {
		
	//7	Click Find leads
	WebElement findlead = driver.findElementByLinkText("Find Leads");
	findlead.click();

	
//8	Click on Email
	driver.findElementByXPath("//span[text()='Email']").click();
	
	
//9	Enter Email
	driver.findElementByName("emailAddress").sendKeys(email);
	
	
//10	Click find leads button
	driver.findElementByXPath("//button[text()='Find Leads']").click();

Thread.sleep(2000);	
//11	Capture name of First Resulting lead
	WebElement frstlead = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	System.out.println("First Resulting lead: " + frstlead.getText());
	
	WebElement frstleadname = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
	String aa = frstleadname.getText();
	
	System.out.println("name of First Resulting lead: " + aa);
	
	Thread.sleep(2000);	
//12	Click First Resulting lead
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	
//13	Click Duplicate Lead
	driver.findElementByLinkText("Duplicate Lead").click();
	
	
//14	Verify the title as 'Duplicate Lead'
	String a = driver.getTitle();
	if (a.contains("Duplicate"))
		{
		System.out.println("title is correct ");
		System.out.println("Title is :"+ a);
	}
	else
	{System.out.println("Title is not correct"+ a);}
	
//15	Click Create Lead
	driver.findElementByClassName("smallSubmit").click();
	
	
//16	Confirm the duplicated lead name is same as captured name
	String dupname = driver.findElementById("viewLead_firstName_sp").getText();
if (dupname.contains(aa))
	System.out.println("duplicated lead name is same as captured name");
else
	System.out.println("duplicated lead name is not same as captured name");

}
}