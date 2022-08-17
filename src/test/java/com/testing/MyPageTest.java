package com.testing;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyPageTest {

    private final MainPage mainPage = new MainPage();
    private final MyPage myPage = new MyPage();
    private final String MY_URL = "https://fastpic.org/my.php";


    private void setUp(String browser) {
        Configuration.browser = browser;
        Configuration.timeout = 30000;
        open("https://fastpic.org/");
        mainPage.chooseFile.uploadFile(new File("test-pic.jpg"));
        mainPage.upload.click();
    }

    @AfterEach
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
    }

    /**
     * 1. Сценарий просмотра загруженного изображения
     * 1) Пользователь загружает изображение на главной странице
     * 2) Пользователь переходит на страницу с его загрузками и видит загруженное изображение
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void seeMyImage(String browser) {
        setUp(browser);
        open(MY_URL);
        assertTrue(myPage.myImage.isDisplayed());
    }

    /**
     * 2. Сценарий удаления загруженного изображения
     * 1) Пользователь нажимает на чекбокс "выбрать" на нужном изображении
     * 2) Пользователь нажимает на кнопку "удалить выбранное"
     * 3) Пользователь дожидается, пока изображение исчезнет со страницы
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void deleteMyImage(String browser) {
        setUp(browser);
        open(MY_URL);
        myPage.chooseImage.click();
        myPage.deleteChosen.click();
        assertFalse(myPage.myImage.isDisplayed());
    }

    /**
     * 3. Сценарий открытия загруженного изображения
     * 1) Пользователь нажимает на нужное изображение
     * 2) Пользователь дожидается загрузки страницы с изображением и ссылками
     *
     * @param browser название браузера
     */
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void selectMyImage(String browser) {
        setUp(browser);
        open(MY_URL);
        myPage.myImage.click();
        switchTo().window(1);
        assertTrue(myPage.imageInNewTab.exists());
    }

}