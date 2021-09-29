package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateResultsPage extends MenuPage {

    public CreateResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Sample")
    private WebElement sampleTxt;

    @FindBy(css = "#Values")
    private WebElement resultsTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    public CreateResultsPage typeSampleName(String sampleName) {
        sampleTxt.clear();
        sampleTxt.sendKeys(sampleName);

        return this;
    }

    public CreateResultsPage typeResults(String results) {
        resultsTxt.clear();
        resultsTxt.sendKeys(results);

        return this;
    }

    public ResultsPage submitCreate() {
        createBtn.click();

        return new ResultsPage(driver);
    }

}