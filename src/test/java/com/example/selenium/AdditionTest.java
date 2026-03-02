package com.example.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Specify EdgeDriver executable location if not in PATH
        System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");

        // Create EdgeOptions and specify Edge binary path
        EdgeOptions options = new EdgeOptions();
        options.setBinary("C:\\WebDriver\\msedgedriver.exe");

        // Optional: run headless (useful for Jenkins)
        // options.addArguments("--headless=new");
        // options.addArguments("--disable-gpu");
        // options.addArguments("--window-size=1920,1080");

        driver = new EdgeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAdditionWithEdge() {
        driver.get("file:///C:/my-webapp/src/main/webapp/addition.html");

        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));
        WebElement addBtn = driver.findElement(By.id("addBtn"));
        WebElement result = driver.findElement(By.id("result"));

        num1.sendKeys("10");
        num2.sendKeys("20");
        addBtn.click();

        assertEquals("30", result.getText());
    }
}