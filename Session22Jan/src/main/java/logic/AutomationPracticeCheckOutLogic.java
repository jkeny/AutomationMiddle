package logic;

import driver.driver;
import page.AutomationPracticeCheckOutPage;

public class AutomationPracticeCheckOutLogic {

    driver Driver;
    AutomationPracticeCheckOutPage checkOutPage;

    public AutomationPracticeCheckOutLogic(driver driver) {
        this.Driver = driver;
        checkOutPage = new AutomationPracticeCheckOutPage(Driver);
    }

    public void validaSummary() {
        checkOutPage.clickBtnProceedCheckOutSummary();
    }

    public void validaAdress() {
        checkOutPage.clickBtnProceedCheckOutAddress();
    }

    public void validaShipping() {
        checkOutPage.clickChkTermsOfService();
        checkOutPage.clickBtnProceedCheckOutShipping();
    }
    public void validaPayment(){
        checkOutPage.clickLinkPayByBankWire();
        checkOutPage.clickBtnConfirmMyOrder();
    }
}
