package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class CopsQC extends ReusableFunctions {

	public static Logger logger = LoggerFactory.getLogger(NBSDataEntry.class);

	WebDriver driver;
	public CopsQC(WebDriver driver) 
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

	@FindBy(id = "ID13")
	WebElement copsQcBucket;

	@FindBy(id = "searchNBSField")
	WebElement searchNBS;

	@FindBy(xpath = "//div[@class='tab-pane ng-scope active']/accordion/div/div[1]/div[1]/h4")
	WebElement lifeAssuredDetails;

	@FindBy(xpath ="//*[@id=\"taskId[$index]\"]/td[2]/a")
	WebElement clickPropNo;

	@FindBy(xpath ="//div[@class='tab-pane ng-scope active']//*[@class='panel panel-default ng-isolate-scope']")
	WebElement dataEntryList;

	@FindBy(xpath ="//div[@class='tab-content']//div[@class='panel-group']//h4/a//span")
	WebElement laData;

	@FindBy(xpath ="//*[@type='checkbox' and @class='ng-pristine ng-valid']")
	List<WebElement> checkBoxLADetails;

	@FindBy(xpath ="//select[@ng-model='nbsDataEntry.laComunicationaddsameasPer']")
	WebElement addDetails2SameasComDetDD;

	@FindBy(xpath ="//select[@ng-model='nbsDataEntry.laAdd3sameasAddField']")
	WebElement CommAddresssDetails;

	@FindBy(xpath ="//select[@ng-model='nbsDataEntry.laAdd3sameasAdd']")
	WebElement addDetails3SameasComDetDD;

	@FindBy(xpath ="//input[@ng-model='checkla47']")
	WebElement annualIncomCheckBox;

	@FindBy(xpath ="//select[@ng-model='nbsDataEntry.PoAdd3sameasAdd']")
	WebElement address3sameas;
	@FindBy(xpath ="//select[@ng-model='nbsDataEntry.PComunicationaddsameasPer']")
	WebElement address2sameasaddress3;

	@FindBy(xpath ="//button[@ng-click='nextTab(0)']")
	WebElement lifeAsrdnextBtn;

	@FindBy(xpath ="//button[@ng-click='nextTab(1)']")
	WebElement proposerDetailsNextBtn;

	@FindBy(xpath ="//button[@ng-click='nextTab(2)']")
	WebElement bnkDetailsnextBtn;

	@FindBy(xpath ="//button[@ng-click='nextTab(3)']")
	WebElement nomineeDetailsnextBtn;

	@FindBy(id ="checkLaCoverType1")
	WebElement coverTyp;

	@FindBy(id ="checkcampCode1")
	WebElement campCode;

	@FindBy(id ="checklaRpayopId1")
	WebElement renwPayOptn;

	@FindBy(id ="checklaPanStatusId1")
	WebElement panStatus;

	@FindBy(id ="checkExmResn1")
	WebElement panChangeRsn;

	@FindBy(xpath ="//*[@type='checkbox' and @class='ng-valid ng-dirty']")
	List<WebElement> prodcheckBoxLADetails;

	@FindBy(xpath ="//select[@ng-model=\"nbsDataEntry.finanicalRequirement\"]")
	WebElement finReq;

	//ProdDetails Next Tab
	@FindBy(xpath ="//button[@ng-click='nextTab(4)']")
	WebElement prodDetailsNxtTab;

	@FindBy(xpath ="//button[@ng-click='nextTab(5)']")
	WebElement repoDetailsNxtTab;

	@FindBy(xpath ="//button[@ng-click='nextTab(6)']")
	WebElement queDetailsNxtTab;

	@FindBy(xpath ="//button[@ng-click='nextTab(7)']")
	WebElement proSgnDateNxtTab;

	//complete btn
	@FindBy(xpath ="//button[text()='Complete']")
	WebElement completeBtn;

	@FindBy(xpath="//p[@style='display: block;']")
	WebElement message;


	@FindBy(xpath="/html/body/div[8]/p")
	WebElement message1;
	
	

	@FindBy(xpath="//button[@class='confirm']")
	WebElement popup_quoteDetailsSuccess;

	@FindBy(xpath="//button[@ng-click='updateQuoteandRider()']") 
	WebElement getQuoteBtn;

	@FindBy(xpath="//button[@ng-click='getQuote()']") 
	WebElement updateQuoteBtn;

	@FindBy(xpath="/*[@type='checkbox' and @ng-model='nbsDataEntry.LifeAssuredNotPayer']")
	WebElement firstCheckBox;

	public void gotoCopsQcBucket() throws Exception

	{

		waitTillElementToBeClickable(copsQcBucket, driver);
		clickOnElement(copsQcBucket);
		logStep("Select copsQC bucket on Inbox");
	}

	public void nbsTaskSearch(String propNo) throws Exception
	{
		logStep("Verification for proposal number : "+propNo);
		waitTillElementToBeClickable(searchNBS, driver);
		enterText_old(searchNBS, propNo);
	}



	public void clickondatatEntry(String moduleType) throws Exception {
		waitForVisible(driver,dataEntryList);
		// dataEntryList.click();
		List<WebElement> checkBox=null;
		logStep("Started verification for CopsQC");
		if(moduleType.contains("Life Assured Details")) {
			laData.click();
			checkBox =driver.findElements(By.xpath("//*[@type='checkbox' and @class='ng-pristine ng-valid']"));
		}else if(moduleType.contains("Product Details"))  {
			checkBox =driver.findElements(By.xpath("//*[@type='checkbox' and @class='ng-pristine ng-valid']"));
		}else if(moduleType.contains("Proposer Details"))  {
			checkBox =driver.findElements(By.xpath("//*[@type='checkbox' and @class='ng-pristine ng-valid']"));
		}

		String checkSource=null;
		String checkDest=null;
		String fData=null;
		String lData=null;		
		System.out.println("CheckBox size is : "+checkBox.size());
		for(int i=0;i<=checkBox.size();i++) {
			try {

				if(moduleType.contains("Life")) {
					if(i<=2) {
						i=3;
					}  if(i==145) {
						break;
					}
				}else if(moduleType.contains("Product Details")) {
					if(Scenario==2) {
						if(i<=335) {
							i=335;

						}else {
							if(i==350) {
								break;
							}
						}
					}else {
						if(i<=406) {
							i=407;

						}
						else {
							System.out.println();
						}
					}
				}
				else if(moduleType.contains("Proposer Details"))
				{
					if(i<=125) {
						i=125;
					}
					if(i==261) {
						break;
					}

				}

				checkBox.get(i).click();
				System.out.println(("======================================="+i));
				checkDest=checkBox.get(i).getAttribute("destination");
				//System.out.println(checkDest);
				checkSource=checkBox.get(i).getAttribute("source1");

				//				System.out.println(checkSource);
				WebElement fEle=driver.findElement(By.id(checkSource));
				String ftag=fEle.getTagName();
				if(ftag.contains("select")) {
					Select fselect = new Select(fEle);
					fData=fselect.getFirstSelectedOption().getText();
					System.out.println(("---fData is : ----"+fData));
				}else {
					fData=fEle.getAttribute("value");
					System.out.println(("---fData is : ----"+fData));
				}
				WebElement lEle=driver.findElement(By.id(checkDest));
				String ltag=fEle.getTagName();
				if(ltag.contains("select")) {
					Select lselect = new Select(lEle);
					lData=lselect.getFirstSelectedOption().getText();
					System.out.println(("---lData is : ----"+lData));
				}else {
					lData=lEle.getAttribute("value");
					System.out.println(("---lData is : ----"+lData));
				}

				fData=fData.replaceAll(",", "");
				lData=lData.replaceAll(",", "");
				if(fData.equals("")&&!lData.equals("")) {
					fData=lData;
				}else if(!fData.equals("")&&lData.equals("")) {
					lData=fData;
				}
				if(!fData.equalsIgnoreCase(lData)) {
					logger.info("Source date and Destination data not matched "+fData+"---"+lData);
					logStep("Source date and Destination data not matched "+fData+"---"+lData);
					attachScreen(driver);
					Assert.fail("Source date and Destination data not matched "+fData+"---"+lData);

				}else {
					logger.info("Source date and Destination data is matched "+fData+"---"+lData);
					logStep("Source date and Destination data is matched "+fData+"---"+lData);

					//					if(i%10==0) {
					//					attachScreen(driver);
					//					}
				}
				i=i+1;
			}catch(Exception e) {
				//ReusableFunctions.scroll_window(driver,"down");
				i=i+1;
			}
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
	public void clkPropNo()
	{	
		clickOnElement(clickPropNo);
		logStep("Selecting proposalnumber with search : "+randonProNumber);
	}

	public void enterlifeAsurdDetails() throws Exception {
		clickondatatEntry("Life Assured Details");
		waitForVisible(driver, addDetails2SameasComDetDD);	
		selectBydropDown(addDetails2SameasComDetDD, "Yes");
		clickOnElement(lifeAsrdnextBtn);
		if(Scenario==2) {
			clickondatatEntry("Proposer Details");
			//select[@ng-model="nbsDataEntry.PoAdd3sameasAdd"]
			selectBydropDown(address2sameasaddress3, "Yes");
			selectBydropDown(address3sameas, "YES");

			clickOnElement(proposerDetailsNextBtn);

		}
		clickOnElement(bnkDetailsnextBtn);
		clickOnElement(nomineeDetailsnextBtn);

	}
	public void getQuote() throws Exception
	{
		clickOnElement(getQuoteBtn);
		clickOnElement(updateQuoteBtn);
		logStep("Clicked on UpdateQuote button");
		waitForVisible(driver, popup_quoteDetailsSuccess);
		logStep(message.getText());
		clickOnElement(popup_quoteDetailsSuccess);
		attachScreen(driver);
		logStep("Quote details saved Successfully ");
		logStep("Clicked on OK button");
		//	clickOnElement(pGetQuoteBtn);
		//	waitForVisible(driver, popup_quoteDetailsSuccess);

		pressESC(driver);

	}

	public void enterproductDetails() throws Exception
	{
		clickondatatEntry("Product Details");
		selectBydropDown(finReq, "Received");
		clickOnElement(prodDetailsNxtTab);
		clickOnElement(repoDetailsNxtTab);
		waitForVisible(driver, queDetailsNxtTab);
		clickOnElement(queDetailsNxtTab);
		clickonOk();
		clickOnElement(proSgnDateNxtTab);
		waitForVisible(driver,completeBtn);
		clickOnElement(completeBtn);

	}

	public void clickonOk() {
		try {
			ReusableFunctions.waitForVisible(driver, popup_quoteDetailsSuccess);
			if(popup_quoteDetailsSuccess.isDisplayed()) {
				popup_quoteDetailsSuccess.click();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void submitcopQC() throws Exception {
		clickOnElement(completeBtn);
		logStep("After clicking Complete button : "+message.getText());
		logger.info("After clicking Complete button : "+message.getText());
		if(message.getText().contains("Please Load all the data")) {
			logStep("Click on Ok button and Lick again on Complet button for next step");
			logger.info("Click on Ok button and Lick again on Complet button for next step");
			clickOnElement(popup_quoteDetailsSuccess);
			if(Scenario==2) {
				laData.click();
				waitForVisible(driver, addDetails2SameasComDetDD);	
				selectBydropDown(addDetails2SameasComDetDD, "Yes");
				waitForVisible(driver, addDetails3SameasComDetDD);	
				selectBydropDown(addDetails3SameasComDetDD, "Yes");
				waitForVisible(driver, CommAddresssDetails);
				selectBydropDown(CommAddresssDetails, "Address Details 2");
				clickOnElement(annualIncomCheckBox);
				clickOnElement(annualIncomCheckBox);
			}
			clickOnElement(completeBtn);
			logStep("After clicking Complete button : "+message.getText());
			logger.info("After clicking Complete button : "+message.getText());
		}else  {
			logger.info("User clicked on Complete button on CopsQC bucket");
		}
		if(message.getText().contains("Please ReGenerate the Quote")) {
			waitForVisible(driver, popup_quoteDetailsSuccess);
			clickOnElement(popup_quoteDetailsSuccess);
			logStep("Click on Ok option");
			logger.info("Click on Ok option");
			System.out.println("============");
			select_option_dataEntry("Product Details");
			logger.info("Navigate to Product detail  page for ReGenarate teh Quote");
			logStep("Navigate to Product detail  page for ReGenarate teh Quote");
			clickOnElement(getQuoteBtn);
			clickOnElement(updateQuoteBtn);
			waitForVisible(driver, popup_quoteDetailsSuccess);
			clickOnElement(popup_quoteDetailsSuccess);
			pressESC(driver);
			logStep("Quote genarated successfully "+ message.getText());
			logger.info("Quote genarated successfully "+ message.getText());
			waitForVisible(driver,completeBtn);
			clickOnElement(completeBtn);
			logStep("Again click on Completed button for close the CopQC verification");
			logger.info("Again click on Completed button for close the CopQC verification");
			waitForVisible(driver, popup_quoteDetailsSuccess);
			logStep(message1.getText());
			logger.info(message1.getText());
			System.out.println(message1.getText());
			clickOnElement(popup_quoteDetailsSuccess);
		}
		
		
		Thread.sleep(3000);
	}








}
