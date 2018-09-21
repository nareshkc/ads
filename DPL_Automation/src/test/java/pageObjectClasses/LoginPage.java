package pageObjectClasses;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import read_Excel_Data.ReadexcelFile;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class LoginPage extends ReusableFunctions{
	WebDriver driver;
	public String sheetName="User_credentials";
	public static int lcountno;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	@Step("{0}")
	public static void logStep(String stepName ){

	}
	//Function for take the screen shot in allure report
	@Attachment("Screenshot")
	public static byte[] attachScreen(WebDriver driver,String scteenName ) {
		logStep("Taking screenshot : "+scteenName);
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@FindBy(id="inputName")
	@CacheLookup
	WebElement username;

	@FindBy(id="inputPassword")
	@CacheLookup
	WebElement password;

	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement loginbtn;


	public void login() throws Exception {
		countno=lcountno;
		testCaseData("User_credentials");
		ReadexcelFile.readExcel("User_credentials");
		waitForVisible(driver,username); 
		//Clear User Name and enter user name from excel sheet
		username.clear();
		username.sendKeys(ReadexcelFile.readdata[lineNumber][1]);
		logStep("User entered Username");
		//Clear Password and enter user name from excel sheet
		password.clear();
		password.sendKeys(ReadexcelFile.readdata[lineNumber][2]);
		logStep("User entered Username");
		attachScreen(driver,"Login Page");

		//Click on lohin Button
		logStep("User entered UserName / Password ");
		loginbtn.click();
		logStep("User clicked on Login button");
		lcountno=countno;

	}
}
