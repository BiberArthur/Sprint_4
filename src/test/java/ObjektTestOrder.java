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

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Добавляем аргументы для запуска без интерфейса и управления размерами памяти

        driver = new ChromeDriver(options); // Инициализируем драйвер с заданными опциями
        driver.get("https://qa-scooter.praktikum-services.ru"); // Открываем веб-страницу с тестовым приложением
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        objForRegistration = new ForRegistration(driver);
        objForRegistration.clickCookieButton(); // нажимаем на кнопку куки
    }
    @Test
    public void createNewOeder() {
        objForRegistration.scrollToElement(); // cкролим

        objForRegistration.clickFirstButtonOrder(); // Открываем окно заказа с первой кнопки
        // Заполняем форму для заказа
        objForRegistration.fillOrderForm("Ольга", "Петрова", "Санкт-Петербург, улица 2",
                "89992223344");

        objForRegistration.clickButtoneNex(); // Нажимаем "Далее"

        // Выбор даты и срока аренды
        objForRegistration.selectRentalDetails("24.12.2024");
        objForRegistration.clickButtonOrderRedy(); // Нажимаем кнопку "Заказать"

        objForRegistration.clickYesButton(); // кликаем "да" СОБСТВЕНННО ТУТ БАГ (на хроме кнопка не кликабельна)

        // Проверяем статус заказа
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(objForRegistration.modalHeaderGutStatus)); // Ожидаем, пока появится сообщение о статусе заказа
        boolean isOrderSuccessful = objForRegistration.checkOrder(); // Проверяем, что заказ оформлен
        Assert.assertTrue("Заказ не был успешно оформлен!", isOrderSuccessful); // Подтверждаем, что заказ был успешным

    }

    @Test
    public void createNewOrderWithSecondButton() {
        // Прокручиваем к второй кнопке регистрации
        objForRegistration.scrollToSecondElement();
        objForRegistration.clickSecondButtonOrder(); // Открываем окно заказа со второй кнопки

        // Заполняем форму для заказа
        objForRegistration.fillOrderForm("Иван", "Тестович", "Санкт-Петербург, улица 5",
                "89999999999");

        objForRegistration.clickButtoneNex(); // Нажимаем "Далее"

        // Выбор даты и срока аренды
        objForRegistration.selectRentalDetails("28.12.2024");
        objForRegistration.clickButtonOrderRedy(); // Нажимаем кнопку "Заказать"
        objForRegistration.clickYesButton(); // кликаем "да"

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








