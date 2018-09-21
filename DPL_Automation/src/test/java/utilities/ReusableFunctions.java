package utilities;


import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjectClasses.NBSDataEntry;
import read_Excel_Data.ReadexcelFile;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;


public class ReusableFunctions extends DriverClass{
	public static Logger logger = LoggerFactory.getLogger(NBSDataEntry.class);
	public static String path = null;
	public static String randonProNumber=null;
	static Robot robot;
	public static int Scenario;
	public static int lineNumber;
	public int countno;
	public static String testcaseName;
	Actions a1;
	//Function for Print the steps in allure report
	@Step("{0}")
	public static void logStep(String stepName ){

	}

	public static void selectBydropDown(WebElement ele, String value) {
		ele.click();
		Select paymentoption= new Select (ele);
		paymentoption.selectByVisibleText(value);
		logger.info("Selected option is : "+ value.toString());
		logStep("Selected option is : "+ value.toString());
	}

	public static void selectByDropdown_Excel(WebElement ele,int lineNumber,int column_num)throws Exception {

		ele.click();
		Select option= new Select (ele);
		String str=ReadexcelFile.readdata[lineNumber][column_num].toString();
		option.selectByVisibleText(str);
		logger.info("Selected option is : "+ str);
		logStep("Selected option is : "+ str);
	}

	//	public void actionScroll(WebElement ele)
	//	{
	//		a1= new Actions(driver);
	//		//WebDriverWait wait = new WebDriverWait(driver, 120);
	//		a1.moveToElement(ele).build().perform();
	//	}

