package week5.day2.assignment;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	public String excelname;
	public ChromeDriver driver;

	@DataProvider(name = "fetchdata")
	public String[][] senddata() throws IOException {
		// String[][] exceldata = ReadExcel.exceldata(excelname);
		return ReadExcel.exceldata(excelname);
	}
	@Parameters({ "username", "password" })
	@BeforeMethod
	public void login(String uname, String pname) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		WebElement usrname = driver.findElementById("username");
		usrname.sendKeys(uname);

		WebElement pwd = driver.findElementById("password");
		pwd.sendKeys(pname);

		// 3. Click on Login Button using Class Locator
		WebElement submit = driver.findElementByClassName("decorativeSubmit");
		submit.click();

		// 4. Click on CRM/SFA Link1
		WebElement crmlink = driver.findElementByLinkText("CRM/SFA");
		crmlink.click();

		// 5. Click on Leads Button
		WebElement leads = driver.findElementByLinkText("Leads");
		leads.click();

	}

	@AfterMethod
	public void close() {
		driver.close();

	}
}
