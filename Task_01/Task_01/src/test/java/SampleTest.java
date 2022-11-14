import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SampleTest {
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(SampleTest.class);

    String env = System.getProperty("browser", "chrome");

    @BeforeEach
    public void setUp(){
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал");
    }

    @AfterEach
    public void setDown(){
        if(driver != null){
           driver.quit();
           logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void openPage(){
        driver.get("https://yandex.ru");
        logger.info("Открыта страница Yandex - " + "https://yandex.ru");

    }
}
