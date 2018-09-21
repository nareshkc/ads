package pageObjectClasses;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class DispatchMode extends ReusableFunctions {

	WebDriver driver;
	public DispatchMode(WebDriver driver) 
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
	@FindBy(xpath="//div[@class='iapp-field']//select")
	WebElement applicationNameDDloc;

	@FindBy(xpath ="/html/body/div[4]/div/form/div/div[2]/div[2]/div[2]/div[2]/input")
	WebElement searchProposalNumloc;

	@FindBy(xpath = "/html/body/div[4]/div/form/div/div[2]/div[4]/div[1]/div[2]/select")
	WebElement dispatchMode;

	@FindBy(xpath = "/html/body/div[8]/p")
	WebElement message;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement SubmitBtn ;


	public void selectNewBusiness() throws Exception {

		waitForVisible(driver,applicationNameDDloc);
		ReusableFunctions.selectBydropDown(applicationNameDDloc,"New Business");

	}


	public void searchwithproposalNo(String ProposalNo) throws Exception {
		//NA2121221
		waitForVisible(driver,searchProposalNumloc);
		searchProposalNumloc.clear();
		searchProposalNumloc.sendKeys(ProposalNo);
		logStep("Entered proposal num is : " + ProposalNo);
		checkBox.click();
	}

	public void selectDispatchMode() throws Exception 
	{
		waitForVisible(driver,dispatchMode);
		ReusableFunctions.selectBydropDown(dispatchMode, "Scanning");
		attachScreen(driver);

	}

	public void clkSubmit() throws Exception {

		waitForVisible(driver,SubmitBtn);
		clickOnElement(SubmitBtn);
		attachScreen(driver);
		logStep("Clicked on Submit button");


	}
	public void clickOnOK() throws Exception{
		ReusableFunctions.waitTillElementToBeClickable(message, driver);
		attachScreen(driver);
		if(message.getText().contains("try again")) {
			logStep("Need to fill more data");
			logger.info("Need to fill more data");
		}else {
			waitForVisible(driver,driver.findElement(By.xpath("//button[@class='confirm']")));
			driver.findElement(By.xpath("//button[@class='confirm']")).click();
			System.out.println("");
		}


	}
}
