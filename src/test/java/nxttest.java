import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class nxttest {
    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open the NxtTrendz login page
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        // Find and fill in the form fields
        WebElement usernameEl =  driver.findElement(By.xpath("//input[@id='username']"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl = driver.findElement(By.xpath("//input[@id='password']"));
        passwordEl.sendKeys("rahul@2021");

        WebElement buttonEl = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonEl.submit();

        // Define the expected URL of the home page
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        // Wait for the expected URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL after login
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)) {

            System.out.println("Navigation to home page was successful!");
        }

        // Find and click on the "Shop Now" button
        WebElement shopNowButtonEl = driver.findElement(By.xpath("//button[@class='shop-now-button']"));
        shopNowButtonEl.click();

        // Define the expected URL of the products page
        String productsPageUrl = "https://rahulnxttrendz.ccbp.tech/products";

        // Get the current URL after login
        String currentUrl2 = driver.getCurrentUrl();
        if(currentUrl2.equals(productsPageUrl)){
            System.out.println("Navigation to products page was successful!");
        }

        //Wait until elements are displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='products-list']")));

        // Verify the display of products on the products page
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='product-item']"));

        if (products.size() > 0) {
            System.out.println("Products are displayed successfully on the products page: "+ products.size());
        } else {
            System.out.println("No products found on the products page.");
        }
    }
}