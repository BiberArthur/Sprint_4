import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ObjektTestOrder {
    private WebDriver driver;
    private ForRegistration objForRegistration;


    @Before // Метод, выполняемый перед каждым тестом
    public void openPage() {
        ChromeOptions options = new ChromeOptions(); // Создаем объект для настройки опций Chrome
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage"); // Добавляем аргументы для запуска без интерфейса и управления размерами памяти

        driver = new ChromeDriver(options); // Инициализируем драйвер с заданными опциями
        driver.get("https://qa-scooter.praktikum-services.ru"); // Открываем веб-страницу с тестовым приложением
        WebElement elementCookie = driver.findElement(By.className("App_CookieButton__3cvqF"));
        elementCookie.click();
        objForRegistration = new ForRegistration(driver);
    }
    @Test
    public void createNewOeder() {
        WebElement element = driver.findElement(By.className("Header_Disclaimer__3VEni"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objForRegistration.clickFirstButtonOrder(); // Открываем окно заказа с первой кнопки
        // Заполняем форму для заказа
        objForRegistration.clickNameFeld();
        driver.findElement(objForRegistration.nameFeld).sendKeys("Иван"); // Вводим имя

        objForRegistration.clickSurnameFeld();
        driver.findElement(objForRegistration.surnameFeld).sendKeys("Иванов"); // Вводим фамилию
        objForRegistration.clickAdresseFeld();
        driver.findElement(objForRegistration.adresseFeld).sendKeys("Москва, улица 1"); // Вводим адрес
        objForRegistration.clickMetroFeld();
        objForRegistration.clickTheStation(); // Выбираем станцию метро
        objForRegistration.clickTelephoneFeld();
        driver.findElement(objForRegistration.telephoneFeld).sendKeys("89994445555"); // Вводим телефон
        objForRegistration.clickButtoneNex(); // Нажимаем "Далее"


        // Выбор даты и срока аренды

        driver.findElement(objForRegistration.rentalDateFeld).sendKeys("12.12.2024"); // Вводим дату
        WebElement element1 = driver.findElement(By.className("Order_Header__BZXOb"));
                element1.click(); // кликаем по элементу на фоне чтобы закрыть календарик
        objForRegistration.clickRentalPeriodeFeld();
        objForRegistration.clickTimePeriod(); // Выбираем срок аренды
        objForRegistration.clickColorFeld(); // Выбираем цвет
        objForRegistration.clickCommentFeld(); // Вводим комментарий
        objForRegistration.clickButtonOrderRedy(); // Нажимаем кнопку "Заказать"
        objForRegistration.clickYesButton(); // кликаем "да"

        // Проверяем статус заказа
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(objForRegistration.modalHeaderGutStatus)); // Ожидаем, пока появится сообщение о статусе заказа
        boolean isOrderSuccessful = objForRegistration.checkOrder(); // Проверяем, что заказ оформлен
        Assert.assertTrue("Заказ не был успешно оформлен!", isOrderSuccessful); // Подтверждаем, что заказ был успешным
    }

    @Test
    public void createNewOrderWithSecondButton() {
        // Прокручиваем к второй кнопке регистрации
        WebElement secondButton = driver.findElement(By.className("Home_SubHeader__zwi_E"));
        scrollToElement(secondButton);
        objForRegistration.clickSecondButtonOrder(); // Открываем окно заказа со второй кнопки

        // Заполняем форму для заказа
        objForRegistration.clickNameFeld();
        driver.findElement(objForRegistration.nameFeld).sendKeys("Ольга"); // Вводим имя
        objForRegistration.clickSurnameFeld();
        driver.findElement(objForRegistration.surnameFeld).sendKeys("Петрова"); // Вводим фамилию
        objForRegistration.clickAdresseFeld();
        driver.findElement(objForRegistration.adresseFeld).sendKeys("Санкт-Петербург, улица 2"); // Вводим адрес
        objForRegistration.clickMetroFeld();
        objForRegistration.clickTheStation(); // Выбираем станцию метро
        objForRegistration.clickTelephoneFeld();
        driver.findElement(objForRegistration.telephoneFeld).sendKeys("89992223344"); // Вводим телефон
        objForRegistration.clickButtoneNex(); // Нажимаем "Далее"

        // Выбор даты и срока аренды
        driver.findElement(objForRegistration.rentalDateFeld).sendKeys("12.12.2024"); // Вводим дату
        WebElement element1 = driver.findElement(By.className("Order_Header__BZXOb"));
        element1.click(); // Кликаем по элементу на фоне, чтобы закрыть календарик
        objForRegistration.clickRentalPeriodeFeld();
        objForRegistration.clickTimePeriod(); // Выбираем срок аренды
        objForRegistration.clickColorFeld(); // Выбираем цвет
        objForRegistration.clickCommentFeld(); // Вводим комментарий
        objForRegistration.clickButtonOrderRedy(); // Нажимаем кнопку "Заказать"
        objForRegistration.clickYesButton(); // Кликаем "да"

        // Проверяем статус заказа
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(objForRegistration.modalHeaderGutStatus));
        boolean isOrderSuccessful = objForRegistration.checkOrder();
        Assert.assertTrue("Заказ не был успешно оформлен!", isOrderSuccessful);
    }

    private void scrollToElement(WebElement secondButton) {
    }

    @After // Метод, выполняемый после каждого теста
     public void tearDown() {
         driver.quit(); // Освобождаем ресурсы и закрываем браузер
     }
 }








