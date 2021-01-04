package test;

import POM.taringaPOM;
import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class TaringaTest {

    driver Driver = null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Iniciando Test 1 para Taringa");
    }

    @Test(priority = 0)
    public void testCaseUno() throws InterruptedException {
        taringaPOM tapom = new taringaPOM(Driver);
        tapom.executeTaringaTestCaseUno();
        assertTrue(tapom.validarFourButtons());
    }

    @Test(priority = 1)
    public void testCaseDos() throws InterruptedException {
        taringaPOM tapom = new taringaPOM(Driver);
        tapom.executeTaringaTestCaseDos();
        Assert.assertEquals("ArticuloDemo", tapom.mensajeDeValidacion());
    }

    @Test(priority = 2)
    public void testCaseTres() throws InterruptedException {
        taringaPOM tapom = new taringaPOM(Driver);
        tapom.executeTaringaTestCaseTres();
        //Assert.assertEquals("ArticuloDemo", tapom.mensajeDeValidacion());
    }

    @AfterClass
    public void teardown() {
       Driver.teardown();
    }
}
