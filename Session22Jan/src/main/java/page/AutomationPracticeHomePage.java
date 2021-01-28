package page;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeHomePage {

    public driver Driver = null;
    @FindBy(css = "a.login")
    WebElement linkSignIn;

    public AutomationPracticeHomePage(driver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);

    }

    public void clickInSignIn() {
        Driver.implicitwait();
        Driver.customWait_clickable(linkSignIn);
        linkSignIn.click();
    }
}
