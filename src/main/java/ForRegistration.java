import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//окно создания заказа
public class ForRegistration {
    private WebDriver driver; // Объявляем переменную для драйвера
    private By cookieButton = By.className("App_CookieButton__3cvqF"); // Локатор для кнопки куки
    //private By disclaimerLocator = By.className("Header_Disclaimer__3VEni");
    private By firstButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']"); //первая кнопка рег-ии
    private By secondButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //вторая кнопка рег-ии
    public By nameFeld = (By.xpath(".//input[@placeholder='* Имя']"));// поле имя
    By surnameFeld = (By.xpath(".//input[@placeholder='* Фамилия']"));// поле фамилия
    By adresseFeld = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //поле адреса
    private By metroFeld = By.className("select-search__input");// поле станции метро
    private By theStation = By.xpath(".//div[text()='Бульвар Рокоссовского']");// выбор станции
    By telephoneFeld = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //поле телефон
    private By buttoneNex = By.xpath(".//button[text()='Далее']"); // кнопка далее

    // Конструктор
    public ForRegistration(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click(); // Нажимаем на кнопку куки
    }
    public void scrollToElement() {
        WebElement element = driver.findElement(By.className("Header_Disclaimer__3VEni")); // Находим элемент по локатору
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); // Скроллим к элементу
    }
    public void scrollToSecondElement() {
        WebElement element = driver.findElement(By.className("Home_SubHeader__zwi_E")); // Находим элемент по локатору
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); // Скроллим к элементу
    }

    // Тут заполняем персональные данные
    void fillOrderForm(String name, String surname, String address, String phone) {
        clickNameFeld();
        driver.findElement(nameFeld).sendKeys(name); // Вводим имя

        clickSurnameFeld();
        driver.findElement(surnameFeld).sendKeys(surname); // Вводим фамилию

        clickAdresseFeld();
        driver.findElement(adresseFeld).sendKeys(address); // Вводим адрес

        clickMetroFeld();
        clickTheStation(); // Выбираем станцию метро

        clickTelephoneFeld();
        driver.findElement(telephoneFeld).sendKeys(phone); // Вводим телефон
    }

    // Тут заполняем срок аренды
    void selectRentalDetails(String rentalDate) {
        driver.findElement(rentalDateFeld).sendKeys(rentalDate); // Вводим дату

        WebElement element1 = driver.findElement(By.className("Order_Header__BZXOb"));
        element1.click(); // Кликаем по элементу на фоне, чтобы закрыть календарик

        clickRentalPeriodeFeld();
        clickTimePeriod(); // Выбираем срок аренды
        clickColorFeld(); // Выбираем цвет
        clickCommentFeld(); // Вводим комментарий
    }




    public void clickFirstButtonOrder(){
        driver.findElement(firstButtonOrder).click(); // кликаем по первой кнопке заказать
    }
    public void clickSecondButtonOrder(){
        driver.findElement(secondButtonOrder).click();// кликаем по второй кнопке заказать
    }
    public void clickNameFeld(){
        driver.findElement(nameFeld).click(); // кликнтуть по полю имя
    }
    public void clickSurnameFeld(){
        driver.findElement(surnameFeld).click(); // кликнуть по полю фамилия
    }
    public void clickAdresseFeld(){
        driver.findElement(adresseFeld).click(); // кликнуть по полю адрес
    }
    public void clickMetroFeld(){
        driver.findElement(metroFeld).click(); // кликнтуть по полю метро
    }
    public void clickTheStation(){
        driver.findElement(theStation).click(); // выбрать кликом станцию
    }
    public void clickTelephoneFeld(){
        driver.findElement(telephoneFeld).click(); // кликнуть по полю телефон
    }
    public void clickButtoneNex(){
        driver.findElement(buttoneNex).click(); // кликнуть кнопку далее
    }
// второе окно создания заказа
    private By dataFeld = By.className("App_App__15LM-");// клик по полю дата
    By rentalDateFeld = By.xpath(".//input[@placeholder='* Когда привезти самокат']");// клик по полю время аренды
    private By rentaPeriodFeld = By.className("Dropdown-placeholder");// нажать на поле срок аренды
    private By timePeriod =By.xpath(".//div[text()='трое суток']");// выбрать срок аренды
    private By colorFeld = By.xpath(".//label[@for='grey']");// выбор цвета
    private By commentFeld = By.xpath(".//input[@placeholder='Комментарий для курьера']");//коментарий
    private By buttonOrderRedy = By.xpath(".//button[text()='Заказать']");//  кнопка заказать

    private By yesButon = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопка да
    By modalHeaderGutStatus = By.xpath(".//button[@text()='Посмотреть статус']");







    public void clickDataFeld() {
        driver.findElement(dataFeld).click(); // кликнуть по полю дата
    }
    public void clickRentalDateFeld() {
        driver.findElement(rentalDateFeld).click(); // кликнуть по полю дата аренды
    }
    public void clickRentalPeriodeFeld(){
        driver.findElement(rentaPeriodFeld).click(); // кликнуть по полю срок аренды
    }
    public void clickTimePeriod(){
        driver.findElement(timePeriod).click();// выбрать срок аренды 3е суток
    }

    public void clickColorFeld() {
        driver.findElement(colorFeld).click(); // кликнуть по выбору цвета
    }

    public void clickCommentFeld() {
        driver.findElement(commentFeld).click(); // кликнуть по полю "комментария"
    }

    public void clickButtonOrderRedy() {
        driver.findElement(buttonOrderRedy).click();// кликнуть по кнопке "заказать"
    }
    public void clickYesButton() {
        driver.findElement(yesButon).click(); //подтвердить заказ кнопка "да"
    }

    public boolean checkOrder() {
        return driver.findElement(modalHeaderGutStatus).isEnabled();
    }
}

