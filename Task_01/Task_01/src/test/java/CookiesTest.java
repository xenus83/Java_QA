import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class CookiesTest {

    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(CookiesTest.class);

    String env = System.getProperty("browser", "chrome");

    @BeforeEach
    public void setUP(){
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown(){
        if(driver != null){
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void cookiesTest(){
        driver.get("https://www.dns-shop.ru");
        logger.info("Открыта страница DNS - "+ driver.getCurrentUrl());
        driver.manage().addCookie(new Cookie("Cookie 1","This Is Cookie 1"));

        logger.info("Куки которые добавили мы \n");
        Cookie cookie1 = driver.manage().getCookieNamed("Cookie 1");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
        logger.info(String.format("Name: %s",cookie1.getName()));
        logger.info(String.format("Path: %s",cookie1.getPath()));
        logger.info(String.format("Value: %s",cookie1.getValue()));
        logger.info("--------------------------------------");

        // Вывод информации по кукам dns-shop.ru
        logger.info("Куки, которое добавил DNS\n");
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie : cookies) {
            logger.info(String.format("Domain: %s", cookie.getDomain()));
            logger.info(String.format("Expiry: %s", cookie.getExpiry()));
            logger.info(String.format("Name: %s", cookie.getName()));
            logger.info(String.format("Path: %s", cookie.getPath()));
            logger.info(String.format("Value: %s", cookie.getValue()));
            logger.info("--------------------------------------");
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
