package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class PendingbranchScrutny extends ReusableFunctions{

	WebDriver driver;

	public PendingbranchScrutny(WebDriver driver) {
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
	@FindBy(id="searchNBSField")
	@CacheLookup
	WebElement searchBox;

	//Click on Submit
	@FindBy(xpath="//button[@class='btn btn-primary'][2]")
	@CacheLookup
	WebElement submit;

	//Check Success message
	@FindBy(xpath="/html/body/div[8]/p")
	@CacheLookup
	WebElement message;

	//Check Success message
	@FindBy(xpath="/html/body/div[8]/h2")
	@CacheLookup
	WebElement success;

	public void searchWithproposalNo(String proposalNo) throws Exception {
		//NA2121221
		waitForVisible(driver,searchBox);
		searchBox.clear();
		searchBox.sendKeys(proposalNo);
		try {
			waitForVisible(driver,driver.findElement(By.linkText(proposalNo)));
			driver.findElement(By.linkText(proposalNo)).click();
			logStep(proposalNo +" proposal num is clicked " );
			waitForVisible(driver,submit);
			submit.click();
			logStep("Clicked on Submit button");

		}catch(Exception e){
			System.out.println("proposalNo - "+proposalNo+ " not available in the list may be it is cliamed ");
			Assert.fail("proposalNo - "+proposalNo+ " not available in the list may be it is cliamed");
		}
	}

	public void checkresult() throws Exception {
		waitForVisible(driver,success);
		logStep(success.getText()+"---"+message.getText());
		logger.info(success.getText()+"---"+message.getText());
		attachScreen(driver);
		if(success.getText().contains("Success")){
			logStep("Scrutny submitted succssfully  "+message.getText());
			logger.info("Scrutny submitted succssfully  "+message.getText());
			waitForVisible(driver,driver.findElement(By.xpath("//button[@class='confirm']")));
			attachScreen(driver);
			clickOnElement(driver.findElement(By.xpath("//button[@class='confirm']")));
			attachScreen(driver);
		}else {
			System.out.println("Some thing went wrong "+message.getText());
			Assert.fail("Some thing went wrong "+message.getText());
		}
	}
}
