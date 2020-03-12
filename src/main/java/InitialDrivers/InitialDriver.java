package InitialDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class InitialDriver {


    public static WebDriver driver;
    public static Map<String, WebDriver> drivers = new HashMap<>();
    private static Logger logger = Logger.getLogger("FrontJava.nose");


    public static WebDriver getDriver(String name) {

        logger.log(Level.INFO, "Создается драйвер для" + name);

        if (drivers.containsKey(name)) {
            return drivers.get(name);
        } else {
            if (name.equals("Chrome")) {
                return createChrome(name);
            } else {
                if (name.equals("Ie")) {
                    return createIe(name);
                } else {
                    if (name.equals("FireFox")) {
                        return createFireFox(name);
                    }
                }
            }
            return null;
        }
    }

    private static WebDriver createChrome(String name) {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/chromedriver_win32/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ChromeDriver driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        drivers.put(name, driver);
        return driver;
    }

    private static WebDriver createIe(String name) {
        InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
                .usingDriverExecutable(new File("C:/chromedriver_win32/IEDriverServer.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InternetExplorerDriver driver = new InternetExplorerDriver(service);
        driver.manage().window().maximize();
        drivers.put(name, driver);
        return driver;
    }

    private static WebDriver createFireFox(String name) {
        GeckoDriverService service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("C:/chromedriver_win32/geckodriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirefoxDriver driver = new FirefoxDriver(service);
        driver.manage().window().maximize();
        drivers.put(name, driver);
        return driver;
    }
}