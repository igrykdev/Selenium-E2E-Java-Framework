package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProcessPage extends MenuPage {

    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name")
    private WebElement nameFld;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    private WebElement nameError;

    @FindBy(linkText = "Back to List")
    private WebElement backBtn;

    public CreateProcessPage typeName(String processName) {
        nameFld.clear();
        nameFld.sendKeys(processName);

        return this;
    }

    public ProcessesPage submitCreate() {
        createBtn.click();

        return new ProcessesPage(driver);
    }

    public CreateProcessPage submitCreateWithFailure() {
        createBtn.click();

        return this;
    }

    public ProcessesPage backToProcessesList() {
        backBtn.click();

        return new ProcessesPage(driver);
    }

    public CreateProcessPage assertProcessNameError(String expErrorMessage) {
        Assert.assertEquals(nameError.getText(), expErrorMessage);

        return this;
    }
}