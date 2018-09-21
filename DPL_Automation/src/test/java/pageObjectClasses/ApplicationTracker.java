package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class ApplicationTracker extends ReusableFunctions{

	WebDriver driver;
	public ApplicationTracker(WebDriver driver)
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

	//Search field for Proposal search
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//input[@ng-model='applicationno']")
	WebElement propNoInput;

	@FindBy(xpath = "//tr[@class='ng-scope']/td[1]")
	WebElement propNoClick;
	
	@FindBy(xpath = "//div[@class=\"iapp-table-enclosure\"]//tr[@ng-repeat=\"AppDetails in AppTrackDetails\"][11]/td[1]")
	WebElement trackerStatus;

	
	@FindBy(xpath = "//button[@ng-click=\"CloseModalTracker()\"]")
	WebElement closeButton;

	public void proNoSearchAndClick(String propNo) throws Exception {
		waitTillElementToBeClickable(propNoInput, driver);
		ReusableFunctions.enterdata(propNoInput, propNo);		
		clickOnElement(searchBtn);
		waitForVisible(driver, propNoClick);
		clickOnElement(propNoClick);
		checkTrackerStatus();
		attachScreen(driver);
		closeButton.click();
	}
	
	
	public void checkTrackerStatus() {
		List <WebElement> trackers =driver.findElements(By.xpath("//div[@class='iapp-table-enclosure']//tr[@ng-repeat='AppDetails in AppTrackDetails']/td[1]"));
		
		for(WebElement trackerActivity:trackers) {
			System.out.println(trackerActivity.getText());
			logger.info("Execution status in aplication tracker "+trackerActivity.getText());
			logStep("Execution status in aplication tracker "+trackerActivity.getText());
		}
		
	}




}
