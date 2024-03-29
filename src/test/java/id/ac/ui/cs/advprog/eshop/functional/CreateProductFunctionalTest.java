package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    /**
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run by Spring Framework's test context.
     */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default value to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = String.format("%s:%d/product/list", testBaseUrl, serverPort);
    }

    @Test
    void pageTitleIsCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        // Verify
        assertEquals("Product List", pageTitle);
    }

    @Test
    void mainMessageIsCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h1")).getText();

        // Verify
        assertEquals("Product' List", welcomeMessage);
    }

    @Test
    void createProductIsCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        WebElement redirectToCreatePageButton = driver.findElement(By.linkText("Create Product"));
        redirectToCreatePageButton.click();

        String productName = "Product 1";
        int productQuantity = 10;

        //---------------------FILL CREATE PRODUCT FORM---------------------
        WebElement productNameInput = driver.findElement(By.name("productName"));
        WebElement productQuantityInput = driver.findElement(By.name("productQuantity"));

        productNameInput.clear();
        productQuantityInput.clear();

        productNameInput.sendKeys(productName);
        productQuantityInput.sendKeys(Integer.toString(productQuantity));

        //---------------------Submit CREATE PRODUCT FORM---------------------
        WebElement buttonCreate = driver.findElement(By.tagName("button"));
        buttonCreate.click();

        //It is expected for the page to redirect to /product/list after submitting the form
        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl, currentUrl);

        String pageSource = driver.getPageSource();
        boolean pageContainsNewProductName = pageSource.contains(productName);
        boolean pageContainsNewProductQuantity = pageSource.contains(Integer.toString(productQuantity));
        assertTrue(pageContainsNewProductName);
        assertTrue(pageContainsNewProductQuantity);
    }
}