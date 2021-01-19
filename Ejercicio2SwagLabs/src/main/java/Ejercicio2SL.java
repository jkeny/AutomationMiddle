import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ejercicio2SL {
    public static void main(String[] args) {
        String SwagLabsLoginLogo = "/html/body/div[2]/div[1]/img";
        String userNameTxtId = "user-name";
        String passwordTxtId = "password";
        String loginBtnId = "login-button";
        String carritoComprasLogo = "//*[@id='shopping_cart_container']/a";
        String[] descripcionItemsArray = new String[6];
        String checkoutBtnXpath = "//a[@class='btn_action checkout_button']";
        String firstNameId = "//*[@id='first-name']";
        String lastNameId = "//*[@id='last-name']";
        String zipCodeId = "//*[@id='postal-code']";


        String dummy = "";
        String listStart1 = "//*[@id='root-app']/div/div/section/ol/li[";
        String listEnd = "]/div/div/div[2]/div[2]/div[1]/div/div/div/span[1]/span[2]";
        String productEnd = "/div/div/div[2]/div[1]/a/h2";

        WebDriver driver;
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        //abrimos el browser
        driver.get("https://www.saucedemo.com/");

        // aplicamos un explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SwagLabsLoginLogo)));

        WebElement userNameTxt = driver.findElement(By.id(userNameTxtId));
        WebElement passwordTxt = driver.findElement(By.id(passwordTxtId));
        WebElement loginBtn = driver.findElement(By.id(loginBtnId));

        if (userNameTxt.isDisplayed() && passwordTxt.isDisplayed()) {
            userNameTxt.clear();
            passwordTxt.clear();
            userNameTxt.sendKeys("standard_user");
            passwordTxt.sendKeys("secret_sauce");
            loginBtn.click();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            if (driver.findElement(By.xpath(carritoComprasLogo)).isDisplayed()) {
                System.out.println("Inicio de sesión con exito");

            }

        } else {
            System.out.println("Elemento no se encuentra presente");
        }
        // Obten la lista de elementos btn add to cart y agregarlos al carrito de compras

        List<WebElement> addToCartBtns = driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));
        for (WebElement element : addToCartBtns) {
            element.click();
            try {
                //Solo para ver la secuencia de acciones
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

        }
        // capturar e imprimir las lista de items para listarlo de forma desdendencte y ascendente

        List<WebElement> descripcionItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        int i = 0;
        for (WebElement element : descripcionItems) {
            descripcionItemsArray[i] = element.getText();
            i++;
        }
        // ordenamos los items de forma ascendente y lo imprimimos

        Arrays.sort(descripcionItemsArray);
        System.out.println("** Los items ordenados de forma Ascendente:");
        for (String items : descripcionItemsArray) {
            System.out.println("- " + items);
        }

        // ordenamos los items de forma descendente y lo imprimimos

        Arrays.sort(descripcionItemsArray, Collections.reverseOrder());
        System.out.println("**  Los items ordenados de forma Descendente:");
        for (String items : descripcionItemsArray) {
            System.out.println("- " + items);
        }

        // no dirigimos a carritos de compras para quitar los 3 primeros items
        driver.findElement(By.xpath(carritoComprasLogo)).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        List<WebElement> removeBtnsToCar = driver.findElements(By.xpath("//button[@class='btn_secondary cart_button']"));
        for (int j = 0; j < 3; j++) {

            //System.out.println(removeBtnsToCar.size());
            removeBtnsToCar.get(j).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //ir a checkout
        if (driver.findElement(By.xpath(checkoutBtnXpath)).isEnabled()) {

            driver.findElement(By.xpath(checkoutBtnXpath)).click();

        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Completamos los datos del Formulario

        WebElement firstNameTxt = driver.findElement(By.xpath(firstNameId));
        WebElement lastNameTxt = driver.findElement(By.xpath(lastNameId));
        WebElement zipCodeText = driver.findElement(By.xpath(zipCodeId));

        firstNameTxt.clear();
        lastNameTxt.clear();
        zipCodeText.clear();
        firstNameTxt.sendKeys("Jhon");
        lastNameTxt.sendKeys("Quispe");
        zipCodeText.sendKeys("Lima 34");

        if (driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[2]/input")).isEnabled()) {
            driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[2]/input")).click();
        }
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        // validamos si los subtotales de los precios + el envio en taxi es igual al total
        double total = Double.parseDouble(driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]")).getText().substring(8));
        double taxi = Double.parseDouble(driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]")).getText().substring(6));
        ;
        //System.out.println(String.valueOf(taxi));
        double subtotalprecio = 0;
        List<WebElement> itemPrecios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement element : itemPrecios) {
            //System.out.println(element.getText().substring(1));
            subtotalprecio = subtotalprecio + Double.parseDouble(element.getText().substring(1));
        }
        subtotalprecio = subtotalprecio + taxi;

        // validamos si el total es la suma de los totales

        if (total == subtotalprecio) {

            System.out.println("** La suma de los subtotales es igual a total calculado");
            System.out.println(" - El total es: "+ String.valueOf(total));
            System.out.println(" - La suma de Subtotales es: " + String.valueOf(subtotalprecio));

        } else {
            System.out.println("** Hay diferencia en el total calculado");
            System.out.println(" - El total es: "+ String.valueOf(total));
            System.out.println(" - La suma de Subtotales es: " + String.valueOf(subtotalprecio));
        }

        if (driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]/a[2]")).isEnabled()) {

            driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]/a[2]")).click();


        }else{
            System.out.println("El elemento no se encuentra habilitado");
        }
        // validando que la compra se haya realizado con exito
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText(),"THANK YOU FOR YOUR ORDER");

        driver.close();
    }


}
