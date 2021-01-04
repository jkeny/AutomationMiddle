package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class driver {

    public Properties p=null;
    public WebDriver driver;
    public FileReader reader=null;
    public WebDriver returnDriver()
    {
        return driver;
    }

    public static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public driver()
    {
        setupClass();
        setupTest();
/*
        try{
            String prop_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"env/variables.properties";
            FileReader readeri =new FileReader(prop_path);
            reader = readeri;
            p = new Properties();
            p.load(reader);
        }
        catch(Exception e)
        {
            System.out.println("el archivo de variables del sitio no se cargo de manera adecuada");
            e.printStackTrace();
        }
        PageFactory.initElements(this.driver, this);*/
    }
    public void explicitWait(WebElement element)
    {
        String elementoClass = element.getAttribute("class");
        System.out.println(elementoClass);
        String elementoPath = "//div[@class='"+ elementoClass + "']";
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementoPath)));

    }
    public void customWait_xpath (By minedupath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(minedupath));
    }
    public void customWait_clickable (By minedupath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(elementToBeClickable(minedupath));
    }



    public void send_keys(By mineduElement, String mineduInput)
    { driver.findElement(mineduElement).sendKeys(mineduInput);

    }
    public void goto_url(String url_address) throws InterruptedException {
        driver.get(url_address);
        Thread.sleep(6000);
    }



    public void click (By mineduPath)
    {
        driver.findElement(mineduPath).click();
    }
    public void switchWindows()
    {
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void implicitwait() {

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
    }




    public void submit(By form) {
        driver.findElement(form).submit();
    }

    public Properties return_Prop() {

        return p;
    }


////////////////////////////////////minedu///////////////////////////////////////

    public boolean missingImageElement(WebElement ImageElement)
    {   Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageElement);
        return ImagePresent;
    }

    public boolean missingElement(WebElement Element)
    {   Boolean response = null;
        response = Element.isDisplayed() && Element.isEnabled();
        return response;
    }

}
