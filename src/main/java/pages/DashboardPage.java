package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends MenuPage {
    private String GENERIC_PROCESS_ROW_XPATH = "//h2[text()='%s']/../..";
    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//h2[text()='%s']/../..//p[contains(text(),'%s')]";
    private String pageUrl = config.getApplicationUrl();

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='DEMO PROJECT']")
    private WebElement demoProjectHeader;

    @FindBy(linkText = "Create your first process")
    private WebElement createFirstProjectBtn;

    public DashboardPage assertDashboardUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }

    public DashboardPage assertDashboardTitle(){
        Assert.assertEquals(driver.getTitle(), "Dashboard - Statistical Process Control");

        return this;
    }

    public DashboardPage assertDemoProjectIsShown() {
        Assert.assertTrue(isElementPresent(demoProjectHeader) || isElementPresent(createFirstProjectBtn));

        return this;
    }

    public DashboardPage assertProcessExistsOnDashboard(String processName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, processName);
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        Assert.assertEquals(process.size(), 1);

        return this;
    }

    public DashboardPage assertCharacteristicExistsOnDashboard(String processName, String characteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, processName, characteristicName);
        List<WebElement> characteristic = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertEquals(characteristic.size(), 1);

        return this;
    }

}
