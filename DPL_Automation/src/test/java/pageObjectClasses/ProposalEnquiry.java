package pageObjectClasses;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class ProposalEnquiry extends ReusableFunctions{


	WebDriver driver;
	public ProposalEnquiry(WebDriver driver)
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

	@FindBy(xpath="//*[@id='MenuBarHorizontal1']/li[5]/a")
	WebElement Enquiry;

	@FindBy(xpath="//*[@id='MenuBarHorizontal1']/li[5]/ul/li[5]/a")
	WebElement Proposalenquiry;

	@FindBy(xpath="//input[@name='fname']")
	WebElement value;

	@FindBy(xpath="//button[@ng-click='getProposalResults()']")
	WebElement srchbutton;

	@FindBy(xpath="//button[@ng-click='getProposalDetails()']")
	WebElement getdetails;

	@FindBy(xpath="//table[@class='iapp-table']/tbody/tr[@class='ng-scope']/td[1]")
	WebElement selectproposal;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li[3]")
	WebElement recieptDetails;
	
	
	@FindBy(xpath="//tr[@ng-repeat='InstrumentSearchRecord in InstrumentSearchList']/td[1]")
	WebElement recieptnumber;
	
	public static Logger logger = LoggerFactory.getLogger(ProposalEnquiry.class);

	//click on proposal Enquiry
	public void hoveronPE()throws Exception
	{
		Thread.sleep(5000);
		waitForVisible(driver,Enquiry);
		mouseHover(driver, Enquiry);
		waitTillElementVisible(Proposalenquiry, driver);
		Proposalenquiry.click();
		//System.out.println("Clicked on Proposal enquiry");
		logger.info("Clicked on Proposal enquiry");
		logStep("Selected Proposal Enquiry from Enquiry menu");
	}

	//search criteria
	public void srchcriteria() throws Exception
	{
		waitForVisible(driver,value);
		value.sendKeys(randonProNumber);

		waitForVisible(driver,srchbutton);
		srchbutton.click();
		logger.info("Clicked on search button");
		logStep("Searching with proposal Value: "+ randonProNumber);

		waitForVisible(driver,selectproposal);
		selectproposal.click();



	}
	
	public void checkReceiptDetails() throws Exception {
		waitForVisible(driver,getdetails);
		getdetails.click();
		waitForVisible(driver,recieptDetails);
		clickOnElement(recieptDetails);
		waitForVisible(driver,recieptnumber);
		System.out.println("receipt number is : "+ recieptnumber.getText());
		String receiptNumber = recieptnumber.getText();
		logger.info("Receipt number is : "+receiptNumber);
		logStep("Receipt number is : "+receiptNumber);
		attachScreen(driver);
	}



}
