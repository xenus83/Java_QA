import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebDriverMethodsTest {

    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(WebDriverMethodsTest.class);

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
    public void searchDNSTest() {
        // Добавление задержки Thread.sleep, чтобы увидеть результат

        driver.get("https://www.dns-shop.ru");

        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Открыта страница магазина DNS -" + "https://www.dns-shop.ru/");

        //вывод заголовка страницы
        String title = driver.getTitle();
        logger.info("title - "+ title);
        //вывод текущего URL
        String currentURL = driver.getCurrentUrl();
        logger.info("current URL - " + currentURL);

        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //ввод текста в поле для поиска
        String searchInputXpath = "(//*[@placeholder=\"Поиск по сайту\"])[2]";
        //String searchInputXpath = "(//input[@class=\"ui-input-search__input ui-input-search__input_presearch\"])[1]";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXpath));

        logger.info(searchInput.getDomProperty("placeholder")+" : id ="+searchInput.getDomProperty("id"));

        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String searchText = "Samsung";
        searchInput.sendKeys(searchText);

        logger.info(searchInput.getDomProperty("value"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Нажатие кнопки "Найти"
        String searchButtonXpath = "(//span[@class=\"ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch\"])[2]";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
        searchButton.click();

        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



