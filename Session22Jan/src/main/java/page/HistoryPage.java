package page;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HistoryPage {
    driver Driver;
    @FindBy(css = "tr.first_item >td>span[class='label dark']")
    WebElement textStatusOrder;
    @FindBys(
            @FindBy(xpath = "//a[@class='link-button' and @title='Reorder']")
    )
    List<WebElement> listBtnreorder;

    public HistoryPage(driver driver) {
        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public String getTextStatusOrder() {
        return textStatusOrder.getText();

    }
    public List<WebElement> getListBtnReorder(){
        return listBtnreorder;
    }
}
