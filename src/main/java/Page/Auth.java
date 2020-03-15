package Page;
import org.openqa.selenium.By;

public class Auth {
    public static By login = By.id("passp-field-login");
    public static By password = By.id("passp-field-passwd");
    public static By entranceLogin = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1"
            + "]/form"
            + "/div[3]/button[1]");
    public static By entrancePassword = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form"
            + "/div[2]/button[1]");
    public static By textErrorPassword = By.className("passp-form-field__error");
    public static By textErrorLogin = By.className("passp-form-field__error");
}

