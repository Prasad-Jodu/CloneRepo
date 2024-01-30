package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	AndroidDriver driver;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement allowBtn;
	
	@FindBy(id = "com.fsn.nykaa:id/mobileNumber")
	private WebElement phoneNumEdt;
	
	@FindBy(id = "com.fsn.nykaa:id/btnGetOtp")
	private WebElement getOtpBtn;
	
//	@FindBy(id = "com.fsn.nykaa:id/cross")
//	private WebElement cancel;
//	
	public LoginPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getAllowBtn() {
		return allowBtn;
	}

	public WebElement getPhoneNumEdt() {
		return phoneNumEdt;
	}

	public WebElement getGetOtpBtn() {
		return getOtpBtn;
	}
	
	public void login()
	{
		allowBtn.click();
		phoneNumEdt.sendKeys("7780180333");
		getOtpBtn.click();
	}
}
