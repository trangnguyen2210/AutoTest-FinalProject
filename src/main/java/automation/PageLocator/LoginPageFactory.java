package automation.PageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    WebElement txtEmail;

    @FindBy(id="password") WebElement txtPass;

    @FindBy(xpath = "//button[@type='submit' and text()='Sign in']") WebElement btnLogin;

    public void LoginFunction(String email, String pass) throws InterruptedException {
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPass.clear();
        txtPass.sendKeys(pass);
        Thread.sleep(3000);

        btnLogin.click();
    }
}
