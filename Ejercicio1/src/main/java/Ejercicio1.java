import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio1 {
    public static void main(String[] args) {
        WebDriver driver = null;
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        //Paso 1: Ir a la la pagina a automatizar "https://www.amazon.com/"
        driver.manage().window().maximize();
        // Paso 1:
        driver.get("https://www.amazon.com/");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Identificamos los elementos de la pagina

        By txtBusqueda = By.xpath("//input[@id='twotabsearchtextbox']");
        By btnBuscar=By.xpath("//input[@value='Go']");
        By imgZapatillas= By.xpath("//img[@src='https://m.media-amazon.com/images/I/81EBxLKi4CL._AC_UL320_.jpg']");
        By lblDescripcion = By.cssSelector("span[id='productTitle']");
        By lblPrecio = By.xpath("//span[@id='priceblock_ourprice']");
        By lblAhorro =By.xpath("//td[text()='Ahorras:']");

        // Paso 2: ingresamos el texto a Buscar y click en el boton buscar

       driver.findElement(txtBusqueda).sendKeys("zapatillas");
       driver.findElement(txtBusqueda).submit();
       // Paso 3: Seleccionamos el primer resultado e ingresamos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(imgZapatillas).click();

        // Paso 4: imprimir por consola la descripción del producto

        WebElement descripcion = driver.findElement(lblDescripcion);
        System.out.println("La descripcion del Producto es: " + descripcion.getText());

        // Paso 5: imprimir por consola el precio del producto
        WebElement precio = driver.findElement(lblPrecio);
        System.out.println("El precio del Producto es: "+ precio.getText());

        //Paso 6: Validamos si el producto tienen Ahorro

            System.out.println("Ahorro: El producto no considera ahorro");


        // Paso 7: cerramos la pagina

        driver.close();
    }
}
