package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LabSimulationPage extends BasePage {

    private final By testOutSimPageHeader = new By.ById("bControls");
    private final By doneButton = new By.ById("bDone");
    private final By finalScoreWindow = new By.ById("ScoreReportWindow");
    private final By simulationScore = new By.ByXPath(" //*[@id='reportDiv']/div/div[1]/div[2]");

    public void validateLoad() {
        waitForElementToLoad(testOutSimPageHeader);
    }

    public void selectSimulatorDoneButton() {
        waitForElementToLoadAndClick(doneButton);
    }

    public void validateScoreWindowIsVisible() {
        waitForElementToLoad(finalScoreWindow);

    }

    public void validate100PercentGradeForSimulator() {
        driver.switchTo().frame("_ifrmreport_");
        Assert.assertTrue(driver.findElement(simulationScore).getText().contains("100%"), "100% score not found at the end of the sim");
    }
}
