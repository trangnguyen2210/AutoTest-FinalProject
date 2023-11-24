package automation.testsuite;

import automation.PageLocator.LoginPageFactory;
import automation.common.CommonBase;
import automation.constant.CT_Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeMethod
    public void openSystemUnderTest() {
        driver = initChromeDriver(CT_Account.webURL);
    }

    @Test(priority = 1)
    public void LoginSuccessfully() throws InterruptedException {
        LoginPageFactory login = new LoginPageFactory(driver);
        login.LoginFunction("admin@demo.com", "riseDemo");
        assertTrue(driver.findElement(By.xpath("//ul[@id='sidebar-menu']/descendant::span[text()='Dashboard']")).isDisplayed());
    }

    @AfterMethod
    public void closeChrome() {
        quitDriver(driver);
    }
}
