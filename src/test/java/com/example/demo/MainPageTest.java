package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    static WebDriver webDriver;
    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("http://formy-project.herokuapp.com/form");
    }
    @Test
    public void firstNameTest(){
       WebElement firstName = webDriver.findElement(By.xpath("//*[@id=\"first-name\"]"));
       firstName.sendKeys("Youssef");
       assertEquals("Youssef", firstName.getAttribute("value"));
    }
    @Test
    public void lastNameTest(){
        WebElement lastName = webDriver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastName.sendKeys("George");
        assertEquals("George", lastName.getAttribute("value"));
    }

    @Test
    public void educationTest(){
        WebElement highSchool = webDriver.findElement(By.id("radio-button-1"));
        highSchool.click();
        assertEquals(true,highSchool.isSelected());
    }

    @Test
    public void submitTest(){
        WebElement btn = webDriver.findElement(By.className("btn"));
        btn.click();
    }
    @AfterAll
    public static void afterAll(){
        webDriver.quit();
    }
}
