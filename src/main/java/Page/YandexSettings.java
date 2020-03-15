package Page;
import org.openqa.selenium.By;

public class YandexSettings {

public static By SelectLanguage = By.xpath("//*[@id=\"form__a11y\"]/div[1]/div/div[1]/div[1]/button");
public static By EnLanguage = By.cssSelector("div.popup__content .select__item:nth-child(6)");
public static By ButtonSave = By.xpath(".//button[span[text()=\"Сохранить\"]]");
}
