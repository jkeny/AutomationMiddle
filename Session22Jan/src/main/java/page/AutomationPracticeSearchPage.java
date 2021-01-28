package page;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeSearchPage {
    driver Driver;
    @FindBy(id = "search_query_top")
    WebElement txtBuscar;
    @FindBy(name = "submit_search")
    WebElement btnBuscar;
    @FindBy(xpath = "//span[text()='More']")
    WebElement btnMore;
    @FindBy(id = "quantity_wanted")
    WebElement txtCantidad;
    @FindBy(css = "select>option[title='M']")
    WebElement cbxSize;
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement btnAddToCart;
    @FindBy(css = "span[class='continue btn btn-default button exclusive-medium']")
    WebElement btnContinueShopping;
    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order' and @title='View my shopping cart']")
    WebElement linkChekOut;
    @FindBy(css = "div.product-container")
    WebElement popUpProductContainer;

    public AutomationPracticeSearchPage(driver driver) {
        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);

    }

    public void setProductoBuscar(String descripcionProducto) {
        Driver.implicitwait();
        txtBuscar.sendKeys(descripcionProducto);
    }

    public void clickBtnBuscar() {
        Driver.implicitwait();
        btnBuscar.click();
    }

    public void clickBtnMore() {
        btnMore.click();
    }

    public void setTxtCantidad(String cantidad) {
        txtCantidad.sendKeys(cantidad);
    }

    public void clearTxtCantidad() {
        txtCantidad.clear();
    }

    public void setCbxSize() {
        cbxSize.click();
    }

    public void clickBtnAddToCart() {
        Driver.implicitwait();
        btnAddToCart.click();
    }

    public void clickBtnContinueShopping() {
        Driver.implicitwait();
        btnContinueShopping.click();
    }

       public void clickLinkCheckOut() {
        Driver.implicitwait();
        linkChekOut.click();
    }

    public void mouseOverActions(){
        Driver.implicitwait();
        Driver.mouseOverAction(popUpProductContainer);
    }

    // public void setBtnMore(WebElement btnMore) {
    //   this.btnMore = btnMore;
    //}
}
