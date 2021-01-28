package page;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    driver Driver;
    @FindBy(xpath = "//a[@class='account']")
    WebElement linkCustomerAccount;
    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement btnOrderHistoryDetails;


    public MyAccountPage(driver driver) {
        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(),this);
    }
    public void clickLinkCustomerAccount(){
        linkCustomerAccount.click();
    }
    public void clickbtnOrderHistoryDetails(){
        btnOrderHistoryDetails.click();
    }
}
