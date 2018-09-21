package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import read_Excel_Data.ReadexcelFile;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class CallVerfication extends ReusableFunctions{
	WebDriver driver;
	public CallVerfication(WebDriver driver) 
	{
		this.driver=driver;
	}

	@Step("{0}")
	public static void logStep(String stepName ){

	}
	//Function for take the screen shot in allure report
	@Attachment("Screenshot")
	public static byte[] attachScreen(WebDriver driver ) {
		logStep("Taking screenshot");
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	@FindBy(id="ID10")
	WebElement callVerfication;
	
	@FindBy(id="searchNBSField")
	WebElement srchBox;

	//PVIC
	@FindBy(xpath="//button[@ng-click='UpdatePCVCDetails()']")
	WebElement save_button;
	@FindBy(xpath="//button[@ng-click='approveStatusPCVC()']")
	WebElement submit_button;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement callVerficationSuccess_popup;
	@FindBy(xpath="//select[@ng-change=\"onchangeOfPIcvStatus(PCVC.old.NBS_OFAC_CHECK.PCVC_STATUS);PCVC.old.NBS_OFAC_CHECK.PIVC_SUBSTATUS = ''\" ]")
	WebElement status_dropDown;
	@FindBy(xpath="//select[@ng-change=\"OnchangeOfPivcSubStatus(PCVC.old.NBS_OFAC_CHECK.PIVC_SUBSTATUS);PCVC.old.NBS_OFAC_CHECK.REASON = ''\" ]")
	WebElement subStatus_Dropdown;
	@FindBy(xpath="//select[@ng-model='PCVC.old.NBS_OFAC_CHECK.REASON' ]")
	WebElement reason_dropDown;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement success_popup;

	public void clickon(String optionName) throws Exception {
		optionName.equalsIgnoreCase("Call Verfication");
		waitForVisible(driver,callVerfication);
		callVerfication.click();


	}

	public void searchwithproposalNo(String ProposalNo) throws Exception {
		Thread.sleep(4000);
		waitForVisible(driver,srchBox);
		ReusableFunctions.enterText_old(srchBox, ProposalNo);
		try {
			waitForVisible(driver,driver.findElement(By.linkText(ProposalNo)));
			driver.findElement(By.linkText(ProposalNo)).click();
		}catch(Exception e){
			System.out.println("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed ");
			Assert.fail("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed");
		}
	}

	public void PIVC(int lineNumber) throws Exception
	{
		ReadexcelFile.readExcel("Call_Verfication");
		selectByDropdown_Excel(status_dropDown, lineNumber, 0);
		waitForVisible(driver, subStatus_Dropdown);
		selectByDropdown_Excel(subStatus_Dropdown, lineNumber, 1);
		selectByDropdown_Excel(reason_dropDown, lineNumber, 2);

		waitForVisible(driver, save_button);
		clickOnElement(save_button);
		String str=driver.findElement(By.xpath("/html/body/div[9]/p")).getText();  // prints the popup msg
		System.out.println(str);
		waitForVisible(driver,success_popup );
		clickOnElement(success_popup);  // clicks on ok button in popup

		waitForVisible(driver, submit_button);
		clickOnElement(submit_button);   // clicks on submit button

		clickOnElement(callVerficationSuccess_popup);
	}

}
