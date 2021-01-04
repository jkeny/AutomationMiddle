package pages;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TaringaPages {

    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath = "//button[@title='Iniciar sesión']")
    WebElement iniciarSesionMainBtn;
    @FindBy(xpath = "//input[@placeholder='Ingresa tu email o nombre de usuario' and @name='id']")
    WebElement userNameTxt;
    @FindBy(name = "password")
    WebElement passwordTxt;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement iniciarSesionBtn;
    // elementos Buttons
    @FindBy(xpath = "//span[text()='Home']")
    WebElement homeBtn;
    @FindBy(xpath = "//*[@id='content']/div/header/nav/div/div[2]/ul[1]/li[2]/a/span")
    WebElement miTBtn;
    @FindBy(xpath = "//span[text()='Global']")
    WebElement globalBtn;
    @FindBy(xpath = "//span[text()='Juegos']")
    WebElement juegosBtn;
    // elements create artículo
    @FindBy(xpath = "//button[@class='R5Cdk -dKHw _10Eb8 _30N9S _2PLNR']")
    WebElement crearArticuloBtn;
    @FindBy(xpath = "//input[@placeholder='Título (obligatorio)']")
    WebElement tituloTxt;
    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    WebElement contenidoTxt;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    WebElement capchaCheckBox;
    @FindBy(xpath = "//input[@placeholder='http://']")
    WebElement fuentesTXT;
    @FindBy(xpath = "//button[@class='R5Cdk -dKHw _31pTY _2k116 _35wyv _2PLNR']")
    WebElement publicarBtn;
    @FindBy(xpath = "//a[@title='ArticuloDemo']")
    WebElement textmensage;
    // Elements comentar articulo
    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div[1]/section[1]/div[2]/div/section[1]/div/div[4]")
    WebElement topsMES;
    @FindBy(xpath = "//span[@class='_3dmM2' and text()='1']")
    WebElement articuloTopMes;
    @FindBy(xpath = "//*[@id='content']/div/div[5]/div/main/div[1]/section/div/div[2]/div/div[1]/div/textarea")
    WebElement comentarioArticuloTxt;
    @FindBy(xpath = "//*[@id='content']/div/div[5]/div/main/div[1]/section/div/div[2]/div/div[2]/button")
    WebElement enviarComentarioBtn;
    @FindBys({
            @FindBy(xpath = "//span[@class='_1V8iN']")
    })
    List<WebElement> arraysValora;


    public TaringaPages(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public void initSession(String user, String password) {
        iniciarSesionMainBtn.click();
        userNameTxt.sendKeys(user);
        passwordTxt.sendKeys(password);
        iniciarSesionBtn.click();
    }

    public void createArticle() {

        crearArticuloBtn.click();
        Driver.implicitwait();
        tituloTxt.sendKeys("Articulo Demo");
        contenidoTxt.sendKeys("Alerta Médica de Vida y Salud\n" +
                "El contenido del sitio VidaySalud.com es sólo para fines informativos y educativos. Esto incluye su texto, sus gráficos, sus imágenes, cualquier información obtenida por VidaySalud a través de licencias, y otros materiales contenidos en el sitio. El contenido no es un sustituto de consejos médicos profesionales, de diagnósticos o de tratamientos. Siempre consulte a su médico con cualquier pregunta que pueda tener sobre una condición médica. Nunca desatienda los consejos de su médico profesional ni retrase su tratamiento recomendado debido a algo que usted haya leído en VidaySalud.com.");
        capchaCheckBox.click();
        fuentesTXT.sendKeys("http://comunicado.perueduca.pe/");
        publicarBtn.click();
    }

    public void comentarArticulo() {

        topsMES.click();
        articuloTopMes.click();
        comentarioArticuloTxt.sendKeys("Me gusta mucho este articulo... por eso ha sido elegido como el top del mes");
        enviarComentarioBtn.click();
        Driver.implicitwait();
        arraysValora.get(1).click();


    }


    public boolean isFourButtonsPresent() {

        Boolean btn1, btn2, btn3, btn4;
        btn1 = Driver.missingElement(homeBtn);
        btn2 = Driver.missingElement(miTBtn);
        btn3 = Driver.missingElement(globalBtn);
        btn4 = Driver.missingElement(juegosBtn);

        if (btn1 == true && btn2 == true && btn3 == true && btn4 == true) {

            return true;


        } else {
            return false;
        }
    }

    public String registeredArticuloMessage() {
        return textmensage.getText();
    }

}



