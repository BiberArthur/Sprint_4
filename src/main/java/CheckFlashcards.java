import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckFlashcards {
    private WebDriver driver; // Объявляем переменную для драйвера
    private By firstHeading = By.id("accordion__heading-0"); // Локатор для первого заголовка
    private By secondHeading = By.id("accordion__heading-1"); // Локатор для второго заголовка
    private By thirdHeading = By.id("accordion__heading-2"); // Локатор для третьего заголовка
    private By fourthHeading = By.id("accordion__heading-3"); // Локатор для четвертого заголовка
    private By fifthHeading = By.id("accordion__heading-4"); // Локатор для пятого заголовка
    private By sixthHeading = By.id("accordion__heading-5"); // Локатор для шестого заголовка
    private By seventhHeading = By.id("accordion__heading-6"); // Локатор для седьмого заголовка
    private By eighthHeading = By.id("accordion__heading-7"); // Локатор для восьмого заголовка
    // Локаторы текста результатов
    private By firstResultText = By.id("accordion__panel-0");
    private By secondResultText = By.id("accordion__panel-1");
    private By thirdResultText = By.id("accordion__panel-2");
    private By fourthResultText = By.id("accordion__panel-3");
    private By fifthResultText = By.id("accordion__panel-4");
    private By sixthResultText = By.id("accordion__panel-5");
    private By seventhResultText = By.id("accordion__panel-6");
    private By eighthResultText = By.id("accordion__panel-7");


    public CheckFlashcards(WebDriver driver) {
        this.driver = driver; // Инициализация драйвера, переданного в конструктор
    }

    public void clickButtoneOne() {
        driver.findElement(firstHeading).click(); // Кликаем по первому заголовку
    }
    public String getResultTextOne() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultText)); // Ждем, пока текст станет видимым
        return driver.findElement(firstResultText).getText(); // Получаем текст результата
    }

    public void clickButtoneTwo() {
        driver.findElement(secondHeading).click(); // Кликаем по второму заголовку
    }
    public String getResultTextTwo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondResultText)); // Ждем, пока текст станет видимым
        return driver.findElement(secondResultText).getText(); // Получаем текст результата
    }

    public void clickButtoneThree() {
        driver.findElement(thirdHeading).click(); // Кликаем по третьему заголовку
    }
    public String getResultTextThree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdResultText)); // Ждем, пока текст станет видимым
        return driver.findElement(thirdResultText).getText(); // Получаем текст результата
    }


    public void clickButtoneFour() {
        driver.findElement(fourthHeading).click(); // Кликаем по четвертому заголовку
    }
        public String getResultTextFour() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
            wait.until(ExpectedConditions.visibilityOfElementLocated(fourthResultText)); // Ждем, пока текст станет видимым
            return driver.findElement(fourthResultText).getText(); // Получаем текст результата
        }


    public void clickButtoneFive() {
        driver.findElement(fifthHeading).click(); // Кликаем по пятому заголовку
    }
        public String getResultTextFive() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
            wait.until(ExpectedConditions.visibilityOfElementLocated(fifthResultText)); // Ждем, пока текст станет видимым
            return driver.findElement(fifthResultText).getText(); // Получаем текст результата
        }


    public void clickButtoneSix() {
        driver.findElement(sixthHeading).click(); // Кликаем по первому заголовку
    }
        public String getResultTextSix() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
            wait.until(ExpectedConditions.visibilityOfElementLocated(sixthResultText)); // Ждем, пока текст станет видимым
            return driver.findElement(sixthResultText).getText(); // Получаем текст результата
        }


    public void clickButtoneSeven() {
        driver.findElement(seventhHeading).click(); // Кликаем по седьмому заголовку
    }
       public String getResultTextSeven() {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
           wait.until(ExpectedConditions.visibilityOfElementLocated(seventhResultText)); // Ждем, пока текст станет видимым
           return driver.findElement(seventhResultText).getText(); // Получаем текст результата
       }

    public void clickButtoneEight() {
        driver.findElement(eighthHeading).click(); // Кликаем по восьмому заголовку
    }
        public String getResultTextEight() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание загрузки текста
            wait.until(ExpectedConditions.visibilityOfElementLocated(eighthResultText)); // Ждем, пока текст станет видимым
            return driver.findElement(eighthResultText).getText(); // Получаем текст результата
        }

}

