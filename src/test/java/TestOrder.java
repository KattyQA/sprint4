import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.OrderPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.startsWith;

public class TestOrder {
    private WebDriver webDriver;
    private OrderPage orderPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void checkTopButtonOrderTest() {
        orderPage = new OrderPage(webDriver);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        orderPage.clickOrderTopButton();
        orderPage.setTextToFieldsNameLastNameAddressPhone("Владислав", "Дунаев", "Пермь", "89443336373");
        orderPage.clickMetroField();
        orderPage.chooseFirstStation();
        orderPage.clickForwardButton();
        orderPage.clickCalendarAndChooseDate("01.10.2023");
        orderPage.clickTimeRentAndChooseTime();
        orderPage.clickCheckBox();
        orderPage.inputComment("комментарий");
        orderPage.clickButtonOrderAndYes();
        MatcherAssert.assertThat(orderPage.getOrderText(), startsWith("Заказ оформлен"));
    }

    @Test
    public void checkBottomButtonOrderTest() {
        orderPage = new OrderPage(webDriver);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        orderPage.scrollToBottomOrderButton();
        orderPage.clickOrderBottomButton();
        orderPage.setTextToFieldsNameLastNameAddressPhone("Владислав", "Дунаев", "Пермь", "89443336373");
        orderPage.clickMetroField();
        orderPage.chooseFirstStation();
        orderPage.clickForwardButton();
        orderPage.clickCalendarAndChooseDate("01.10.2023");
        orderPage.clickTimeRentAndChooseTime();
        orderPage.clickCheckBox();
        orderPage.inputComment("комментарий");
        orderPage.clickButtonOrderAndYes();
        MatcherAssert.assertThat(orderPage.getOrderText(), startsWith("Заказ оформлен"));
    }

    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}
