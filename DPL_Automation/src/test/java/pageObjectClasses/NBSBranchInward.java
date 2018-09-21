package pageObjectClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import read_Excel_Data.ReadexcelFile;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class NBSBranchInward extends ReusableFunctions{

	WebDriver driver;
	public NBSBranchInward(WebDriver driver) 
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
	@FindBy(id="inputName")
	@CacheLookup
	WebElement username;

	@FindBy(xpath="//*[@id=\"MenuBarHorizontal1\"]/li[2]/a")
	@CacheLookup
	WebElement NBS;

	@FindBy(xpath="//*[@id=\"MenuBarHorizontal1\"]/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement Branch_Inward;

	@FindBy(id="proposalno")
	WebElement proposal_no;

	@FindBy(name="salutation")
	WebElement title;

	@FindBy(name="fname")
	WebElement FirstName;

	@FindBy(name="lname")
	WebElement LastName;

	@FindBy(name="state")
	WebElement State;

	@FindBy(id="city")
	WebElement city;

	@FindBy(xpath="//input[@ui-date='dateOptions']")
	WebElement dob;

	@FindBy(name="phone")
	WebElement Mobile_num;

	@FindBy(id="ageprof")
	WebElement Age_proof;

	@FindBy(id="AddressPinCode1")
	WebElement pincode;

	@FindBy(name="smoker")
	WebElement Smoker;

	@FindBy(name="gender")
	WebElement Gender;


	@FindBy(xpath="//*[@type='checkbox' and @ng-model=\"brnInward.isproposerRequired\"]")
	WebElement isPropDifferLA;

	@FindBy(xpath="//select[@ng-model='brnInward.ProposerType']")
	WebElement propType;

	@FindBy(xpath="//ul[contains(@class,'ui-autocomplete')]//li")
	WebElement city_inner;

	@FindBy(xpath="//button[@class='btn btn-primary dispatch-btn']")
	WebElement getRequirement_button;
	@FindBy(xpath="//div[contains(@class,'showSweetAlert')]//button[text()='OK']")
	WebElement Quotedetails_SavedSuccessful_Popup;
	@FindBy(xpath="//input[@ui-date='dateOptions']")
	WebElement datePickLoc;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement datePickYearLoc;

	@FindBy(xpath = "//input[@ui-date='dateOptions']")
	WebElement dateOFBirth;
	//input[@ui-date="dateOptions"]
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement datePickMonthLoc;

	@FindBy(xpath = "//button[text()='Get Quote']")
	WebElement getQuote;

	@FindBy(xpath = "//tr[@class='ng-scope']/td[1]/input[@type='text']")
	WebElement sumAss;

	@FindBy(xpath = "//input[@ng-model='TotalAmount']")
	WebElement sumAss1;
	//-------Quote validation------
	@FindBy(name="product")
	WebElement product;

	@FindBy(xpath="//select[@ng-model='brnInward.term']")
	WebElement term;

	@FindBy(xpath="//select[@ng-model='brnInward.PremiumPayType']")
	WebElement sumAssuredOption;

	@FindBy(xpath="//select[@ng-model='brnInward.prepayterm']")
	WebElement PPterm;

	@FindBy(name="mode")
	WebElement mode;

	@FindBy(name="inputmode")
	WebElement inputmode;

	@FindBy(xpath="//input[@type='text'][@name='preAssured'][@ng-model='brnInward.preAssured']")
	WebElement sumAssured;

	@FindBy(xpath="//button[@ng-click='branchInward()']")
	WebElement inward_complete;

	@FindBy(xpath="//button[@class='confirm']")
	WebElement yes_proceed;

	@FindBy(xpath="(//input[@id='imgBut'])[1]")
	WebElement agent_code;


	@FindBy(xpath="//ul[contains(@class,'ui-autocomplete')]//li")
	List<WebElement> cityDrop;

	@FindBy(xpath="//select[@ng-model='SearchField']")
	WebElement search_by_field;

	@FindBy(xpath="//input[@ng-model='SearchValue']")
	WebElement value;

	@FindBy(xpath="//button[@ng-click='searchAgentDetails(SearchField, SearchValue)']")
	WebElement search_button;


	@FindBy(name="Prmcoll")
	WebElement prmCollector;


	@FindBy(xpath="/html/body/div[8]/p")
	WebElement popupMsg;

	@FindBy(xpath="//button[@class='btn btn-primary dispatch-btn']")
	WebElement getReqBtn;

	@FindBy(xpath="//button[@ng-click='CloseModalTracker()']")
	WebElement closeBtn;

	@FindBy(className="confirm")
	WebElement okBtn;

	public static Logger logger = LoggerFactory.getLogger(NBSBranchInward.class);

	public void HoveronNs()throws Exception
	{
		Thread.sleep(5000);
		waitForVisible(driver,NBS);
		ReusableFunctions.mouseHover(driver, NBS);

		ReusableFunctions.waitTillElementVisible(Branch_Inward, driver);
		Branch_Inward.click();
		//System.out.println("Clicked on Branch Inward");
		logger.info("Clicked on Branch Inward");
		logStep("Clicked on Branch Inward from NBS ");
	}

	public void setCity(WebElement ele, int lineNumber, int column_num) throws Exception {

		String str_city = ReadexcelFile.readdata[lineNumber][column_num].toString();
		String cityPart = str_city.substring(0, 4);
		ele.sendKeys(cityPart);
		try {

			for (WebElement options : cityDrop) {
				if (str_city.equalsIgnoreCase(options.getText())) {
					options.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void agentcode(int lineNumber) throws Exception
	{

		clickByJS(agent_code,driver);
		logStep("Selected Agent ");
		waitTillElementVisible(search_by_field, driver);
		selectByDropdown_Excel(search_by_field,lineNumber, 1);
		enterData_Excel(value, 1, 19);
		search_button.click();
		logStep("Clicked on search button");
		waitTillElementVisible(search_by_field, driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tr[@ng-repeat='Agent in AgentList']"))).doubleClick().build().perform();



	}

	public void setPin(WebElement ele, int lineNumber, int column_num) {

		String str_pin = ReadexcelFile.readdata[lineNumber][column_num].toString();
		ele.sendKeys(str_pin);
		List<WebElement> pinList=driver.findElements(By.xpath("//ul[@id='ui-id-7']/li"));
		for(WebElement pinNumber:pinList) {
			if(pinNumber.getText().equals(str_pin)){
				pinNumber.click();
			}
		}

	}


	public void SetApplicantBirthDate(int lineNumber) throws Exception{
		String doBirth =ReadexcelFile.readdata[lineNumber][10];
		waitTillElementToBeClickable(datePickLoc, driver);
		dateOFBirth.sendKeys(doBirth);
		dateOFBirth.sendKeys(Keys.ESCAPE);
	}

	//set proposal Number
	public void set_proposal_num() throws Exception
	{
		String str_proposalno=genarateProposalNumber("MNB");
		waitTillElementVisible(proposal_no, driver);
		proposal_no.sendKeys(str_proposalno);	

		logger.info("Enter proposal num : "+ str_proposalno);
	}


	//Branch Inward Details for Scenario1 ie: Traditional COSMOS
	public void branchInward_details() throws Exception {
		
		try {
			//---propose details----
			testCaseData("Branch_Inward");
			ReadexcelFile.readExcel("Branch_Inward");
			set_proposal_num();
			//enterData_Excel(proposal_no, 1, 0);
			agentcode(1);
			Thread.sleep(1000);
			selectByDropdown_Excel(title, lineNumber, 2);
			enterData_Excel(FirstName, lineNumber, 3);
			enterText(LastName,lineNumber);
			selectByDropdown_Excel(State, lineNumber, 5);
			setCity(city, lineNumber, 6);
			setPin(pincode, lineNumber, 7);
			enterData_Excel(Mobile_num, lineNumber, 8);
			selectByDropdown_Excel(Age_proof, lineNumber, 9);
			SetApplicantBirthDate(lineNumber);
			selectByDropdown_Excel(Smoker, lineNumber, 11);
			selectByDropdown_Excel(Gender, lineNumber, 12);
			System.out.println(ReadexcelFile.readdata[lineNumber][21]);
			if(ReadexcelFile.readdata[lineNumber][21].equalsIgnoreCase("Yes")) {
				isPropDifferLA.click();
				selectByDropdown_Excel(propType, lineNumber, 22);
				Scenario=2;
			}else {
				Scenario=1;
			}
			//---quote validation---
			selectByDropdown_Excel(product, lineNumber, 13);
			try {
				if(Scenario==1) {
					selectByDropdown_Excel(sumAssuredOption, lineNumber, 20);
				}else {
				waitForVisible(driver, sumAssuredOption);
				selectByDropdown_Excel(sumAssuredOption, lineNumber, 20);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			selectByDropdown_Excel(term, lineNumber, 14);
			selectByDropdown_Excel(PPterm, lineNumber, 15);
			selectByDropdown_Excel(mode, lineNumber, 16);
			selectByDropdown_Excel(inputmode, lineNumber, 17);
			enterData_Excel(sumAssured, lineNumber, 18);
			clickOnElement(getQuote);
			logStep("Clicked on GetQuote button");
			attachScreen(driver);
			Quotedetails_SavedSuccessful_Popup.click();
			logStep("Quote details saved successfully");
			enterText_old(prmCollector, sumAss1.getAttribute("value").toString());
			clickOnElement(getReqBtn);
			logStep("Clicked on GetRequirement button");
			//Quotedetails_SavedSuccessful_Popup.click();
			waitForVisible(driver, closeBtn);
			closeBtn.click();
			waitForVisible(driver, inward_complete);
			clickOnElement(inward_complete);
			logStep("Clicked on InwardComplete button");
			attachScreen(driver);
			if(Scenario==2) {
				okBtn.click();
			}else {
			ReusableFunctions.waitTillElementToBeClickable(yes_proceed, driver);
			attachScreen(driver);
			clickOnElement(yes_proceed);
			logStep("clicked on Yes proceed button");
			logStep("message : -- "+popupMsg.getText());

			attachScreen(driver);
			okBtn.click();
			logStep("Clicked on OK button");
			}

		}catch(Exception e) {
			Assert.fail("Bucket not completed");
		}
	}


	//branch Inward detauls for Scenarion-2 ie; COSMOS to IL

	public void branchInward_details_2(int lineNumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		try {
			//---propose details----
			ReadexcelFile.readExcel("Branch_Inward");
			set_proposal_num();
			//enterData_Excel(proposal_no, 1, 0);
			agentcode(2);
			Thread.sleep(1000);
			selectByDropdown_Excel(title, lineNumber, 2);
			enterData_Excel(FirstName, lineNumber, 3);
			enterText(LastName,lineNumber);
			selectByDropdown_Excel(State, lineNumber, 5);
			setCity(city, lineNumber, 6);
			setPin(pincode, lineNumber, 7);


			enterData_Excel(Mobile_num, lineNumber, 8);
			selectByDropdown_Excel(Age_proof, lineNumber, 9);
			SetApplicantBirthDate(lineNumber);

			selectByDropdown_Excel(Smoker, lineNumber, 11);
			selectByDropdown_Excel(Gender, lineNumber, 12);

			//---quote validation---
			selectByDropdown_Excel(product, lineNumber, 13);
			selectByDropdown_Excel(term, lineNumber, 14);
			selectByDropdown_Excel(PPterm, lineNumber, 15);
			selectByDropdown_Excel(mode, lineNumber, 16);
			selectByDropdown_Excel(inputmode, lineNumber, 17);
			enterData_Excel(sumAssured, lineNumber, 18);
			clickOnElement(getQuote);
			Quotedetails_SavedSuccessful_Popup.click();
			enterText_old(prmCollector, sumAss1.getAttribute("value").toString());
			clickOnElement(getReqBtn);
			closeBtn.sendKeys(Keys.ESCAPE);
			waitForVisible(driver, inward_complete);
			clickOnElement(inward_complete);
			ReusableFunctions.waitTillElementToBeClickable(yes_proceed, driver);
			clickOnElement(yes_proceed);
			System.out.println("clicked on Yes proceed button");
			System.out.println("message : -- "+popupMsg.getText());
			attachScreen(driver);
			okBtn.click();


		}catch(Exception e) {
			Assert.fail("Bucket not completed");
		}
	}







}

