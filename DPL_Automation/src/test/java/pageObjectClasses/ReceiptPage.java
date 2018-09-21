package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import junit.framework.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class ReceiptPage extends ReusableFunctions{
	WebDriver driver;

	public ReceiptPage(WebDriver driver) {
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
	@FindBy(xpath="//*[@id='searchNBSField']")
	WebElement srchBox;

	public void searchwithproposalNo(String ProposalNo) throws Exception {
		//NA212
		Thread.sleep(4000);
		waitForVisible(driver,srchBox);
		ReusableFunctions.enterText_old(srchBox, ProposalNo);
		try {
			waitForVisible(driver,driver.findElement(By.linkText(ProposalNo)));
			driver.findElement(By.linkText(ProposalNo)).click();
			logStep("Clicked on Proposal num" + ProposalNo );
		}catch(Exception e){
			System.out.println("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed ");
			Assert.fail("ProposalNo - "+ProposalNo+ " not available in the list may be it is cliamed");
		}
	}


}
