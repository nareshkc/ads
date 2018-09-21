package pageObjectClasses;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class InBoxPage extends ReusableFunctions {
	WebDriver driver;
	public InBoxPage(WebDriver driver) 
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
	//receipt option
	@FindBy(id="ID56")
	@CacheLookup
	WebElement receipt;

	//Pending branch scrutny 
	@FindBy(id="ID48")
	@CacheLookup
	WebElement pbScrutny;



	public void clickon(String optionName) throws Exception {
		if(optionName.equalsIgnoreCase("Receipt")) {
			waitForVisible(driver,receipt);
			receipt.click();
			logger.info("clicked on : " +optionName);
			logStep("clicked on : " +optionName);
			attachScreen(driver);
		}else if(optionName.equalsIgnoreCase("pbScrutny")) {
			waitForVisible(driver,pbScrutny);
			pbScrutny.click();
			logger.info("clicked on : " +optionName);
			logStep("clicked on : " +optionName);
			attachScreen(driver);
		}


	}
}
