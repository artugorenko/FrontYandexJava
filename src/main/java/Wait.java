import InitialDrivers.InitialDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Wait {

    public static WebElement TextWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(InitialDriver.driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return InitialDriver.driver.findElement(locator);
    }

    public static WebElement waitElementToClick(By locator) {
        WebDriverWait wait = new WebDriverWait(InitialDriver.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return InitialDriver.driver.findElement(locator);
    }
}
