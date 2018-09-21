package pageObjectClasses;

import java.util.List;

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

public class Cops_Inward extends ReusableFunctions {
	int row_num, col_num;
	WebDriver driver;
	public Cops_Inward(WebDriver driver) 
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
	@FindBy(xpath="//div[@class='iapp-3field-enclosure']//div[2]/select")
	WebElement applicationNameDDloc;	

	@FindBy(xpath="/html/body/div[4]/div/form/div[1]/div[2]/div[2]/div[2]/div[2]/input")
	WebElement searchAwbNoLoc;

	@FindBy(xpath="/html/body/div[4]/div/form/div[2]/button[1]")
	WebElement submitBtn;

	@FindBy(xpath = "/html/body/div[8]/p")
	WebElement message;
	@FindBy(xpath = "/html/body/div[8]/h2")
	WebElement success;


	public void selectNewBusinesss() throws Exception {

		waitForVisible(driver,applicationNameDDloc);
		selectBydropDown(applicationNameDDloc,"New Business");

	}


	public void checkPropNo(String PropNo) throws Exception
	{
		//WebElement tdElement=null;
		List<WebElement> tr_collection=driver.findElements(By.xpath("//table[@class='iapp-table']/tbody/tr"));
		logger.info("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		logStep("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		logger.info("Total number of proposals are listed : "+tr_collection.size());
		logStep("Total number of proposals are listed : "+tr_collection.size());
		for(int rowno=1;rowno<=tr_collection.size();rowno++) {
			String pNumber = driver.findElement(By.xpath("//table[@class='iapp-table']/tbody/tr["+rowno+"]/td[2]")).getText();
			

			if(pNumber.equalsIgnoreCase(PropNo)) {
				driver.findElement(By.xpath("//table[@class='iapp-table']/tbody/tr["+rowno+"]/td[1]/input")).click();
				logStep("Selected proposal numbers in the list : " + pNumber);
				logger.info("Selected proposal numbers in the list : " + pNumber);
				break;
			}
		}
	}

	public void clickSubmit() throws Exception {
		waitForVisible(driver,submitBtn);
		clickOnElement(submitBtn);
		attachScreen(driver);
		logStep("Clicked on Submit button");

	}

	public void checkresult() throws Exception {
		ReusableFunctions.waitForVisible(driver, success);
		logger.info(success.getText()+"--"+message.getText());
		logStep(success.getText()+"--"+message.getText());
		attachScreen(driver);
		if(success.getText().contains("Success")){
			logger.info(" Dispatch mode completed  "+message.getText());
			waitForVisible(driver,driver.findElement(By.xpath("//button[@class='confirm']")));
			clickOnElement(driver.findElement(By.xpath("//button[@class='confirm']")));
			attachScreen(driver);

		}else {
			System.out.println("Some thing went wrong "+message.getText());
			Assert.fail("Some thing went wrong "+message.getText());
		}
	}




}