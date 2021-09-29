package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ErrorRepository;

public class CreateAccountPage extends MenuPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "Email-error")
    private WebElement emailError;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordError;

    @FindBy(id = "Password-error")
    private WebElement passwordError;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public CreateAccountPage typeConfirmPassword(String password) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(password);

        return this;
    }

    public DashboardPage submitRegister() {
        registerBtn.click();

        return new DashboardPage(driver);
    }

    public CreateAccountPage submitRegisterWithFailure() {
        registerBtn.click();

        return this;
    }

    public CreateAccountPage assertEmailErrorIsShown() {
        String expError = ErrorRepository.registrationError_WrongEmail;
        Assert.assertEquals(emailError.getText(), expError);

        return this;
    }

    public CreateAccountPage assertConfirmPasswordErrorIsShown() {
        String expError = ErrorRepository.registrationError_WrongConfirmPassword;
        Assert.assertEquals(confirmPasswordError.getText(), expError);

        return this;
    }

    public CreateAccountPage assertPasswordErrorIsShown(String expErrorMessage) {
        Assert.assertEquals(passwordError.getText(), expErrorMessage);

        return this;
    }
}