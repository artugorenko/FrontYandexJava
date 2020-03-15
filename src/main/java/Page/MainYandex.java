package Page;
import InitialDrivers.InitialDriver;
import org.openqa.selenium.*;

public class MainYandex {

    public static By SignInToMail = By.linkText("Войти в почту");
    public static By Videos = By.linkText("Видео");
    public static By Images = By.linkText("Картинки");
    public static By News = By.linkText("Новости");
    public static By Maps = By.linkText("Карты");
    public static By Markets = By.linkText("Маркет");
    public static By Interpreters = By.linkText("Переводчик");
    public static By Musics = By.linkText("Музыка");
    public static By Language = By.cssSelector("a.link[title=\"Выбрать язык\"]");
    public static By AddLanguage = By.cssSelector("a.menu__item[aria-label=\"ещё\"]");
    public static void pageMainYandex() {
        InitialDriver.driver.get("https://yandex.by/");
    }
}
