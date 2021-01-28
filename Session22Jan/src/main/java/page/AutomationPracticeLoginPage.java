package page;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeLoginPage {

    public driver Driver;

    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnLogin;

    //public void inicio() throws InterruptedException {
    //  Driver.goto_url("");
    //}

    public AutomationPracticeLoginPage(driver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public void setEmail(String email) {
        Driver.implicitwait();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        Driver.implicitwait();
        txtPassword.sendKeys(password);

    }

    public void clickBtnLogin() {
        Driver.implicitwait();
        btnLogin.click();
    }

}
