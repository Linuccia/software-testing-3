package com.testing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.*;

class MainPageTest {

    private final MainPage page = new MainPage();

    private void setUp(String browser) {
        Configuration.browser = browser;
        open("https://fastpic.org/");
    }

    @AfterEach
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
    }

    /**
     * 1. Сценарий загрузки изображения на сервис
     * 1) Пользователь нажимает кнопку "Выбрать файлы"
     * 2) Пользователь выбирает изображение на ПК
     * 3) Пользователь выбирает параметры (опционально)
     * 4) Пользователь нажимает кнопку "Загрузить"
     * 5) Пользователь дожидается, пока изображение всплывет внизу с нужными ссылками
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void uploadImage(String browser) {
        setUp(browser);
        page.chooseFile.uploadFile(new File("test-pic.jpg"));
        page.upload.click();
        WebDriverWait wait = new WebDriverWait(webdriver().object(), Duration.ofMillis(30000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/table[1]/tbody/tr/td[2]/"
                + "table/tbody/tr/td/div/a[2]/div/div[4]")));
        assertTrue(page.imageInfo.isDisplayed());
    }

    /**
     * 2. Сценарий открытия правил сервиса
     * 1) Пользователь нажимает на гиперссылку "Правила"
     * 2) Пользователь дожидается загрузки страницы с правилами
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void openRules(String browser) {
        setUp(browser);
        page.rules.click();
        String expectedURL = "https://fastpic.org/rules";
        String actualURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, actualURL);
    }

    /**
     * 3. Сценарий открытия правил сервиса
     * 1) Пользователь нажимает на гиперссылку "О сервисе"
     * 2) Пользователь дожидается загрузки страницы с информацией о сервисе
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void openAbout(String browser) {
        setUp(browser);
        page.about.click();
        String expectedURL = "https://fastpic.org/about";
        String actualURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, actualURL);
    }

    /**
     * 4. Сценарий открытия правил сервиса
     * 1) Пользователь нажимает на гиперссылку "Donate"
     * 2) Пользователь дожидается загрузки страницы с реквизитами
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void openDonation(String browser) {
        setUp(browser);
        page.donate.click();
        String expectedURL = "https://fastpic.org/donate";
        String actualURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, actualURL);
    }

    /**
     * 5. Сценарий добавления поля для еще одного файла
     * 1) Пользователь нажимает на кнопку "Добавить поле"
     * 2) Пользователь дожидается загрузки еще одной кнопки "Выбрать файлы"
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void addField(String browser) {
        setUp(browser);
        page.addField.click();
        WebDriverWait wait = new WebDriverWait(webdriver().object(), Duration.ofMillis(30000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/table[2]/tbody/tr[3]/td/"
                + "div/form/div/div[2]/input[2]")));
        assertTrue(page.addedField.isDisplayed());
    }

}