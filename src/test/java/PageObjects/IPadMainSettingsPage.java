package PageObjects;

import org.openqa.selenium.By;

public class IPadMainSettingsPage extends BasePage {
    private final By ipadSettingsPage = new By.ById("Settings");
    private final By mailContactsCalendarsMenuItem = new By.ById("siMailContactsCalendars");
    private final By wifiMenuItem = new By.ById("siWiFi");


    public void validateLoad() {
        waitForElementToLoad(ipadSettingsPage);
    }

    public void selectMailContactsCalendarsMenuItem() {
        waitForElementToLoadAndClick(mailContactsCalendarsMenuItem);
    }


    public void selectWifiMenuItem() {
        waitForElementToLoadAndClick(wifiMenuItem);
    }
}