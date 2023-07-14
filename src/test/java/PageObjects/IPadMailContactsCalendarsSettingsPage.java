package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;

public class IPadMailContactsCalendarsSettingsPage extends BasePage {

    private final By maggieBrownAccountButton = new By.ByXPath("//*[text()='Maggie Brown']");
    private final By maggieBrownEmailAddressAccountButton = new By.ByXPath("//*[text()='mbrown@gmail.com']");
    private final By emailAccountAdvancedButton = new By.ByXPath("//*[text()='Advanced']");
    private final By useSSLToggle = new By.ByXPath("//*[contains(@id, 'siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchThumb')]");
    private final By serverPortSetting = new By.ByXPath("//*[contains(@id, 'tbServerPort')]");
    private final By accountAdvancedSettingsBackButton = new By.ByXPath("//*[contains(@id, 'btnAccount')]");
    private final By accountSettingsDoneButton = new By.ByXPath("//*[contains(@id, 'btnDone')]");

    public void selectAccountUserMaggieBrownInMailContactsCalendarsSettings() {
        waitForElementToLoadAndClick(maggieBrownAccountButton);
    }

    public void selectEmailAccountButtonInMailSettings() {
        waitForElementToLoadAndClick(maggieBrownEmailAddressAccountButton);
    }

    public void selectEmailAccountAdvancedButton() {
        waitForElementToLoadAndClick(emailAccountAdvancedButton);
    }

    public void toggleUseSSLOnInAdvancedSettings() {
        waitForElementToLoad(useSSLToggle);
        var toggleElement = driver.findElement(useSSLToggle);
        int xCoordClickOffset = (driver.findElement(useSSLToggle).getSize().width) / 2;
        new Actions(driver).moveToElement(toggleElement).moveByOffset(xCoordClickOffset, 0).click().perform();
    }

    public void validateThatServerPortIs993InAdvancedSettings() {
        WebElement sslToggle = driver.findElement(useSSLToggle);
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(sslToggle);
        new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 200).perform();
        waitForElementToLoad(serverPortSetting);
        Assert.assertEquals(driver.findElement(serverPortSetting).getAttribute("value"), "993", "Value of Server Port is not 993");
    }

    public void selectBackButtonOnAdvancedSettingsSubMenu() {
        waitForElementToLoadAndClick(accountAdvancedSettingsBackButton);
    }

    public void selectDoneButtonInAccountSettingsSubmenu() {
        waitForElementToLoadAndClick(accountSettingsDoneButton);
    }
}
