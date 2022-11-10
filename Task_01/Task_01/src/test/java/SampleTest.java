import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
