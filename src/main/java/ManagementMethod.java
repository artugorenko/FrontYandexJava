import InitialDrivers.InitialDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementMethod {

    public static int environment = 0;
    public static Map<Integer, String> states = new HashMap<Integer, String>();

public static void switchToAndAssert(int position,String text){
    assertEquals(true, InitialDriver.driver.getCurrentUrl().contains(text));
    InitialDriver.driver.switchTo().window(states.get(position).substring(1,states.get(position).length()-1));
}
    public static void setWindowHadles(By locator, int position) {
        Set<String> oldWindowsSet = InitialDriver.driver.getWindowHandles();

        if (environment == 0) {
            states.put(environment, oldWindowsSet.toString());
            environment++;
        }
        Wait.waitElementToClick(locator).click();
        if (environment != 0) {
            String newWindowHandle = (new WebDriverWait(InitialDriver.driver, 10))
                    .until(new ExpectedCondition<String>() {
                        public String apply(WebDriver driver1) {
                            Set<String> newWindowsSet = driver1.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            if (newWindowsSet.size() > 0) {
                                states.put(environment, newWindowsSet.iterator().next());
                                environment++;
                                return newWindowsSet.iterator().next();
                            } else return null;
                        }
                    });
            oldWindowsSet.clear();
        }

        InitialDriver.driver.switchTo().window(states.get(position));
    }
    public static String GetTextWebElement(By locator) throws InterruptedException {
        return Wait.TextWebElement(locator).getText();
    }

    public static void SetTextWebElement(By locator, String text) throws InterruptedException {
        Wait.TextWebElement(locator).sendKeys(text);
    }

    public static void clickWebElement(By locator) throws InterruptedException {
        Wait.waitElementToClick(locator).click();
    }
}
