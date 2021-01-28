package logic;

import driver.driver;
import page.AutomationPracticeLoginPage;

public class AutomationPracticeHomeLogic {
    driver Driver;
    page.AutomationPracticeHomePage homePage;


    public AutomationPracticeHomeLogic(driver driver) {
        this.Driver = driver;
        homePage = new page.AutomationPracticeHomePage(Driver);
    }

    public void clickbtnSignIn_HomePage() {

        homePage.clickInSignIn();

    }
}
