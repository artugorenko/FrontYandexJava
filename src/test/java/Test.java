import InitialDrivers.InitialDriver;
import Page.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {




    @ParameterizedTest
    @DisplayName("Логин на яндекс почту")
    @ValueSource(strings = {"Chrome"})
    void SignInYandex(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        MainYandex.pageMainYandex();
        ManagementMethod.setWindowHadles(MainYandex.SignInToMail, 1);
        ManagementMethod.SetTextWebElement(Auth.login, "AutotestUser");
        ManagementMethod.clickWebElement(Auth.entranceLogin);
        ManagementMethod.SetTextWebElement(Auth.password, "AutotestUser123");
        ManagementMethod.clickWebElement(Auth.entrancePassword);
        assertEquals("AutotestUser",ManagementMethod.GetTextWebElement(Message.user));

    }

    @ParameterizedTest
    @DisplayName("Яндекс почта - невалидный пароль")
    @ValueSource(strings = {"Chrome"})
    void SignInYandexBadPassword(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        MainYandex.pageMainYandex();
        ManagementMethod.setWindowHadles(MainYandex.SignInToMail, 1);
        ManagementMethod.SetTextWebElement(Auth.login, "AutotestUser");
        ManagementMethod.clickWebElement(Auth.entranceLogin);
        ManagementMethod.SetTextWebElement(Auth.password, "NoAutotestUser123");
        ManagementMethod.clickWebElement(Auth.entrancePassword);
        assertEquals("Неверный пароль",ManagementMethod.GetTextWebElement(Auth.textErrorPassword));
    }

    @ParameterizedTest
    @DisplayName("Яндекс почта - логаут")
    @ValueSource(strings = {"Chrome"})
    void SignInYandexAndOut(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        SignInYandex( name);
        ManagementMethod.clickWebElement(Message.user);
        ManagementMethod.clickWebElement(Message.OutServiceYandex);
        assertEquals("Войти в почту",ManagementMethod.GetTextWebElement(MainYandex.SignInToMail));
    }

    @ParameterizedTest
    @DisplayName("Яндекс почта - невалидный логин")
    @ValueSource(strings = {"Chrome"})
    void SignInYandexBadLogin(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        MainYandex.pageMainYandex();
        ManagementMethod.setWindowHadles( MainYandex.SignInToMail, 1);
        ManagementMethod.SetTextWebElement(Auth.login,  "NoAutotestUser");
        ManagementMethod.clickWebElement(Auth.entranceLogin);
        assertEquals("Такого аккаунта нет",ManagementMethod.GetTextWebElement(Auth.textErrorLogin));
    }

    @ParameterizedTest
    @DisplayName("Яндекс - навигация")
    @ValueSource(strings = {"Chrome"})
    void SignInYandexNavigate(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        MainYandex.pageMainYandex();
        ManagementMethod.setWindowHadles( MainYandex.Videos, 1);
        ManagementMethod.switchToAndAssert(0,"https://yandex.by/portal/video");
        ManagementMethod.setWindowHadles( MainYandex.Images, 2);
        ManagementMethod.switchToAndAssert(0,"https://yandex.by/images/");
        ManagementMethod.setWindowHadles( MainYandex.News, 3);
        ManagementMethod.switchToAndAssert(0,"https://yandex.by/news/");
        ManagementMethod.setWindowHadles( MainYandex.Maps, 4);
        ManagementMethod.switchToAndAssert(0,"https://yandex.by/maps/");
        ManagementMethod.setWindowHadles( MainYandex.Markets, 5);
        ManagementMethod.switchToAndAssert(0,"https://market.yandex.by/");
        ManagementMethod.setWindowHadles( MainYandex.Interpreters, 6);
        ManagementMethod.switchToAndAssert(0,"https://translate.yandex.by/");
        ManagementMethod.setWindowHadles( MainYandex.Musics, 7);
        ManagementMethod.switchToAndAssert(0,"https://music.yandex.by/");
    }
    @ParameterizedTest
    @DisplayName("Яндекс - переключение языка на английский")
    @ValueSource(strings = {"Chrome"})
    void SignInYandexLanguage(String name) throws InterruptedException, IOException {
        InitialDriver.driver = InitialDriver.getDriver(name);
        MainYandex.pageMainYandex();
        ManagementMethod.clickWebElement(MainYandex.Language);
        ManagementMethod.clickWebElement(MainYandex.AddLanguage);
        ManagementMethod.clickWebElement(YandexSettings.SelectLanguage);
        //JavascriptExecutor executor = (JavascriptExecutor)InitialDriver.driver;
        //executor.executeScript("arguments[0].click();", YandexSettings.EnLanguage);
        //InitialDriver.driver.findElement(YandexSettings.EnLanguage).select;
        //Select dropdown = new Select(InitialDriver.driver.findElement(YandexSettings.EnLanguage));
        //dropdown.selectByIndex(1);
       //ManagementMethod.clickWebElement(By.xpath("select option[value=\"en\"]"));//
        ManagementMethod.clickWebElement(YandexSettings.EnLanguage);
        ManagementMethod.clickWebElement(YandexSettings.ButtonSave);//
        ManagementMethod.clickWebElement(MainYandex.SignInToMail);
        assertEquals("Log in to continue",ManagementMethod.GetTextWebElement(Auth.LogInToContinue));
    }
    @AfterEach
    public void createAndStopService() {
        Iterator<WebDriver> iter = InitialDriver.drivers.values().iterator();
        while (iter.hasNext()) {
            iter.next().quit();
        }
        InitialDriver.drivers.clear();
        ManagementMethod.states.clear();
        ManagementMethod.environment =0;

    }

}
