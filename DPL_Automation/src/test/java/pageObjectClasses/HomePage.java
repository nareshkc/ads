package pageObjectClasses;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.ReusableFunctions;

public class HomePage extends ReusableFunctions {

	WebDriver driver;
	public HomePage(WebDriver driver) 
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
	//inBox option
	@FindBy(linkText="Inbox")
	WebElement inBox;

	@FindBy(xpath="//*[@id=\"MenuBarHorizontal1\"]/li[2]/a")
	@CacheLookup
	WebElement NBS;
	
	@FindBy(xpath="//*[@id=\"MenuBarHorizontal1\"]/li[2]/a")
	@CacheLookup
	WebElement enquiry;

	//


	public void clickOnOption(String optionName) throws Exception {
		waitForVisible(driver,inBox);
		inBox.click();
		attachScreen(driver);
		logStep("Clicked on inbox button for selecting : "+optionName);
	}

	public void HoverOnMenu(String eleName) throws Exception {
		Thread.sleep(1000);
		if(eleName.equalsIgnoreCase("NBS")) {
			ReusableFunctions.mouseHover(driver, NBS);
		}else if(eleName.equalsIgnoreCase("NBS")){
			Thread.sleep(1000);
			ReusableFunctions.mouseHover(driver, enquiry);
		}
		logStep("Mouser hovered on "+eleName);
	}

	public void selectOptionfromMenu(String option) throws Exception
	{
		//WebDriverWait wait=new WebDriverWait(driver, 40);

		WebElement nbsOption = driver.findElement(By.xpath("//ul[@class='MenuBarSubmenuVisible']/li/a[text()='"+option+"']"));
		nbsOption.click();
		logStep(option +"  is selected " );
	}


}
