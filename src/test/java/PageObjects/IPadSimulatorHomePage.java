package PageObjects;

import org.openqa.selenium.By;

public class IPadSimulatorHomePage extends BasePage {
    private final By settingsButton = new By.ById("wpDesktop.DesktopIcon15");
    private final By tabletSimulator = new By.ById("gTablet.Image");


    public void validateTabletSimulatorIsVisible() {
        waitForElementToLoad(tabletSimulator);
    }

    public void selectSettingsIconOnIpadSimulatorDesktop() {
        waitForElementToLoad(settingsButton);
        driver.findElement(settingsButton).click();
    }
}
