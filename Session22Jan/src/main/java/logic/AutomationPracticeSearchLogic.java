package logic;

import driver.driver;
import page.AutomationPracticeSearchPage;

public class AutomationPracticeSearchLogic {
    driver Driver;
    AutomationPracticeSearchPage searchPage;

    public AutomationPracticeSearchLogic(driver driver) {
        this.Driver = driver;
        searchPage = new AutomationPracticeSearchPage(Driver);


    }

    public void buscarProducto(String descripcionProducto) {
        searchPage.setProductoBuscar(descripcionProducto);
        searchPage.clickBtnBuscar();
        searchPage.mouseOverActions();
        searchPage.clickBtnMore();

    }

    public void seleccionarTallaCantidad(String cantidad) {
        searchPage.clearTxtCantidad();
        searchPage.setTxtCantidad(cantidad);
        searchPage.setCbxSize();
    }

    public void agregarProductoAlCarritoCompras() {
        searchPage.clickBtnAddToCart();
    }

    public void continuarComprando() {
        searchPage.clickBtnContinueShopping();
    }
    public void goToCheckOut_CarritoCompras(){
        searchPage.clickLinkCheckOut();
    }
}
