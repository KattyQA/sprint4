import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver webDriver;
    private final By orderBottomButton = By.xpath("//*[@id='root]/div/div/div[4]/div[2]/div[5]/button");
    private final By orderTopButton = By.xpath(".//button[@class= 'Button_Button__ra12g']");
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroStation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By forwardButton = By.xpath(".//*[text()= 'Далее']");
    private final By calendarField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By timeRentField = By.className("Dropdown-arrow");
    private final By timeRentPicker = By.className("Dropdown-option");
    private final By colourCheckBox = By.className("Checkbox_Input__14A2w");
    private final By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private final By orderGetButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]");
    private final By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");
    private final By orderText = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderTopButton() {
        webDriver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        webDriver.findElement(orderBottomButton).click();
    }

    public void setTextToFieldsNameLastNameAddressPhone(String name, String lastName, String address, String phone) {
        webDriver.findElement(nameField).sendKeys(name);
        webDriver.findElement(lastNameField).sendKeys(lastName);
        webDriver.findElement(addressField).sendKeys(address);
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    public void clickMetroField() {
        webDriver.findElement(metroField).click();
    }

    public void chooseFirstStation() {
        webDriver.findElements(metroStation).get(0).click();
    }

    public void clickForwardButton() {
        webDriver.findElement(forwardButton).click();
    }

    public void clickCalendarAndChooseDate(String date) {
        webDriver.findElement(calendarField).sendKeys(date);

    }

    public void clickTimeRentAndChooseTime() {
        webDriver.findElement(timeRentField).click();
        webDriver.findElements(timeRentPicker).get(0).click();
    }

    public void clickCheckBox() {
        webDriver.findElement(colourCheckBox).click();
    }

    public void inputComment(String comment) {
        webDriver.findElement(commentField).sendKeys(comment);
    }

    public void clickButtonOrderAndYes() {
        webDriver.findElement(orderGetButton).click();
        webDriver.findElement(yesButton).click();
    }

    public String getOrderText() {
        return webDriver.findElement(orderText).getText();
    }

    public void scrollToBottomOrderButton() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(orderBottomButton));
    }

}
