package logic;

import driver.driver;
import org.openqa.selenium.WebElement;
import page.HistoryPage;

import java.util.List;

public class HistoryLogic {
    driver Driver;
    HistoryPage historyPage;
    List<WebElement> btnsReorder;


    public HistoryLogic(driver driver) {
        this.Driver = driver;
        historyPage = new HistoryPage(Driver);
    }

    public String validarStatusOrder() {
        return historyPage.getTextStatusOrder();
    }

    public void iniciarReorderProducto() {
        Driver.implicitwait();
        btnsReorder = historyPage.getListBtnReorder();
        btnsReorder.get(0).click();
    }
}
