package automation.PageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class LoginPage {
	WebDriver driver;
	private By textEmail = By.id("email");
	private By textPass = By.id("password");
	private By buttonLogin = By.xpath("//button[@type='submit']");
	public static By errorAuthentication = By.xpath("//div[@class='alert alert-danger']");
 public LoginPage (WebDriver _driver)
 {
  this.driver = _driver;
 }
 
 public void Login (String email, String pass)
 {
	 // Nhập vào textbox Email
	 WebElement txtEmail = driver.findElement(textEmail);
	 if(txtEmail.isDisplayed())
	 {
	 txtEmail.clear();
	 txtEmail.sendKeys(email);
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 }
	 
	 // Nhập vào textbox Pass
	 WebElement txtPass = driver.findElement(textPass);
	 if(txtPass.isDisplayed())
	 {
		 txtPass.clear();
		 txtPass.sendKeys(pass);
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 }
	 
	 // Nhấp chuột vào button Login
	 //WebElement btnLogin = driver.findElement(buttonLogin);
	 WebElement btnLogin = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(buttonLogin));
	 if(btnLogin.isDisplayed())
	 {
	  btnLogin.click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 }
	
 }
}
