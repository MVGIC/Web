package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

//    @Test
//    void shouldTestV1old() {
//        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__top"));
//        elements.get(0).sendKeys("Иван Иванов");
//        driver.findElement(By.className("input__inner"));
//        elements.get(1).sendKeys("+78005553535");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.className("button")).click();
//        String text = driver.findElement(By.className("order-success")).getText();
//        assertEquals("Ваша заявка успешно отправлена!", text.trim());
//    }

    @Test
    void shouldTestV1() throws InterruptedException {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Иван Иванов");
        elements.get(1).sendKeys("+78005553535");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",text.trim());
        Thread.sleep(50000);
    }

//    @Test
//    void shouldTestV2() {
//        driver.get("http://localhost:9999");
//        WebElement form = driver.findElement(By.cssSelector("[data-test-id=callback-form]"));
//        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
//        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
//        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
//        form.findElement(By.cssSelector("[data-test-id=submit]")).click();
//        String text = driver.findElement(By.className("alert-success")).getText();
//        assertEquals("Ваша заявка успешно отправлена!", text.trim());
//    }
}

