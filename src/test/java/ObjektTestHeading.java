import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class) // Указываем, что класс будет использовать параметризованные тесты
public class ObjektTestHeading {
    private WebDriver driver; // Объявляем драйвер браузера
    private CheckFlashcards checkFlashcards;// Объявляем переменную для класса CheckFlashcards
    // private ForRegistration registration;

    // Параметры для теста
    @Parameterized.Parameter(0)
    public String headingText; // Ожидаемый текст заголовка
    @Parameterized.Parameter(1)
    public String expectedResultText; // Ожидаемый текст результата
    @Parameterized.Parameter(2)
    public int headingIndex; // Индекс заголовка
    @Parameterized.Parameter(3)
    public int resultIndex; // Индекс текста результата

    // Локаторы заголовков
    private By[] headings = {
            By.id("accordion__heading-0"), // Локатор для первого заголовка
            By.id("accordion__heading-1"), // Локатор для второго заголовка
            By.id("accordion__heading-2"), // Локатор для третьего заголовка
            By.id("accordion__heading-3"), // Локатор для четвертого заголовка
            By.id("accordion__heading-4"), // Локатор для пятого заголовка
            By.id("accordion__heading-5"), // Локатор для шестого заголовка
            By.id("accordion__heading-6"), // Локатор для седьмого заголовка
            By.id("accordion__heading-7")  // Локатор для восьмого заголовка
    };

    // Локаторы текстов результатов
    private By[] results = {
            By.id("accordion__panel-0"), // Локатор для текста результата первого заголовка
            By.id("accordion__panel-1"), // Локатор для текста результата второго заголовка
            By.id("accordion__panel-2"), // Локатор для текста результата третьего заголовка
            By.id("accordion__panel-3"), // Локатор для текста результата четвертого заголовка
            By.id("accordion__panel-4"),  // Локатор для текста результата пятого заголовка
            By.id("accordion__panel-5"),  // Локатор для текста результата шестого заголовка
            By.id("accordion__panel-6"),  // Локатор для текста результата сельмого заголовка
            By.id("accordion__panel-7")  // Локатор для текста результата восьмого заголовка
    };

    // Указываем параметры тестового набора
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0, 0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1, 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2, 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4, 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5, 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6, 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7, 7}
        });
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://qa-scooter.praktikum-services.ru");
        WebElement elementCookie = driver.findElement(By.className("App_CookieButton__3cvqF"));
        elementCookie.click();
        checkFlashcards = new CheckFlashcards(driver); // Создаем экземпляр CheckFlashcards, передавая драйвер

    }

    @Test
    public void testAccordionTexts() {
        // Получаем локаторы по индексам из массивов
        By headingLocator = headings[headingIndex]; // Получаем локатор заголовка
        By resultLocator = results[resultIndex]; // Получаем локатор текста результата

        // Находим заголовок по локатору и получаем его текст
        WebElement headingElement = driver.findElement(headingLocator); // Ищем заголовок
        String actualHeadingText = headingElement.getText(); // Получаем текст заголовка
        // Кликаем по заголовку
        headingElement.click(); // Кликаем по заголовку, если текст совпадает



        String actualResultText = driver.findElement(resultLocator).getText(); // Получаем текст результата

        String errorMessage = "Тексты не совпадают! Ожидаемый заголовок: " + headingText +
                ", фактический: " + actualHeadingText +
                "; Ожидаемый результат: " + expectedResultText +
                ", фактический: " + actualResultText;

        // Выполняем одно assert для обеих проверок
        Assert.assertTrue(errorMessage,
                headingText.equals(actualHeadingText) && expectedResultText.equals(actualResultText));
    }

    @After // Метод, выполняемый после каждого теста
    public void tearDown() {
        driver.quit(); // Освобождаем ресурсы и закрываем
    }
}
