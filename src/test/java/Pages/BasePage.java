package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
    public void openLoginUrl(String url) {
        driver.get(url);
    }
    public void quitBrowser() {
        driver.quit();
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
    String randomName = generateRandomName();
    public void clickOnElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    public void enterText (By locator, String text) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
//    public void clickOk(){
//        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
//        okBtn.click();
//    }
    public void selectNewRandomPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        selectPlaylist.click();
    }
}