	public static void enterdata(WebElement ele, String value)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		ele.clear();
		ele.sendKeys(value);
		logger.info("Enter data :" +value.toString());
		logStep("Enter data :" +value.toString());
	}

	//Reading Teest data


	public int testCaseData(String sheetName) {
		String[] lnumbers;
		String lnumber;
		ReadexcelFile.readExcel("Test_case");
			outer:
			for(int exloop=0;exloop<=ReadexcelFile.maxCell;exloop++) {
				if(ReadexcelFile.readdata[0][exloop].contains(sheetName)) {
					for(int testloop=0;testloop<=ReadexcelFile.lastRow;testloop++) {
						if(testcaseName.equals(ReadexcelFile.readdata[testloop][0])) {
							lnumber=ReadexcelFile.readdata[testloop][exloop].toString();
							if(lnumber.contains(",")) {
								lnumbers = lnumber.split(",");
								for(int ldata=countno;ldata<=lnumbers.length;ldata++) {
									lineNumber=Integer.parseInt(lnumbers[ldata].toString());
									if(ldata==lnumbers.length-1) {
										System.out.println("");
										ldata=lnumbers.length;
									}else {
										countno=countno+1;
										ldata=lnumbers.length;
									}	
								}
								
							}else {
								lnumbers = lnumber.split(" ");
								lineNumber=Integer.parseInt(lnumbers[0].toString());
								break outer;
							}
							break outer;
						}else {
							//logger.info("Testcase name not matched with test data");
							//ogStep("Testcase name not matched with test data");
							if(testloop==ReadexcelFile.lastRow) {
								Assert.fail("Testcase name not matched with test data");
							}else {
								System.out.println("");
							}
						}
					}

				}else {
					logger.info("sheet Name not matched with test data");
					logStep("Sheet Name not matched with test data");
					if(exloop==ReadexcelFile.maxCell) {
						Assert.fail("Sheet Name not matched with test data");
					}else {
						System.out.println("");
					}
				}

			}
		return lineNumber;
	}
	public static void enterData_Excel(WebElement ele,int lineNumber,int columnnum)throws Exception
	{
		String data = ReadexcelFile.readdata[lineNumber][columnnum].toString();
		ele.sendKeys(data);
		String value= data.toString();
		logger.info("Enter data :" +value);
		logStep("Enter data :" +value);
	}

	//Function for take the screen shot in allure report
	@Attachment("Screenshot")
	public static byte[] attachScreen(WebDriver driver ) {
		logStep("Taking screenshot");
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment("Error_Screenshot")
	public static byte[] attachScreen_TestCaseError(WebDriver driver ) {
		logStep("Taking screenshot");
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	//Mouse hover
	public static void mouseHover(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}
	//Launch browser based on select 
	public static void launchBrowser(String browserName) {
		path = System.getProperty("user.dir");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"\\lib\\chromedriver.exe");
			logStep("User Selected Chrome Browser to execute");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", path+"\\lib\\geckodriver.exe");
			logStep("User Selected Firefox Browser to execute");
			driver = new FirefoxDriver();

		}/*else if(browserName.equalsIgnoreCase("IE")) {

		}*/

		logStep(browserName+"  Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://10.50.46.80/home/dpli/insurance/DPLIIndex3.htm#/NBbranchInward");
		logStep("Url entered : http://10.50.46.80/home/dpli/insurance/DPLIIndex3.htm#/NBbranchInward");
	}

	//Wait functions
	public static WebElement waitTillElementVisible(WebElement element, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}

	public static WebElement waitTillElementTobeLocated(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return elementloaded;
	}

	public static WebElement waitTillElementToBeClickable(WebElement element, WebDriver driver) throws Exception {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementloaded = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementloaded;
	}


	public static void waitForVisible(WebDriver driver,WebElement locator) throws Exception {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	//Wait for Page Load
	public static void waitTillPageLoaded(WebDriver driver)  {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Click functionality by Java Script
	public static void clickByJS(WebElement el, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Move to Element Function 
	public static void moveToElement(WebElement element, WebDriver driver) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	// Point To Element
	public static void pointToElement(WebElement e1, WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
	}

	// Function for provide wait for VerifyPage Title
	public static void verifypageTitle(String str, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(str));
	}

	public static void pressESC(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}
	public static void clickOnElement(WebElement ele) {
		try {
			waitTillElementToBeClickable(ele, driver);
			ele.click();
			logStep("Click on Next button ");
		}catch(Exception e) {
			//System.out.println("Element not present on the screen / not clickabel");
			logger.info("Element not present on the screen / not clickabel");
			logStep("Element not present on the screen / not clickabel");
		}
	}
	public static void enterText_old(WebElement ele,String text) {
		try {
			ele.clear();	
			ele.sendKeys(text);
			logStep("Entered text is :" + text);
		}catch(Exception e) {
			//System.out.println("Element not present on the screen / not Editable");
			logger.info("Element not present on the screen / not clickabel");
			logStep("Element not present on the screen / not clickabel");
		}
	}

	public static void enterText(WebElement ele,int lineNumber) {
		for(int i=0;i<=ReadexcelFile.maxCell-1;i++) {
			if(ele.toString().contains(ReadexcelFile.readdata[0][i].toString())) {
				try {
					ele.clear();	
					ele.sendKeys(ReadexcelFile.readdata[lineNumber][i]);
					break;
				}catch(Exception e) {
					//System.out.println("Element not present on the screen / not Editable");
					logger.info("\"Element not present on the screen / not Editable\"");
					logStep("Element not present on the screen / not Editable");
				}
			}
		}

	}


	public static void scroll_window(WebDriver driver,String scrollType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(scrollType.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,1000)");
		}/*else  if(scrollType.equalsIgnoreCase("up")){

		}*/
	}

	public static String genarateProposalNumber(String proposalstarting) 
	{				
		Random rnd = new Random();	
		int n = 1000000 + rnd.nextInt(9000000);	
		randonProNumber = proposalstarting+String.valueOf(n);	
		//System.out.println("Random Proposal number : "+randonProNumber.toString());
		logger.info("Random Proposal number generated : "+randonProNumber.toString());
		logStep("Random Proposal number generated: "+randonProNumber.toString());
		return randonProNumber;
	}


}
