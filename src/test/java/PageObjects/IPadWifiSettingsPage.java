package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class IPadWifiSettingsPage extends BasePage {

    private final By wifiSettingsPageHeader = new By.ByXPath("//*[text()='Wi-Fi Networks']");
    private final By corpNetWifiOptionButton = new By.ByXPath("//*[text()='CorpNet']");
    private final By wifiPasswordBox = new By.ById("EnterPassword.Grid.Border");
    private final By wifiJoinButton = new By.ById("btnJoin");

    public void validateLoad() {
        waitForElementToLoad(wifiSettingsPageHeader);
    }

    public void selectCorpNetWifiOption() {
        waitForElementToLoadAndClick(corpNetWifiOptionButton);
    }

    public void enterPasswordIntoWifiPasswordScreenAndJoin(String password) {
        waitForElementToLoad(wifiPasswordBox);
        new Actions(driver).sendKeys(password).perform();
        selectJoinOnWifiPasswordScreen();
    }

    public void selectJoinOnWifiPasswordScreen() {
        waitForElementToLoadAndClick(wifiJoinButton);
    }
}
