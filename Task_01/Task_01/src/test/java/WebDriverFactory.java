import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Возврат драйвера для конкретного браузера по его названию
    public static WebDriver getDriver(String browserName){
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера " + browserName);
                return new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера " + browserName);
                return new FirefoxDriver();
            }
            default -> throw new RuntimeException("Введено некорректное название браузера");
        }
    }

}
