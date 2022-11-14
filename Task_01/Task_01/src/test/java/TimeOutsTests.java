import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class TimeOutsTests {

    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(TimeOutsTests.class);
    final String env = System.getProperty("browser","chrome");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void timeOutsTest1(){
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.dns-shop.ru/");
        logger.info("Отыкртыка страниа DNS - " + driver.getCurrentUrl());
    }

    @Test
    public void timeOutsTest2(){
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.MICROSECONDS);
        driver.get("https://www.dns-shop.ru/");
        logger.info("Отыкртыка страниа DNS - " + driver.getCurrentUrl());
    }
}
