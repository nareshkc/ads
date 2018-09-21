package pageObjectClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class ProposalDetails extends ReusableFunctions {
	public static String message =null;
	WebDriver driver;
	public ProposalDetails(WebDriver driver) {
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
	//Branch dropdown
	@FindBy(id="BranchCodes")
	@CacheLookup
	WebElement branchSelection;

	//FirstName
	@FindBy(id="fname")
	@CacheLookup
	WebElement firstName;

	//Reciept Amount
	//FirstName
	@FindBy(xpath="//input[@type='text' and @class='ng-isolate-scope ng-pristine ng-valid ng-valid-fcsa-number']")
	@CacheLookup
	WebElement recieptAmount;

	//CollectionBankkey
	@FindBy(id="collectionBankkey")
	@CacheLookup
	WebElement colBank;


	//Add Instrumnet Button
	@FindBy(xpath="//*[@id='nbs14']/button[1]")
	@CacheLookup
	WebElement addInstrumnetButton;

	//Paid By
	@FindBy(id="paidBy0")
	@CacheLookup
	WebElement paidBy;

	//paymentMOde0
	@FindBy(id="paymentMOde0")
	@CacheLookup
	WebElement paymentMode;


	//Direct Diposit
	@FindBy(id="directDeposit0")
	@CacheLookup
	WebElement dDiposit;	

	//Paid By
	@FindBy(xpath="//input[@id='amt0']")
	@CacheLookup
	WebElement amount;

	//dtxrn
	@FindBy(id="dtrno0")
	@CacheLookup
	WebElement dtxrn;
	//state
	@FindBy(id="state")
	@CacheLookup
	WebElement panState;

	//PanCard
	@FindBy(id="pan0")
	@CacheLookup
	WebElement pancard;//*[@id="nbs14"]/button[3]

	//Create ReceiptButton
	@FindBy(xpath="//*[@id=\"nbs14\"]/button[3]")
	@CacheLookup
	WebElement creatReceipt;

	//get Message on Allert
	@FindBy(xpath="/html/body/div[8]/p")
	@CacheLookup
	WebElement allertMessage;

	//get Message on Allert
	@FindBy(xpath="/html/body/div[9]/p")
	@CacheLookup
	WebElement allertMessage1;

	//Submit
	@FindBy(xpath="//*[@id=\"Print\"]/button[2]")
	@CacheLookup
	WebElement submit;


	public void selectBrach(String branchName) throws Exception {
		waitForVisible(driver,branchSelection);
		branchSelection.click();

		Select branch = new Select(branchSelection);
		branch.selectByVisibleText(branchName);
		logStep("Selected Branch is : " + branchName);

	}
	public void clikonbutton(String button) throws Exception {
		if(button.equalsIgnoreCase("addInstrumnet")) {
			waitForVisible(driver,addInstrumnetButton);
			pointToElement(addInstrumnetButton, driver);
			selectBydropDown(colBank,"HO - SBI");
			addInstrumnetButton.click();
			logStep("Clicked on AddInstrument button");

		}
	}

	public void fillInstrumentDetails() throws Exception {
		try {
			waitForVisible(driver,paidBy);
			paidBy.clear();
			paidBy.sendKeys(firstName.getText());
			selectBydropDown(paymentMode,"Debit Cards");
			selectBydropDown(dDiposit,"Yes");

			String value =recieptAmount.getAttribute("value");
			amount.clear();
			amount.sendKeys(value);
			Thread.sleep(2000);
			dtxrn.sendKeys("Instrument test data");
			selectBydropDown(panState,"Available");
			pancard.sendKeys("CONPS4651A");

			attachScreen(driver);
			creatReceipt.click();
			logger.info("clicked on create receipt button");
			logStep("clicked on create receipt button");

			try {
				allertMessage.isDisplayed();
				message=allertMessage.getText();
				attachScreen(driver);
			}catch(Exception e) {
				allertMessage1.isDisplayed();
				message=allertMessage.getText();
			}
			if(message.contains("try again")) {
				System.out.println("Need to fill more data --- "+allertMessage.getText());
			}else {
				waitForVisible(driver,driver.findElement(By.xpath("//button[@class='confirm']")));
				driver.findElement(By.xpath("//button[@class='confirm']")).click();
				clickOnElement(submit);
				if(message.contains("try again")) {
					System.out.println("Need to fill more data");
				}else {
					waitForVisible(driver,driver.findElement(By.xpath("//button[@class='confirm']")));
					driver.findElement(By.xpath("//button[@class='confirm']")).click();
					System.out.println("");
				}
			}


		}catch(Exception e) {
			//errorMSG=driver.findElement(By.xpath("/html/body/div[8]/p"));
			System.out.println("Data not filled properly ---  "+allertMessage.getText());
			Assert.fail(message);
		}

	}
}