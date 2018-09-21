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

public class UnderWriting extends ReusableFunctions{
	WebDriver driver;
	int loopCount=0;
	public UnderWriting(WebDriver driver)
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

	@FindBy(id="ID66")
	WebElement UW;
	@FindBy(id="searchNBSField")
	WebElement srchBox;

	@FindBy(xpath="//input[@class=\"searchInput ng-valid ng-dirty\"]")
	WebElement searchPropNo;

	@FindBy(xpath="//button[@class='confirm']")
	WebElement popup_UWSuccess;
	@FindBy(xpath="//p[@style=\"display: block;\"]")
	WebElement message1;
	@FindBy(xpath="//select[@ng-model='proposal.underDecision']")
	WebElement UWDecision;
	@FindBy(xpath="//button[@ng-click='approveUnderWriterReview()']")
	WebElement SubmitButton;
	@FindBy(xpath="//button[@ng-click='saveDecision()']")
	WebElement SaveButton;
	@FindBy(xpath="//button[@ng-click='closeModalUnderWriter()']")
	WebElement CloseButton;


	//=====Reassign====



	@FindBy(xpath="//div[@class=\"iapp-table-enclosure\"]//a[@class=\"ng-binding\"]")
	WebElement chkproNo;

	@FindBy(xpath="//button[@data-ng-click='ReassignTask()']")
	WebElement ReAssignTask;

	@FindBy(xpath="//button[@ng-click=\"assignTheTaskToOther()\"]")
	WebElement AssignTask;


	@FindBy(xpath="//select[@ng-model=\"SelectedUser\"]")
	WebElement userToAssign;

	@FindBy(xpath="//input[@ng-model=\"searchNBS\"]")
	WebElement searchProp;

	@FindBy(xpath="//input[@id=\"Selectcheckbox\"]")
	WebElement checkBox;


	@FindBy(xpath="//button[@ng-click=\"closeModal()\"]")
	WebElement closeReAssign;

	public void clickon(String optionName) throws Exception {
		optionName.equalsIgnoreCase("UW");
		waitForVisible(driver,UW);
		UW.click();


	}

	public  void searchwithproposalNo(String ProposalNo) throws Exception {
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
	public void waitfor() throws Exception {
		enterText_old(srchBox, randonProNumber);
		for(int waitfor=1;waitfor<=5;waitfor++) {
			try {
				if(chkproNo.isDisplayed()) {
					if(chkproNo.getText().equals(randonProNumber)) {
						logStep(randonProNumber+" Proposal number available for ReAssign");
						logger.info(randonProNumber+" Proposal number available for ReAssign");
						break;
					}else {
						System.out.println("Proposal No not matched");
					}
				}
			}catch(Exception e) {
				logStep(randonProNumber+" Proposal number not available for ReAssign need to refresh the page");
				logger.info(randonProNumber+" Proposal number not available for ReAssign need to refresh the page");
				
				driver.navigate().refresh();
				clickon("UW");
				enterText_old(srchBox, randonProNumber);
			}
		}

	}

	public void reAssignTask() throws Exception {
		
		//reAssign task\
		logStep("Started Re assigning task");
		logger.info("Started Re assigning task");
		attachScreen(driver);
		waitForVisible(driver, ReAssignTask);
		clickOnElement(ReAssignTask);
		selectBydropDown(userToAssign, "Bhavishya Revuri");
		logStep("Re Assigned to Bhavishya Revuri");
		logger.info("Re Assigned to Bhavishya Revuri");
		enterdata(searchProp, randonProNumber);
		attachScreen(driver);
		clickOnElement(checkBox);
		clickOnElement(AssignTask);
		if(message1.getText().contains("Task assignment will take some time")) {
			logger.info("Reasign task completed successfully ");
			logStep("Reasign task completed successfully ");
			waitForVisible(driver, popup_UWSuccess);
			attachScreen(driver);
			clickOnElement(popup_UWSuccess);
			clickOnElement(closeReAssign);
			//button[@ng-click="closeModal()"]
		}else if(message1.getText().contains("Please select at-least one detail for Task assignment")) {
			logger.info(message1.getText());
			logStep(message1.getText());
			waitForVisible(driver, popup_UWSuccess);
			attachScreen(driver);
			clickOnElement(popup_UWSuccess);
			clickOnElement(closeReAssign);
			waitForVisible(driver, UW);
			clickOnElement(UW);
			loopCount=loopCount+1;
			reAssignTask();
			if(loopCount==4) {
				logger.info("Proposal No not available in UW bucket after "+loopCount+ " Times refresh");
				logStep("Proposal No not available in UW bucket after "+loopCount+ " Times refresh");
				Assert.fail("Proposal No not available in UW bucket after "+loopCount+ " Times refresh" );
			}
		}else {
			System.out.println(message1.getText());
			logger.info(message1.getText());
			logStep(message1.getText());
			attachScreen(driver);
			Assert.fail(message1.getText());
		}
	}

	public void underWriting(int lineNumber, String ProposalNo)  throws Exception
	{
		ReadexcelFile.readExcel("UnderWriting");
		// need to click on submit
		logStep("Click on Submit button");
		logger.info("Click on Submit button");
		clickOnElement(SubmitButton);
		if(message1.getText().contains("Please Select Underwriter Decision or Reference")) {
			attachScreen(driver);
			waitForVisible(driver, popup_UWSuccess);
			clickOnElement(popup_UWSuccess);
			waitForVisible(driver, UWDecision);
			selectByDropdown_Excel(UWDecision, lineNumber, 0);
			attachScreen(driver);
			clickOnElement(SubmitButton);

			waitForVisible(driver, popup_UWSuccess);
			logStep(message1.getText());
			logger.info(message1.getText());
			System.out.println(message1.getText());
			attachScreen(driver);
			clickOnElement(popup_UWSuccess);
		}else {

			logStep(message1.getText());
			logger.info(message1.getText());
			System.out.println(message1.getText());
			attachScreen(driver);
			clickOnElement(popup_UWSuccess);

			searchwithproposalNo(ProposalNo); //srch for proposal num again

			waitForVisible(driver, UWDecision);
			selectByDropdown_Excel(UWDecision, lineNumber, 0);
			attachScreen(driver);
			clickOnElement(SubmitButton);

			waitForVisible(driver, popup_UWSuccess);
			logStep(message1.getText());
			logger.info(message1.getText());
			System.out.println(message1.getText());
			attachScreen(driver);
			clickOnElement(popup_UWSuccess);
		}
	}







}
