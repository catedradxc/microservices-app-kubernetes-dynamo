package com.kubernetes.selenium.test.kubernetestest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.kubernetes.selenium.test.kubernetestest.pageobjects.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KubernetesSeleniumTestApplication {

    static String Geckodriver = "C:/Users/juann/Desktop/serverless/apps microservicios serverless/microservice-kubernetes-persistence-demo/kubernetes docd selenium tests/driver/geckodriver.exe";
    static String PathFirefox = "C:\\Program Files\\Firefox Developer Edition\\firefox.exe";
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://ec2-18-196-69-81.eu-central-1.compute.amazonaws.com:30072/";

    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        System.setProperty("webdriver.chrome.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }

    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }

    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {

    }

    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

    // --------------------------------

    //PR01. Shows the list of items
    @Test
    @Order(1)
    public void PR01() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        result = PO_View.checkElementBy(driver, "id", "catalog");
        result.get(0).click();

        checkText = "Add Item";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR02. Create and delete a new item
    @Test
    @Order(2)
    public void PR02() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        result = PO_View.checkElementBy(driver, "id", "catalog");
        result.get(0).click();

        result = PO_View.checkElementBy(driver, "id", "create-item");
        result.get(0).click();
        PO_CreateItemView.fillForm(driver,"aa", "test", "10.0");
        PO_NavView.clickOption(driver, "list", "text", "Add Item");

        result = PO_View.checkElementBy(driver, "@value", "delete");
        result.get(result.size()-1).click();

        checkText = "Action was successful!";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //--------------------------

    //PR02. List customers
    @Test
    @Order(3)
    public void PR03() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        PO_NavView.clickOption(driver, "customer", "text", "Add Customer");

        checkText = "Add Customer";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR02. Create and delete a new customer
    @Test
    @Order(4)
    public void PR04() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        PO_NavView.clickOption(driver, "customer", "text", "Add Customer");

        result = PO_View.checkElementBy(driver, "id", "create");
        result.get(0).click();
        PO_CreateCustomerView.fillForm(driver, "aa", "test", "test",
                "test@email.com", "test", "test");
        PO_NavView.clickOption(driver, "list", "text", "Add Customer");

        result = PO_View.checkElementBy(driver, "@value", "delete");
        result.get(result.size()-1).click();

        checkText = "Action was successful!";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //-------------------------------

    //PR02. List orders
    @Test
    @Order(5)
    public void PR05() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        PO_NavView.clickOption(driver, "order", "text", "Add Order");


        checkText = "Add Order";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR02. Create and delete a new order
    @Test
    @Order(6)
    public void PR06() {
        String checkText = "Customer";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        PO_NavView.clickOption(driver, "order", "text", "Add Order");

        //result = PO_View.checkElementBy(driver, "id", "create-order");
        result = PO_View.checkElementBy(driver, "@href", "form.html");
        result.get(0).click();
        WebElement id = driver.findElement(By.name("id"));
        id.click();
        id.clear();
        id.sendKeys("aa");
        result = PO_View.checkElementBy(driver, "id", "newline");
        result.get(0).click();
        result = PO_View.checkElementBy(driver, "id", "crear");
        result.get(0).click();
        PO_NavView.clickOption(driver, "list", "text", "Add Order");

        result = PO_View.checkElementBy(driver, "@value", "delete");
        result.get(result.size()-1).click();

        checkText = "Action was successful!";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }
}
