package PageObjects;

import org.openqa.selenium.By;

public class LabSimulationPage extends BasePage {
    private final By testOutSimPageHeader = new By.ById("bControls");
    private final By doneButton = new By.ById("bDone");
    private final By finalScoreWindow = new By.ById("ScoreReportWindow");
    private final By hundredPercentScore = new By.ByXPath("//div[contains(text(),'100%')]");


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
        System.out.println(driver.findElement(hundredPercentScore).getText());

    }
}
