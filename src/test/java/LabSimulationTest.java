import PageObjects.*;
import org.testng.annotations.Test;

public class LabSimulationTest extends BaseTest {

    LabSimulationPage labSimulationPage = new LabSimulationPage();
    IPadSimulatorHomePage iPadSimulatorHomePage = new IPadSimulatorHomePage();
    IPadMainSettingsPage iPadMainSettingsPage = new IPadMainSettingsPage();
    IPadMailContactsCalendarsSettingsPage iPadMailContactsCalendarsSettingsPage = new IPadMailContactsCalendarsSettingsPage();
    IPadWifiSettingsPage wifiSettingsPage = new IPadWifiSettingsPage();

    @Test
    public void labSimTest(){

        //Use the Accounts and Passwords option to go to Maggie Brown's email account settings and change the advanced configuration to Use SSL to securely communicate with the IMAP server over server port 993.
        labSimulationPage.validateLoad();
        iPadSimulatorHomePage.validateTabletSimulatorIsVisible();
        iPadSimulatorHomePage.selectSettingsIconOnIpadSimulatorDesktop();
        iPadMainSettingsPage.validateLoad();
        iPadMainSettingsPage.selectMailContactsCalendarsMenuItem();
        iPadMailContactsCalendarsSettingsPage.selectAccountUserMaggieBrownInMailContactsCalendarsSettings();
        iPadMailContactsCalendarsSettingsPage.selectEmailAccountButtonInMailSettings();
        iPadMailContactsCalendarsSettingsPage.selectEmailAccountAdvancedButton();
        iPadMailContactsCalendarsSettingsPage.toggleUseSSLOnInAdvancedSettings();
        iPadMailContactsCalendarsSettingsPage.validateThatServerPortIs993InAdvancedSettings();
        iPadMailContactsCalendarsSettingsPage.selectBackButtonOnAdvancedSettingsSubMenu();
        iPadMailContactsCalendarsSettingsPage.selectDoneButtonInAccountSettingsSubmenu();

        //Connect Maggie to the CorpNet access point through the Wi-Fi configuration using @CorpNetWeRSecure!& as the password.
        iPadMainSettingsPage.selectWifiMenuItem();
        wifiSettingsPage.validateLoad();
        wifiSettingsPage.selectCorpNetWifiOption();
        wifiSettingsPage.enterPasswordIntoWifiPasswordScreenAndJoin("@CorpNetWeRSecure!&");
        labSimulationPage.selectSimulatorDoneButton();

        //Verify that the test is completed with a 100% score
        labSimulationPage.validateScoreWindowIsVisible();
        labSimulationPage.validate100PercentGradeForSimulator();
    }
}
