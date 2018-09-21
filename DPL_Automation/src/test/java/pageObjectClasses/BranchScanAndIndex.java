package pageObjectClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class BranchScanAndIndex extends ReusableFunctions {

	WebDriver driver;
	public BranchScanAndIndex(WebDriver driver)
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
	//inBox option
	@FindBy(linkText="Inbox")
	WebElement inBox;

	//branch Scan & Index
	@FindBy(xpath="//*[@id=\"ID8\"]")
	WebElement scan_index;

	//doc type
	@FindBy(xpath="//select[@ng-model='doc_type']")
	WebElement docType;

	//upload file
	@FindBy(xpath="//input[@type='file']")
	WebElement choosefile;

	//upload button
	@FindBy(xpath="//button[@ng-click='UploadScannedImage()']")
	WebElement upload;

	//popup successfully uploaded doc
	@FindBy(xpath="//button[@class='confirm']")
	WebElement success_doc;

	//submit button
	@FindBy(xpath="//button[@ng-click='updateScanIndex()']")
	WebElement submit;

	//scan& Index completed
	@FindBy(xpath="//button[@class='confirm']")
	WebElement scanIndex_completed_popup;

	@FindBy(xpath="//*[@id='searchNBSField']")
	WebElement srchBox;

	public static Logger logger = LoggerFactory.getLogger(BranchScanAndIndex.class);	


	public void clickOnOption(String optionName) throws Exception {
		optionName.equalsIgnoreCase(optionName);
		waitForVisible(driver,scan_index);
		scan_index.click();
		logStep("BrachScanAndIndex is selected");

	}
	public void searchwithproposalNo(String ProposalNo) throws Exception {
		//NA212
		Thread.sleep(4000);
		waitForVisible(driver,srchBox);
		ReusableFunctions.enterText_old(srchBox, ProposalNo);
		try {
			waitForVisible(driver,driver.findElement(By.linkText(ProposalNo)));
			driver.findElement(By.linkText(ProposalNo)).click();
			logStep("clicked on proposal num " + ProposalNo);
		}catch(Exception e){
			System.out.println("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed ");
			Assert.fail("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed");
		}
	}
	public void uploadFile()throws Exception
	{
		//select Doc type
		Select doctype=new Select(docType);
		docType.click();
		waitForVisible(driver,docType);
		doctype.selectByVisibleText("Application Form");
		logger.info("Selected document type");

		//click on choose file
		waitForVisible(driver,choosefile);
		Thread.sleep(5000);
		choosefile.click();
		driver.switchTo()
		.activeElement()
		.sendKeys(
				"D:\\Bhavishya\\POC\\DHFL\\gitignore_global.txt");
		//ReusableFunctions.pressESC(driver);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE); r.keyRelease(KeyEvent.VK_ESCAPE);

		//click upload
		waitForVisible(driver,upload);
		attachScreen(driver);
		upload.click();
		logger.info("Clicked on upload button");
		logStep("Clicked on upload button");

		waitForVisible(driver,success_doc);
		Thread.sleep(2000);
		success_doc.click();
		logger.info("Successfully uploaded document");
		logStep("Successfully uploaded document");

		//click submit 
		waitForVisible(driver,submit);
		submit.click();
		attachScreen(driver);
		logger.info("Clicked on submit button");

		//scanIndex_completed_popup
		ReusableFunctions.waitTillElementToBeClickable(scanIndex_completed_popup, driver);
		Thread.sleep(2000);
		scanIndex_completed_popup.click();
		attachScreen(driver);
		logger.info("Scan & index completed successfully");
		logStep("Scan & index completed successfully");

	}



}
