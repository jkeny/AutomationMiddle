package POM;

import driver.driver;
import pages.TaringaPages;

public class taringaPOM {

    public String price;
    driver Driver = null;
    TaringaPages taringaP = null;

    public taringaPOM(driver Driver) {
        this.Driver = Driver;
        this.taringaP = new TaringaPages(this.Driver);
    }

    public void goToTaringa() throws InterruptedException {
        Driver.goto_url("https://www.taringa.net");
        Driver.implicitwait();
    }

    public void iniciarSesion(String user, String password) {
        taringaP.initSession(user, password);
    }

    public void executeTaringaTestCaseUno() throws InterruptedException {
        goToTaringa();
        Driver.implicitwait();
        iniciarSesion("jkeny_1985@hotmail.com", "Taringa2020");
    }

    public void executeTaringaTestCaseDos() throws InterruptedException {
        goToTaringa();
        Driver.implicitwait();
        iniciarSesion("jquispe.gutierrez@gmail.com", "Taringag2020");
        taringaP.createArticle();

    }
    public void executeTaringaTestCaseTres() throws InterruptedException {
        goToTaringa();
        Driver.implicitwait();
        iniciarSesion("jquispe.gutierrez@gmail.com", "Taringag2020");
        taringaP.comentarArticulo();

    }
    public boolean validarFourButtons(){

       return taringaP.isFourButtonsPresent();

    }

    public String mensajeDeValidacion(){
        return taringaP.registeredArticuloMessage();
    }
}
