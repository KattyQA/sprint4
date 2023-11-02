import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class AccordingTest {
    private final String expectedAccordingText;
    private final int indexAccoring;
    private WebDriver webDriver;
    private MainPage mainPage;

    public AccordingTest(String expectedAccordingText, int indexAccoring) {
        this.expectedAccordingText = expectedAccordingText;
        this.indexAccoring = indexAccoring;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                {Constans.ACCORDING_TEXT_FOR_CHECK_0, 0},
                {Constans.ACCORDING_TEXT_FOR_CHECK_1, 1},
                {Constans.ACCORDING_TEXT_FOR_CHECK_2, 2},
                {Constans.ACCORDING_TEXT_FOR_CHECK_3, 3},
                {Constans.ACCORDING_TEXT_FOR_CHECK_4, 4},
                {Constans.ACCORDING_TEXT_FOR_CHECK_5, 5},
                {Constans.ACCORDING_TEXT_FOR_CHECK_6, 6},
                {Constans.ACCORDING_TEXT_FOR_CHECK_7, 7},
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void accordingTest() throws InterruptedException {
        mainPage = new MainPage(webDriver);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage.checkAccordionHeadingText(expectedAccordingText, indexAccoring);
    }

    @After
    public void quitDriver() {
        webDriver.quit();
    }
}
