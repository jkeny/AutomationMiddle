package page;

import driver.driver;
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeCheckOutPage {
    driver Driver;
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement btnProceedCheckOutSummary;
    @FindBy(name = "processAddress")
    WebElement btnProceedCheckOutAddress;
    @FindBy(name = "processCarrier")
    WebElement btnProceedCheckOutShipping;
    @FindBy(id = "cgv")
    WebElement chkTermOfService;
    @FindBy(css="a.bankwire")
    WebElement linkPayByBankWire;
    @FindBy(xpath = "//span[text()='I confirm my order']")
    WebElement btnConfirmMyOrder;

    public AutomationPracticeCheckOutPage(driver driver) {
        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public void clickBtnProceedCheckOutSummary() {
        btnProceedCheckOutSummary.click();
    }

    public void clickBtnProceedCheckOutAddress() {
        Driver.implicitwait();
        btnProceedCheckOutAddress.click();
    }

    public void clickBtnProceedCheckOutShipping() {
        Driver.implicitwait();
        btnProceedCheckOutShipping.click();
    }

    public void clickChkTermsOfService() {
        Driver.implicitwait();
        chkTermOfService.click();
    }
    public void clickLinkPayByBankWire(){

        Driver.implicitwait();
        linkPayByBankWire.click();
    }

    public void clickBtnConfirmMyOrder(){

        Driver.implicitwait();
        btnConfirmMyOrder.click();
    }
}
