package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePage {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void waitForElementToLoad(By element) {
        //allowing for up to 10 checks for element load up. This allows for a few seconds of wait time.
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                if (driver.findElement(element).isDisplayed()) {
                    logger.log(Level.INFO, "Found element: " + element.toString());
                    return;
                }
            } catch (NoSuchElementException | InterruptedException e) {
                logger.log(Level.INFO, "Waiting for element to load: " + element.toString());
            }
        }
        throw new NoSuchElementException("Could not find element: " + element.toString());
    }

    public void waitForElementToLoadAndClick(By element) {
        //allowing for up to 10 checks for element load up. This allows for a few seconds of wait time.
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                if (driver.findElement(element).isDisplayed()) {
                    logger.log(Level.INFO, "Found element: " + element.toString());
                    driver.findElement(element).click();
                    return;
                }
            } catch (NoSuchElementException | InterruptedException e) {
                logger.log(Level.INFO, "Waiting for element to load: " + element.toString());
            }
        }
        throw new NoSuchElementException("Could not find element: " + element.toString());
    }
}
