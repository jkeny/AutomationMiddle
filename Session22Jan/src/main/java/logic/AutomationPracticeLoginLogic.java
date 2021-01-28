package logic;

import driver.driver;
import org.openqa.selenium.WebDriver;
import page.AutomationPracticeHomePage;
import page.AutomationPracticeLoginPage;

public class AutomationPracticeLoginLogic {
    driver Driver = null;
    AutomationPracticeLoginPage loginPage;

    public AutomationPracticeLoginLogic(driver Driver) {
        this.Driver = Driver;
        loginPage = new AutomationPracticeLoginPage(Driver);
    }

    public void login(String user, String pass) {
        loginPage.setEmail(user);
        loginPage.setPassword(pass);
        loginPage.clickBtnLogin();
    }

}
