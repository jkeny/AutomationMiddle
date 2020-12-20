import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio2 {
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
        By imgZapatillas1= By.xpath("//img[@src='https://m.media-amazon.com/images/I/61KKTKH4zKL._AC_UL320_.jpg']");
        By lblDescripcion = By.cssSelector("span[id='productTitle']");
        By lblPrecio = By.xpath("//span[@id='priceblock_ourprice']");
        By lblAhorro =By.xpath("//td[text()='Ahorras:']");
        By imgZapatillas2= By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]");


        // Paso 2: ingresamos el texto a Buscar y click en el boton buscar

        driver.findElement(txtBusqueda).sendKeys("zapatillas");
        driver.findElement(txtBusqueda).submit();
        // Paso 3: Seleccionamos el primer resultado e ingresamos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // capturamos el precio del segundo
        WebElement lblPrecio2 =driver.findElement(imgZapatillas2);
        System.out.println(lblPrecio2.getText());
        double precio2 = Double.parseDouble(lblPrecio2.getText());

        driver.findElement(imgZapatillas1).click();

        // Paso 4: imprimir por consola la descripción del producto

        WebElement descripcion = driver.findElement(lblDescripcion);
        System.out.println("La descripcion del Producto es: " + descripcion.getText());

        // Paso 5: imprimir por consola el precio de los  productos
        WebElement precio = driver.findElement(lblPrecio);
        System.out.println(precio.getText());
        double precio1 = Double.parseDouble(precio.getText().substring(4,8));
        System.out.println("El precio del  primer Producto es: "+ precio.getText());
        System.out.println("El precio del  segundo Producto es: "+ String.valueOf(precio2));

        //Paso 6: Validamos cual es el mejor para comprar

        if (precio1 == precio2) {
            System.out.println("Puede comprar cualquiera de los dos productos");

        }else if (precio1 == precio2) {

            System.out.println("La mejor opcion de compra es: " + descripcion.getText());

        }else{
            System.out.println("La mejor opcion de compra es: " + descripcion.getText());
        }

         // Paso 7: cerramos la pagina

        //driver.close();
    }
}