package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CharacteristicsPage extends MenuPage {
    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//td[text()='%s']/..";
    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";
    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";
    private String pageUrl = config.getApplicationUrl() + "Characteristics";

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-title h3")
    private WebElement pageHeader;

    @FindBy(linkText = "Add new characteristic")
    private WebElement addCharacteristicBtn;

    public ResultsPage goToResults(String characteristicName) {
        String resultsBtnXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);
        driver.findElement(By.xpath(resultsBtnXpath)).click();

        return new ResultsPage(driver);
    }

    public ReportPage goToReport(String characteristicName) {
        String reportBtnXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH, characteristicName);
        driver.findElement(By.xpath(reportBtnXpath)).click();

        return new ReportPage(driver);
    }

    public CreateCharacteristicPage clickAddCharacteristic() {
        addCharacteristicBtn.click();

        return new CreateCharacteristicPage(driver);
    }

    public CharacteristicsPage assertCharacteristicsUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader() {
        Assert.assertEquals(pageHeader.getText(), "Characteristics");

        return this;
    }

    public CharacteristicsPage assertCharacteristicsTitle() {
        Assert.assertEquals(driver.getTitle(), "Characteristics - Statistical Process Control");

        return this;
    }

    public CharacteristicsPage assertCharacteristicExists(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);

        return this;
    }

    public CharacteristicsPage assertCharacteristicIsNotShown(String characteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        List<WebElement> characteristic = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertEquals(characteristic.size(), 0);

        return this;
    }
}
