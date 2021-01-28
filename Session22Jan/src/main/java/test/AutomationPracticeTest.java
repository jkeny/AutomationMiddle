package test;

import driver.driver;
import logic.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.MyAccountPage;

public class AutomationPracticeTest {
    driver Driver = null;
    AutomationPracticeLoginLogic loginLogic;
    AutomationPracticeHomeLogic homeLogic;
    AutomationPracticeSearchLogic searchLogic;
    AutomationPracticeCheckOutLogic checkOutLogic;
    MyAccountLogic myAccountLogic;
    HistoryLogic historyLogic;

    @BeforeClass
    public void before() {
        Driver = new driver();
        homeLogic = new AutomationPracticeHomeLogic(Driver);
        loginLogic = new AutomationPracticeLoginLogic(Driver);
        searchLogic = new AutomationPracticeSearchLogic(Driver);
        checkOutLogic = new AutomationPracticeCheckOutLogic(Driver);
        myAccountLogic = new MyAccountLogic(Driver);
        historyLogic = new HistoryLogic(Driver);

    }

    @Test(priority = 1)
    public void shoppingWithBankWire() throws InterruptedException {
        Driver.goto_url("http://automationpractice.com/index.php");
        homeLogic.clickbtnSignIn_HomePage();
        loginLogic.login("jquispe@automationpractice.com", "Practice2021");
        searchLogic.buscarProducto("Faded Short Sleeve T-shirts");
        searchLogic.seleccionarTallaCantidad("3");
        searchLogic.agregarProductoAlCarritoCompras();
        searchLogic.continuarComprando();
        searchLogic.goToCheckOut_CarritoCompras();
        checkOutLogic.validaSummary();
        checkOutLogic.validaAdress();
        checkOutLogic.validaShipping();
        checkOutLogic.validaPayment();
        myAccountLogic.ingresarAlHistorial();
        Driver.implicitwait();
        System.out.println(historyLogic.validarStatusOrder());
        Assert.assertEquals(historyLogic.validarStatusOrder(),"On backorder");

    }

    @Test(priority = 2)
    public void shoppingWithBankWire_Reorder() throws InterruptedException {
        Driver.goto_url("http://automationpractice.com/index.php");
        homeLogic.clickbtnSignIn_HomePage();
        loginLogic.login("jquispe@automationpractice.com", "Practice2021");
        myAccountLogic.ingresarAlHistorial();
        historyLogic.iniciarReorderProducto();
        checkOutLogic.validaSummary();
        checkOutLogic.validaAdress();
        checkOutLogic.validaShipping();
        checkOutLogic.validaPayment();
        myAccountLogic.ingresarAlHistorial();
        Driver.implicitwait();
        System.out.println(historyLogic.validarStatusOrder());
        Assert.assertEquals(historyLogic.validarStatusOrder(),"On backorder");

    }

    @AfterClass
    public void teardDown() {

        //Driver.teardown();

    }

}
