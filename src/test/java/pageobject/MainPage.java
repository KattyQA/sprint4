package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkAccordionHeadingText(String expectedText, int index) throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElements(By.cssSelector(".accordion__button")).get(index));
        webDriver.findElements(By.cssSelector(".accordion__button")).get(index).click();
        Thread.sleep(1000);
        String checkText = webDriver.findElements(By.cssSelector(".accordion__panel")).get(index).getText();
        assertEquals(expectedText, checkText);
    }
}
