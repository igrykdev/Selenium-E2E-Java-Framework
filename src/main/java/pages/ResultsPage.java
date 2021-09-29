package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends MenuPage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add results sample")
    private WebElement addResultsBtn;

    @FindBy(linkText = "Back to characteristics")
    private WebElement backBtn;

    public CreateResultsPage clickAddResults() {
        addResultsBtn.click();

        return new CreateResultsPage(driver);
    }

    public CharacteristicsPage backToCharacteristics() {
        backBtn.click();

        return new CharacteristicsPage(driver);
    }
}