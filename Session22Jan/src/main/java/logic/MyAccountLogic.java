package logic;

import driver.driver;
import page.MyAccountPage;

import java.util.List;

public class MyAccountLogic {
    driver Driver;
    MyAccountPage accountPage;


    public MyAccountLogic(driver driver) {
        this.Driver = driver;
        accountPage = new MyAccountPage(Driver);
    }

    public void ingresarAlHistorial() {
        accountPage.clickLinkCustomerAccount();
        accountPage.clickbtnOrderHistoryDetails();
    }
}
