package Cosmos_Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectClasses.ApplicationTracker;
import pageObjectClasses.BranchScanAndIndex;
import pageObjectClasses.CallVerfication;
import pageObjectClasses.CopsQC;
import pageObjectClasses.Cops_Inward;
import pageObjectClasses.DispatchMode;
import pageObjectClasses.HomePage;
import pageObjectClasses.InBoxPage;
import pageObjectClasses.LoginPage;
import pageObjectClasses.NBSBranchInward;
import pageObjectClasses.NBSDataEntry;
import pageObjectClasses.PendingbranchScrutny;
import pageObjectClasses.ProposalDetails;
import pageObjectClasses.ProposalEnquiry;
import pageObjectClasses.ReceiptPage;
import pageObjectClasses.UnderWriting;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import utilities.ReusableFunctions;


public class LACosmosToIL extends ReusableFunctions{public LoginPage loginPage;
public HomePage homePage;
public InBoxPage inBoxPage;
public ReceiptPage receiptPage;
public ProposalDetails poposalDetails ;
public PendingbranchScrutny pbScrutny;
public NBSBranchInward nbsBranchInward; 
public BranchScanAndIndex scanindex;
public ProposalEnquiry proposalEnquiry;
public NBSDataEntry nbsDataEntry;
public Cops_Inward copsInwardobj;
public CopsQC copsQcObj;
public DispatchMode dispatchMode;
public ApplicationTracker applicationTracker;
public CallVerfication callVerfication;
public UnderWriting uw;
public  static String ProNumber=null;


public void launching(String browserName) {
	Scenario=2;
	launchBrowser(browserName);
	homePage=PageFactory.initElements(driver, HomePage.class);
	inBoxPage=PageFactory.initElements(driver, InBoxPage.class);
	receiptPage=PageFactory.initElements(driver, ReceiptPage.class);
	poposalDetails=PageFactory.initElements(driver, ProposalDetails.class);
	pbScrutny=PageFactory.initElements(driver, PendingbranchScrutny.class);
	scanindex=PageFactory.initElements(driver, BranchScanAndIndex.class);
	copsInwardobj = PageFactory.initElements(driver, Cops_Inward.class);
	nbsDataEntry=PageFactory.initElements(driver, NBSDataEntry.class);
	proposalEnquiry=PageFactory.initElements(driver, ProposalEnquiry.class);
	copsQcObj = PageFactory.initElements(driver, CopsQC.class);
	loginPage = PageFactory.initElements(driver, LoginPage.class);
	nbsBranchInward = PageFactory.initElements(driver, NBSBranchInward.class);
	dispatchMode=PageFactory.initElements(driver, DispatchMode.class);
	applicationTracker = PageFactory.initElements(driver, ApplicationTracker.class);
	callVerfication = PageFactory.initElements(driver, CallVerfication.class);
	uw=PageFactory.initElements(driver, UnderWriting.class);
	loginPage.lcountno=0;

}
@BeforeTest
public void beforeTest() throws Exception
{
	testcaseName="LA Cosmos TO IL";
	launching("chrome");

}

@Stories("LA Cosmos TO IL")
@Title("Select Branch Inword bucket and fill the data")
@Description("Select BranchInword and fill the data then click on submit ")
@Test(priority=1,enabled=true)
public void selectNBSBranchInward()throws Exception
{
		loginPage.login();
		nbsBranchInward.HoveronNs();
		nbsBranchInward.branchInward_details();
	
}

@Stories("LA Cosmos TO IL")
@Title("Submit Receipt Bucket")
@Description("Search with application number in Receipt and fill requierd data and submit ")
@Test(priority=2,enabled=true,dependsOnMethods = { "selectNBSBranchInward" })
public void submitReciept() throws Exception 
{
		homePage.clickOnOption("inBox");
		inBoxPage.clickon("Receipt");
		receiptPage.searchwithproposalNo(randonProNumber);
		poposalDetails.selectBrach("HO");
		poposalDetails.clikonbutton("addInstrumnet");
		poposalDetails.fillInstrumentDetails();
	
}

@Stories("LA Cosmos TO IL")
@Title("Pending brach scrytny bucket")
@Description("Search with application number and Submit")
@Test(priority=3,enabled=true,dependsOnMethods = { "submitReciept" })
public void pendingBranchScrutny() throws Exception 
{
		homePage.clickOnOption("inBox");
		inBoxPage.clickon("pbScrutny");
		pbScrutny.searchWithproposalNo(randonProNumber);
		pbScrutny.checkresult();
	
}

@Stories("LA Cosmos TO IL")
@Title("DispatchMode bucket")
@Description("Search with application number and submit")
@Test(priority=4,enabled=true,dependsOnMethods = { "pendingBranchScrutny" })
public void selectDispatch() throws Exception 
{

		homePage.HoverOnMenu("NBS");
		//	homePage=PageFactory.initElements(driver, HomePage.class);
		homePage.selectOptionfromMenu("Dispatch Mode");
		dispatchMode.selectNewBusiness();
		dispatchMode.searchwithproposalNo(randonProNumber);
		dispatchMode.selectDispatchMode();
		dispatchMode.clkSubmit();
		dispatchMode.clickOnOK();
	
}
@Stories("LA Cosmos TO IL")
@Title("Scan and Index bucket")
@Description("Search with application number and upload requiered documents and submit")
@Test(priority=5, enabled=true,dependsOnMethods = { "selectDispatch" })
public void scanAndIndex()throws Exception
{	
		homePage.clickOnOption("inBox");
		scanindex.clickOnOption("BranchScanAndIndex");
		scanindex.searchwithproposalNo(randonProNumber);
		scanindex.uploadFile();

	
}
@Stories("LA Cosmos TO IL")
@Title("Cops inward bucket")
@Description("Search with application number and submit")
@Test(priority = 6, enabled = true,dependsOnMethods = { "scanAndIndex" })
public void copsInwardBucket() throws Exception {
		homePage.HoverOnMenu("NBS");
		homePage.selectOptionfromMenu("Cops Inward");
		copsInwardobj.selectNewBusinesss();
		copsInwardobj.checkPropNo(randonProNumber);
		copsInwardobj.clickSubmit();
		copsInwardobj.checkresult();
}
@Stories("LA Cosmos TO IL")
@Title("NBS data entry bucket")
@Description("Search with application number and enter all the requiered data and submit")
@Test(priority=7,enabled=true,dependsOnMethods = { "copsInwardBucket" })
public void nbsDataEntry() throws Exception
{
		//loginPage.login(1);
		nbsDataEntry.clickon_option("NBSDataEntry");
		nbsDataEntry.searchWithProposalNo(randonProNumber);
		nbsDataEntry.select_option_dataEntry("Life Assured Details");
		nbsDataEntry.lifeAssuredDetails("NBSData_Entry");
		nbsDataEntry.proposerDetails("PropserDetails");
		//nbsDataEntry.select_option_dataEntry("Nominee Details");
		nbsDataEntry.bank_details();
		//nbsDataEntry.nominee_details("NomineeDeatils",1);
		nbsDataEntry.product_deatils("ProductDetails");
		nbsDataEntry.questions("Questions_CosmosToIL");
		//nbsDataEntry.logout(); // logout
		driver.quit();

}
@Stories("LA Cosmos TO IL")
@Title("CopsQC bucket")
@Description("Search with application number and Verify all the NBS data entered correctly ")
@Test(priority = 8,enabled = true,dependsOnMethods = { "nbsDataEntry" })
public void copsQc() throws Exception {
		//randonProNumber="MNB3253841";
		launching("chrome");
		loginPage.login();
		//homePage.logOutUser();
		homePage.clickOnOption("inBox");
		copsQcObj.gotoCopsQcBucket();
		copsQcObj.nbsTaskSearch(randonProNumber);
		copsQcObj.clkPropNo();
		copsQcObj.enterlifeAsurdDetails();
		copsQcObj.enterproductDetails();
		copsQcObj.submitcopQC();
		driver.navigate().refresh();
		driver.quit();
		
	
}


@Stories("LA Cosmos TO IL")
@Title("Call Verification bucket ")
@Description("Search with application number and wait for Call verification ")
@Test(priority=9 , enabled = false)
public void callVerificationBucket() throws Exception {
		callVerfication.clickon("Call Verfication");
		callVerfication.searchwithproposalNo(randonProNumber);
	
}


@Stories("LA Cosmos TO IL")
@Title("UW bucket")
@Description("Search with application number and complete UW")
@Test(priority=10, enabled= true,dependsOnMethods = { "copsQc" })
public void UWBucket()throws Exception
{
	launching("chrome");
	loginPage.login();
	homePage.clickOnOption("inBox");
	//randonProNumber="MNB3447978";
	driver.navigate().refresh();
		uw.clickon("UW");
		uw.reAssignTask();
		uw.searchwithproposalNo(randonProNumber);
		uw.underWriting(1, randonProNumber);
}

@Stories("LA Cosmos to IL")
@Title("Application Tracker bucket ")
@Description("Search with application number and wait for realization ")
@Test(priority=11 , enabled = true,dependsOnMethods = { "UWBucket" })
public void applicationTracker() throws Exception {
	
	/*launching("chrome");
	loginPage.login(2);*/
	homePage.HoverOnMenu("NBS");
	homePage.selectOptionfromMenu("Application Tracker");
	applicationTracker.proNoSearchAndClick(randonProNumber);
	
}

@Stories("LA Cosmos to IL")
@Title("Proposal enquiry and Receipt details bucket")
@Description("Search with application number and get the receipt details with receipt No. for realization")
@Test(priority=12,enabled=true,dependsOnMethods = { "applicationTracker" })
public void proposalEnquiry()throws Exception
{
		proposalEnquiry.hoveronPE();
		proposalEnquiry.srchcriteria();
		proposalEnquiry.checkReceiptDetails();

}


@AfterTest
public void aftermethod()
{
	driver.quit();
}
}
