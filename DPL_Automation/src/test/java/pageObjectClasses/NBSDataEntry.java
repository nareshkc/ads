package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import read_Excel_Data.ReadexcelFile;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class NBSDataEntry extends ReusableFunctions {

	WebDriver driver;
	public static int ScenarioType;
	public NBSDataEntry(WebDriver driver)
	{
		this.driver=driver;
	}
	@Step("{0}")
	public static void logStep(String stepName ){

	}
	//Function for take the screen shot in allure report
	@Attachment("Screenshot")
	public static byte[] attachScreen(WebDriver driver,String screenstep ) {
		logStep("Taking screenshot of "+screenstep);
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	//inBox option
	@FindBy(linkText="Inbox")
	WebElement inBox;

	//NBS data entry
	@FindBy(id="ID41")
	WebElement nbs_dataEntry;

	//Area of operation
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.AreaofOperation']")
	WebElement area_Of_Operation;

	//defense type
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.defenceFlag']")
	WebElement defense_type;

	//first Title
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laTitle']")
	WebElement fTitle;


	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laFname']")
	WebElement fname;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laLname']")
	WebElement lname;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laFatherHusbandFname']")
	WebElement fFatherName;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laMaritalStatus']")
	WebElement fMarStatus;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laNationality']")
	WebElement fNationality;



	//select[@ng-model="nbsDataEntry.laTitle"]
	@FindBy(xpath="//button[@ng-click=\"ClientDepupe('LA')\"]")
	WebElement clientDedupe_button;
	@FindBy(xpath="//button[@ng-click='CloseModalTracker()']")
	WebElement closeButton;


	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laNationality']")
	WebElement nationality;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laResidentialStatus']")
	WebElement resStatus;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laPanNo']")
	WebElement panCard;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laCMobile']")
	WebElement fMobile;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laMaritalStatus']")
	WebElement marritalStatus;
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laAgeProof']")
	WebElement age_proof;
	//Fathers Name
	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laFatherHusbandFname']")
	WebElement Fathers_name;

	//Address type
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCAddressType']")
	WebElement address_type;

	//Address 2 same as 1
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIsCommSameAsPer']")
	WebElement address2_sameAs_1;

	@FindBy(id="CityValue1")
	WebElement cityValue;

	//Address 3 same as 2
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIsAddSamCom']")
	WebElement address_3;

	//address proof
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laAddressProof']")
	WebElement address_proof;


	//----Education& Employment details------
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laEducation']")
	WebElement education_type;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laQualification']")
	WebElement qualification_type;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laOccupation']")
	WebElement occupation_type;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laSubOccupation']")
	WebElement sub_occupation;

	//--------Health Details-----------
	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laheight']")
	WebElement height_type;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laWeight']")
	WebElement weight_type;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laAnnualIncome']")
	WebElement annual_income;

	//-----family details----------
	@FindBy(xpath="//select[@ng-model='familydetails.MemberName']")
	WebElement family_member;

	@FindBy(xpath="//input[@ng-model='familydetails.Age']")
	WebElement age_at_onset;

	@FindBy(xpath="//select[@ng-model='familydetails.healthStatus']")
	WebElement health_status;

	@FindBy(xpath="//button[@ng-click='AddfamilyMember()']")
	WebElement add_family_member;

	@FindBy(xpath="//button[@ng-click='nextTab(0)']")
	WebElement click_next_LifeAssurance;

	//--Bank Details --
	@FindBy(xpath="//button[@ng-click='nextTab(2)']")
	WebElement click_next_BankDetails;

	//-----Nominee Details--------
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.n1Title']") 
	WebElement title;

	@FindBy(id="n1Fname")
	WebElement n_fname;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.n1Lname']")
	WebElement n_surname;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.n1Gender']")
	WebElement n_gender;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.n1DateOfBirth']")
	WebElement n_dob;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.n1Relationship']")
	WebElement n_relationship;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.n1Percentage']")
	WebElement n_share;

	@FindBy(xpath="//button[@class='confirm']")
	WebElement success_popup;

	@FindBy(xpath="//button[@ng-click='nextTab(3)']")
	WebElement click_next_NomineeDetails;

	//--Repository details-
	@FindBy(xpath="//button[@ng-click='nextTab(5)']")
	WebElement click_next_RepositoryDetails;

	//---Questions---
	@FindBy(xpath="//button[@ng-click='nextTab(6)']")
	WebElement click_next_Question;

	//--proposal Sign Date--
	@FindBy(xpath="//button[@ng-click='nextTab(7)']")
	WebElement click_next_ProposalSign_Date;

	//submit button
	@FindBy(xpath="//button[@ng-click='approveDataEntry()']")
	WebElement submit_button;

	@FindBy(xpath="//*[@id='searchNBSField']")
	WebElement srchBox;


	//======Communication======

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCAddressType']") 
	WebElement cAddetype;

	@FindBy(name="laCAddress1") 
	WebElement cAddrLine1;

	@FindBy(id="CityValue1") 
	WebElement ccity;


	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCState']") 
	WebElement cstate;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCCountry']") 
	WebElement ccountry;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laAddressProof']") 
	WebElement cAddeProof;

	@FindBy(id="AddressPinCode1") 
	WebElement cPinCode;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIsFirAddOrSecAdd']")
	WebElement CommAddressDetails_Or_AddDetals2; 

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIdentityProof']")
	WebElement identity_proof; 

	//======Address2====//
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIsCommSameAsPer']") 
	WebElement sameadAdd1;
	//======Address3 =======//

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laIsAddSamCom']") 
	WebElement sameadAdd2;

	//=====Education====//
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laEducation']") 
	WebElement education;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laQualification']") 
	WebElement qualification;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laOccupation']") 
	WebElement occup;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.laAnnualIncome']") 
	WebElement annualIncome;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laPoliticalExposed']") 
	WebElement politicalExp;


	//=============Health details==================//
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.lahealthcondition']")
	WebElement health_condition;

	//======Family Details=====//

	@FindBy(xpath="//select[@ng-model='familydetails.MemberName']") 
	WebElement familyMember;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laPreviousProposalFlag']") 
	WebElement propDeclined;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laFamilyHistory']") 
	WebElement ageSenier;

	@FindBy(xpath="//input[@ng-model='familydetails.Age']") 
	WebElement ageatOnset;

	@FindBy(xpath="//select[@ng-model='familydetails.healthStatus']") 
	WebElement healthStatus;


	@FindBy(xpath="//button[@ng-click='AddfamilyMember()']") 
	WebElement addFamily;

	@FindBy(xpath="//button[@ng-click='nextTab(0)']") 
	WebElement nextButton;

	//	@FindBy(xpath="//ul[@id='ui-id-12']/li")
	//	List<WebElement> cityDrop;


	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCState']")
	List<WebElement> state;

	@FindBy(xpath="//button[@ng-click='updateQuoteandRider()']") 
	WebElement getQuoteBtn;

	@FindBy(xpath="//button[@ng-click='getQuote()']") 
	WebElement updateQuoteBtn;


	@FindBy(xpath="//button[@ng-click='closeModal()']") 
	WebElement closeQuoteBtn;

	//---Rider details in product details section
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCoverType']")
	WebElement coverType;
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCampaignCode']")
	WebElement campaignCode;
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laRenewalPayment']")
	WebElement renewalPaymentOption;
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laPanCardStatus']")
	WebElement PANCardStatus;
	@FindBy(xpath="//button[@ng-click='nextTab(4)']")
	WebElement click_next_productDetails;
	@FindBy(xpath="//button[@ng-click='updateQuoteandRider()']")
	WebElement updateQuote_button;
	@FindBy(xpath="//button[@ng-click='getQuote()']")
	WebElement getQuote_Button;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement popup_quoteDetailsSuccess;

	@FindBy(xpath="//p[@style=\"display: block;\"]")
	WebElement message;



	//name of life insured
	@FindBy(xpath="//input[@ng-model='QuestionObj.QVALUE' and @class='ng-pristine ng-valid']")
	WebElement nameOfLifeInsured;
	
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div[1]/accordion/div/div[8]/div[2]/div/div/div[4]/div[3]/div/div[2]/input")
	WebElement nameOfLifeInsurednew;
	
	@FindBy(xpath="//button[@class='confirm']")
	WebElement OKButton;

	//==================Proposer Details=======///


	@FindBy(xpath="//div[@ng-show=\"isProposarCondValue\"]//button[@ng-click=\"ClientDepupe('Proposer')\"]")
	WebElement pClientDedupe;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.pTitle']")
	WebElement pTitle;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.pFatherHusbandFname']")
	WebElement pFatherName;


	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pGender']")
	WebElement pGender;

	@FindBy(xpath="//input[@ng-model='nbsDataEntry.pDateOfBirth']")
	WebElement pDOB;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pMaritalStatus']")
	WebElement pMarStatus ;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pNationality']")
	WebElement pNationality ;


	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pResidentialStatus']")
	WebElement pResStatus;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pAgeProof']")
	WebElement pAgeProof;


	@FindBy(xpath="//div[@class='panel panel-default ng-isolate-scope']//input[@ng-model='nbsDataEntry.pPanNo']")
	WebElement pPanNo;


	@FindBy(xpath="//div[@class='panel panel-default ng-isolate-scope']//select[@ng-model='nbsDataEntry.pRelationshipWLa']")
	WebElement pRelWithLA;

	//------comm details
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pCAddressType']")
	WebElement pAddressType;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//input[@ng-model='nbsDataEntry.pCAddress1']")
	WebElement pAddressLine1;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//input[@id='CityValue3']")
	WebElement pCity;

	@FindBy(xpath="//input[@id='CityValue3']//following::div//select[@ng-model='nbsDataEntry.pCCountry']")
	WebElement pCountry;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pAddressProof']")
	WebElement pAddressProof;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pIsCommSameAsPer']")
	WebElement paddress2SameAsAdd1;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pIsOffAddSamCom']")
	WebElement pAddress3;

	//select[@ng-model="nbsDataEntry.pIsFirAddOrSecAdd"]
	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pIsFirAddOrSecAdd']")
	WebElement pAddress3toadd2;
	
	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pEducation']")
	WebElement pEducation;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pQualification']")
	WebElement pQualification;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pOccupation']")
	WebElement pOccupation;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pSubOccupation']")
	WebElement pSubOccupation;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pOrganizationType']")
	WebElement pOrgType;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//input[@ng-model='nbsDataEntry.pAnnualIncome']")
	WebElement pAnnualIncome;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pIncomeProof']")
	WebElement pIncomeProof;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pIdentityProof']")
	WebElement pIDProof;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPoliticalExposed']")
	WebElement pPExposed;

	@FindBy(xpath="//select[@ng-model='nbsDataEntry.pPreferredEmail']")
	WebElement pEmail;


	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPreferredSms']")
	WebElement pSMS;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPreferredLanguage']")
	WebElement pLang;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPreferredDay']")
	WebElement pDay;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPreferredTime']")
	WebElement pFromTime;

	@FindBy(xpath="//div[@ng-show='isProposarCondValue']//select[@ng-model='nbsDataEntry.pPreferredToTime']")
	WebElement pToTime;

	@FindBy(xpath="//button[@ng-click='nextTab(1)']")
	WebElement pNextClick;

	//======Product details======//
	
	
	@FindBy(xpath="//button[@ng-click=\"getQuote()\"]")
	WebElement pGetQuoteBtn;
	
	//======Fill Fund=====//
	
	@FindBy(xpath="//select[@ng-model=\"nbsDataEntry.PortfolioStrategy\"]")
	WebElement pStrategy;
	
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.SystematicTransferPlan']")
	WebElement pStPlan;
	
	//select[@ng-model='nbsDataEntry.SinglePremiumPlan']
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.SinglePremiumPlan']")
	WebElement pSinglePlan;
	
	@FindBy(xpath="//select[@ng-model='fundDetails.fundName']")
	WebElement pFundName;
	
	
	@FindBy(xpath="//input[@ng-model='fundDetails.percent']")
	WebElement pFundPerc;
	
	//button[@ng-click="addFund()"]
	@FindBy(xpath="//button[@ng-click=\"addFund()\"]")
	WebElement pClickAdd;
	
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCoverType']")
	WebElement pCoverType;
	
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laCampaignCode']")
	WebElement pCompCode;
	
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laRenewalPayment']")
	WebElement pRenPayOption;
	
	
	@FindBy(xpath="//select[@ng-model='nbsDataEntry.laPanCardStatus']")
	WebElement pPanStatus;
	
	public void clickon_option(String optionName)throws Exception
	{
		waitForVisible(driver,inBox);
		inBox.click();
		logStep("Clicked on inbox Button");
		optionName.equalsIgnoreCase("NBSDataEntry");
		waitForVisible(driver,nbs_dataEntry);
		nbs_dataEntry.click();
		logStep("NBSDataENtry is seslected");
	}

	public void searchWithProposalNo(String proposalNo) throws Exception {
		//NA212
		Thread.sleep(4000);
		waitForVisible(driver,srchBox);
		ReusableFunctions.enterText_old(srchBox, proposalNo);
		try {
			waitForVisible(driver,driver.findElement(By.linkText(proposalNo)));
			driver.findElement(By.linkText(proposalNo)).click();
			logStep(proposalNo+ "proposal number is clicked");
			attachScreen(driver,"Search Prop Number");
		}catch(Exception e){
			System.out.println("ProposalNo - "+proposalNo+ " not available in the list may be it is cliamed ");
			Assert.fail("ProposalNo - "+proposalNo+ " not available in the list may be it is cliamed");
		}
	}


	public void select_option_dataEntry(String OptionName)throws Exception
	{
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='tab-content']//div[@class='panel-group']//h4//a//span"));

		for(WebElement e1:list) {
			String str=e1.getText();

			if(str.equalsIgnoreCase(OptionName)) {
				e1.click();
				logStep("Clicked on  : " + OptionName);
			}
		}

	}

	public void nbsDataEntry(String sheetname,int lineNumber) throws Exception {

		ReadexcelFile.readExcel(sheetname);
		enterData_Excel(Fathers_name,lineNumber, 2);
		selectByDropdown_Excel(marritalStatus,lineNumber,3);
		selectByDropdown_Excel(nationality,lineNumber,4);
		waitForVisible(driver, resStatus);
		selectByDropdown_Excel(resStatus,lineNumber,5);
		selectByDropdown_Excel(age_proof,lineNumber,6);
		enterData_Excel(fMobile, lineNumber, 27);
		attachScreen(driver);


		//Address type
		selectByDropdown_Excel(cAddetype,lineNumber ,7);

		//address line1
		enterData_Excel(cAddrLine1,lineNumber,8);
		if(ScenarioType==2) {
			Scenario=ScenarioType;
			setCity(ccity, lineNumber, 28);
			selectByDropdown_Excel(cstate,lineNumber,29);
		}
		//country Name
		selectByDropdown_Excel(ccountry,lineNumber,9);
		selectByDropdown_Excel(address_proof, lineNumber, 10);

		if(ScenarioType==2) {
			enterData_Excel(cPinCode,lineNumber,30);
		}

		enterData_Excel(panCard,lineNumber,11);
		//Adress2
		selectByDropdown_Excel(sameadAdd1,lineNumber,12);
		//Adress3
		selectByDropdown_Excel(sameadAdd2,lineNumber,13);
		selectByDropdown_Excel(CommAddressDetails_Or_AddDetals2, lineNumber, 14);
		attachScreen(driver);

		//education
		selectByDropdown_Excel(education, lineNumber,15);

		//qualification
		selectByDropdown_Excel(occup,lineNumber, 16);
		selectByDropdown_Excel(qualification_type,lineNumber,24);
		selectByDropdown_Excel(sub_occupation, lineNumber, 17);

		//Annual Income
		enterData_Excel(annualIncome,lineNumber, 18);
		selectByDropdown_Excel(identity_proof, lineNumber, 19);

		//politicalExp
		selectByDropdown_Excel(politicalExp,lineNumber, 20);

		if(ScenarioType==1) {
			//health cond
			selectByDropdown_Excel(health_condition, lineNumber, 21);
			attachScreen(driver);
		}

		//height
		enterData_Excel(height_type,lineNumber, 22);

		//weight
		enterData_Excel(weight_type, lineNumber,23);
		if(ReadexcelFile.readdata[lineNumber][25].equalsIgnoreCase("No")) {
			selectByDropdown_Excel(propDeclined, lineNumber, 25);
		}


		if(ReadexcelFile.readdata[lineNumber][26].equalsIgnoreCase("No")) {
			selectByDropdown_Excel(ageSenier, lineNumber, 26);
		}else {
			addFamily("FamilyDetails","1,2");
		}

		//family details
		//		selectByDropdown_Excel(familyMember,lineNumber,24);
		//		enterData_Excel(ageatOnset, lineNumber, 25);
		//		selectByDropdown_Excel(healthStatus, lineNumber,26);
		//		clickOnElement(addFamily);
		//		ReusableFunctions.waitForVisible(driver, success_popup);
		//		success_popup.click();// click ok in pop up that displays family mem added successfully
		clickOnElement(nextButton);
		logStep("Next Button is clicked");
		attachScreen(driver);
	}

	public void setCity(WebElement ele, int lineNumber, int column_num) throws Exception {

		String str_city = ReadexcelFile.readdata[lineNumber][column_num].toString();
		String cityPart = str_city.substring(0, 4);
		ele.sendKeys(cityPart);
		List<WebElement> cityDrop=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li"));

		try {
			for (WebElement options : cityDrop) {
				if (str_city.equalsIgnoreCase(options.getText())) {
					options.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void lifeAssuredDetails(String sheetname) throws Exception
	{
		testCaseData(sheetname);
		ReadexcelFile.readExcel(sheetname);
		//area of operation
		selectByDropdown_Excel(area_Of_Operation,lineNumber,0);
		//defense type
		selectByDropdown_Excel(defense_type,lineNumber,1);
		Select fdata = new Select(fTitle);
		String title=fdata.getAllSelectedOptions().get(0).getText();
		System.out.println("Title is :"+title);
		if(title.equals("--select--")) {
			ScenarioType=2;
			ReadexcelFile.readExcel("Branch_Inward");
			selectByDropdown_Excel(fTitle,lineNumber,2);
			enterData_Excel(fname,lineNumber, 3);
			enterData_Excel(lname,lineNumber, 4);
			nbsDataEntry(sheetname, lineNumber);
			System.out.println("message  is : "+message.getText());
			if(message.getText().contains("Client Dedupe")) {
				clickOnElement(OKButton);
				clickOnElement(clientDedupe_button);
				logStep("Clicked on ClientDedupe button");
				attachScreen(driver);
				//clickOnElement(OKButton);
				closeButton.sendKeys(Keys.ESCAPE);
				logStep("Clicked on Close button");
				clickOnElement(nextButton);
				logStep("Next Button is clicked");
				attachScreen(driver);
			}

		}else {
			ScenarioType=1;
			clickOnElement(clientDedupe_button);
			logStep("Clicked on ClientDedupe button");
			attachScreen(driver);
			closeButton.sendKeys(Keys.ESCAPE);
			logStep("Clicked on Close button");
			nbsDataEntry(sheetname, lineNumber);
		}

	}
	public void SetApplicantBirthDate(int lineNumber) throws Exception{
		String doBirth =ReadexcelFile.readdata[lineNumber][4];
		waitTillElementToBeClickable(pDOB, driver);
		pDOB.sendKeys(doBirth);
		pDOB.sendKeys(Keys.ESCAPE);
	}
	public void addFamily(String sheet,String lineNumbers) throws Exception {
		ReadexcelFile.readExcel(sheet);
		int lineNbr;
		String [] lNumber;
		if(lineNumbers.contains(",")) {
			lNumber=lineNumbers.split(",");
		}else {
			lNumber=lineNumbers.split(" ");
		}
		for(String lnum:lNumber) {
			//family details
			lineNbr=Integer.parseInt(lnum);
			ReusableFunctions.waitForVisible(driver, familyMember);
			selectByDropdown_Excel(familyMember,lineNbr,0);
			enterData_Excel(ageatOnset, lineNbr, 1);
			selectByDropdown_Excel(healthStatus, lineNbr,2);
			clickOnElement(addFamily);
			ReusableFunctions.waitForVisible(driver, success_popup);
			success_popup.click();// c

		}
	}

	public void addPrevPolicy(String sheet,String lineNumbers) throws Exception {
		ReadexcelFile.readExcel(sheet);
		int lineNbr;
		String [] lNumber;
		if(lineNumbers.contains(",")) {
			lNumber=lineNumbers.split(",");
		}else {
			lNumber=lineNumbers.split(" ");
		}
		for(String lnum:lNumber) {
			//family details
			lineNbr=Integer.parseInt(lnum);
			ReusableFunctions.waitForVisible(driver, familyMember);
			selectByDropdown_Excel(familyMember,lineNbr,0);
			enterData_Excel(ageatOnset, lineNbr, 1);
			selectByDropdown_Excel(healthStatus, lineNbr,2);
			clickOnElement(addFamily);
			ReusableFunctions.waitForVisible(driver, success_popup);
			success_popup.click();// c

		}
	}

	public void proposerDetails(String sheet) throws Exception {
		testCaseData(sheet);
		ReadexcelFile.readExcel(sheet);
		enterData_Excel(pFatherName, lineNumber, 3);
		SetApplicantBirthDate(lineNumber);
		selectByDropdown_Excel(pGender, lineNumber,5);
		selectByDropdown_Excel(pMarStatus, lineNumber,6);
		selectByDropdown_Excel(pNationality, lineNumber,7);
		selectByDropdown_Excel(pResStatus, lineNumber,8);
		selectByDropdown_Excel(pAgeProof, lineNumber,9);
		//waitForVisible(driver, pPanNo);
		enterData_Excel(pPanNo, lineNumber, 10);
		selectByDropdown_Excel(pRelWithLA, lineNumber,12);
		//--comm details
		selectByDropdown_Excel(pAddressType, lineNumber, 13);
		enterData_Excel(pAddressLine1, lineNumber, 14);
		//setCity(pCity, lineNumber, 15);
		selectByDropdown_Excel(pCountry, lineNumber, 16);
		selectByDropdown_Excel(pAddressProof, lineNumber, 17);
		selectByDropdown_Excel(paddress2SameAsAdd1, lineNumber, 18);
		selectByDropdown_Excel(pAddress3, lineNumber, 19);
		selectByDropdown_Excel(pAddress3toadd2, lineNumber, 35);
		selectByDropdown_Excel(pEducation, lineNumber, 20);
		selectByDropdown_Excel(pQualification, lineNumber, 21);
		selectByDropdown_Excel(pOccupation, lineNumber, 22);
		selectByDropdown_Excel(pSubOccupation, lineNumber, 23);
		selectByDropdown_Excel(pOrgType, lineNumber, 24);
		enterData_Excel(pAnnualIncome, lineNumber, 25);
		selectByDropdown_Excel(pIncomeProof, lineNumber, 26);
		selectByDropdown_Excel(pIDProof, lineNumber, 27);
		selectByDropdown_Excel(pPExposed, lineNumber, 28);
		selectByDropdown_Excel(pEmail, lineNumber, 29);
		selectByDropdown_Excel(pSMS, lineNumber, 30);
		selectByDropdown_Excel(pLang, lineNumber, 31);
		selectByDropdown_Excel(pDay, lineNumber, 32);
		selectByDropdown_Excel(pFromTime, lineNumber, 33);
		selectByDropdown_Excel(pToTime, lineNumber, 34);
		clickOnElement(pNextClick);
		try {
			if(message.getText().contains("Proposer Client Dedupe")) {
				logger.info(message.getText());
				logStep(message.getText());
				clickOnElement(OKButton);
				clickOnElement(pClientDedupe);
				waitForVisible(driver, closeButton);
				closeButton.click();
				clickOnElement(pNextClick);
				logger.info("Proposer details filled Successfully");
				logStep("Proposer details filled Successfully");
			}
		}catch(Exception e) {
			logger.info("Proposer details filled Successfully");
			logStep("Proposer details filled Successfully");
		}
	}

	public void bank_details()throws Exception
	{
		logger.info("Entered Bank details section");
		logStep("Entered Bank details section");
		clickOnElement(click_next_BankDetails);
		logStep("Clicked on Next button");
	}

	public void SetApplicantBirthDate(String sheet,int lineNumber) throws Exception{
		ReadexcelFile.readExcel(sheet);
		String doBirth =ReadexcelFile.readdata[lineNumber][4];
		waitTillElementToBeClickable(n_dob, driver);
		n_dob.sendKeys(doBirth);
		n_dob.sendKeys(Keys.ESCAPE);

		/*	logger.info("DOB of Applicant Selected: " + strdate + "" + strmonth + "" + stryear);
		ReusableActions.logStep("DOB of Applicant Selected: " + strdate + "" + strmonth + "" + stryear);
		 */
	}
	public void nominee_details(String sheet)throws Exception
	{
		testCaseData(sheet);
		ReadexcelFile.readExcel(sheet);
		logger.info("Entered to Nominee details section");
		logStep("Entered to Nominee details section");
		ReusableFunctions.waitForVisible(driver, title);
		selectByDropdown_Excel(title,lineNumber, 0);
		enterData_Excel(n_fname, lineNumber, 1);
		enterData_Excel(n_surname, lineNumber,2);
		selectByDropdown_Excel(n_gender, lineNumber, 3);
		SetApplicantBirthDate(sheet,lineNumber);
		//enterData_Excel(n_dob, lineNumber, 4);
		selectByDropdown_Excel(n_relationship, lineNumber, 5);
		enterData_Excel(n_share, lineNumber,6);
		attachScreen(driver);
		clickOnElement(click_next_NomineeDetails);
		logStep("Clicked on Next Button");
	}

	public void product_deatils(String sheet)throws Exception
	{
		testCaseData(sheet);
		ReadexcelFile.readExcel(sheet);
		logger.info("Entered product details section");
		logStep("Entered product details section");
		//		clickOnElement(getQuoteBtn);
		//		attachScreen(driver);
		//		logStep("Clicked on GetQuote button");
		//		clickOnElement(updateQuoteBtn);
		//		logStep("Clicked on UpdateQuote button");
		//		waitForVisible(driver, popup_quoteDetailsSuccess);
		//		clickOnElement(popup_quoteDetailsSuccess);
		//		attachScreen(driver);
		//		logStep("Quote details saved Successfully ");
		//		logStep("Clicked on OK button");
		//		pressESC(driver);
		if(ScenarioType==1) {
			waitForVisible(driver, coverType);
			selectByDropdown_Excel(coverType, lineNumber, 0);
			selectByDropdown_Excel(campaignCode, lineNumber, 1);
			selectByDropdown_Excel(renewalPaymentOption, lineNumber, 2);
			selectByDropdown_Excel(PANCardStatus, lineNumber, 3);
			attachScreen(driver);
			clickOnElement(click_next_productDetails);
			logger.info("Entered Repository Details section");
			logStep("Entered Repository Details section");
			clickOnElement(click_next_RepositoryDetails);
			attachScreen(driver);
			logStep("Clicked on Next button");
		}else {
			clickOnElement(getQuoteBtn);
			clickOnElement(updateQuoteBtn);
			logStep("Clicked on UpdateQuote button");
			waitForVisible(driver, popup_quoteDetailsSuccess);
			logStep(message.getText());
			clickOnElement(popup_quoteDetailsSuccess);
			attachScreen(driver);
			logStep("Quote details saved Successfully ");
			logStep("Clicked on OK button");
//			clickOnElement(pGetQuoteBtn);
//			waitForVisible(driver, popup_quoteDetailsSuccess);
			
			pressESC(driver);
			//clickOnElement(popup_quoteDetailsSuccess);
			attachScreen(driver);
			logStep("Quote details saved Successfully after getQuote Clicked ");
			logStep("Clicked on OK button");
			
			selectByDropdown_Excel(pStrategy, lineNumber, 4);
			selectByDropdown_Excel(pStPlan, lineNumber, 5);
			
			selectByDropdown_Excel(pFundName, lineNumber, 7);
			enterData_Excel(pFundPerc, lineNumber,8);
			clickOnElement(pClickAdd);
			try {
				logger.info(message.getText());
				logStep(message.getText());
				clickOnElement(OKButton);
			}catch(Exception e) {
				logger.info("Fundname not added successfully");
				logStep("Fundname not added successfully");
			}
			waitForVisible(driver, coverType);
			selectByDropdown_Excel(coverType, lineNumber, 0);
			selectByDropdown_Excel(campaignCode, lineNumber, 1);
			selectByDropdown_Excel(renewalPaymentOption, lineNumber, 2);
			selectByDropdown_Excel(PANCardStatus, lineNumber, 3);
			attachScreen(driver);
			clickOnElement(click_next_productDetails);
			logger.info("Entered Repository Details section");
			logStep("Entered Repository Details section");
			clickOnElement(click_next_RepositoryDetails);
		
		}
		
	}




	public void questions(String sheet)throws Exception
	{
		testCaseData(sheet);
		ReadexcelFile.readExcel(sheet);
		List<WebElement> questionsList = driver.findElements(By.xpath("//select[@ng-model='QuestionObj.QVALUE']"));
		System.out.println("Size of the q's "+questionsList.size());
		waitForVisible(driver, questionsList.get(0));
		attachScreen(driver);
		for(int qNo=0;qNo<=questionsList.size()-2;qNo++) {
			if(ScenarioType!=1) {
				if(qNo==25) {
					qNo=30;
				}else {
					System.out.println("Scenario is : "+ScenarioType);
				}
			}
			try {
				System.out.println(qNo+"-----"+ReadexcelFile.readdata[lineNumber][qNo].toString());
				selectByDropdown_Excel(questionsList.get(qNo), lineNumber, qNo);

			}catch(Exception e) {
				//ReusableFunctions.waitForVisible(driver, questionsList.get(qNo));
				logger.info("qNo is : "+qNo);
				logStep("qNo is : "+qNo);
				//
				if(ScenarioType!=1) {
					WebElement textnew = driver.findElement(By.xpath("//div[@class=\"panel panel-default ng-isolate-scope\"]/div[2]/div/div/div[4]/div[3]/div/div[2]/input"));
					enterData_Excel(textnew, lineNumber, qNo);
				}else {
					waitForVisible(driver, nameOfLifeInsured);
					enterData_Excel(nameOfLifeInsured, lineNumber, qNo);
				attachScreen(driver);
				}
			}
		}
		attachScreen(driver);

		//waitForVisible(driver, locator);

		clickOnElement(click_next_Question);

		clickOnElement(success_popup);
		waitForVisible(driver, click_next_ProposalSign_Date);
		clickOnElement(click_next_ProposalSign_Date);
		clickOnElement(submit_button);
		if(message.getText().contains("Please Load all the data")) {
			clickOnElement(popup_quoteDetailsSuccess);
			attachScreen(driver);
			clickOnElement(submit_button);
			if(message.getText().contains("Please ReGenerate the Quote")) {
				waitForVisible(driver, popup_quoteDetailsSuccess);
				attachScreen(driver);
				clickOnElement(popup_quoteDetailsSuccess);
				System.out.println("============");
				select_option_dataEntry("Product Details");
				clickOnElement(getQuoteBtn);
				attachScreen(driver);
				clickOnElement(updateQuoteBtn);
				waitForVisible(driver, popup_quoteDetailsSuccess);
				attachScreen(driver);
				clickOnElement(popup_quoteDetailsSuccess);
				pressESC(driver);
				clickOnElement(submit_button);
				waitForVisible(driver, popup_quoteDetailsSuccess);
				clickOnElement(popup_quoteDetailsSuccess);
			}
		}


	}


}
