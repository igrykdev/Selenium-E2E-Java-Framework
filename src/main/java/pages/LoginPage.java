package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ErrorRepository;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = "#Email-error")
    public WebElement emailError;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public DashboardPage submitLogin() {
        loginBtn.click();
        return new DashboardPage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();

        return this;
    }

    public CreateAccountPage goToCreateAccountPage() {
        registerLnk.click();
        return new CreateAccountPage(driver);
    }

    public LoginPage assertLoginErrorIsShown() {
        String expError = ErrorRepository.loginError_WrongPassword;
        Assert.assertTrue(
                loginErrors
                        .stream()
                        .anyMatch(error -> error.getText().equals(expError))
        );
        return this;
    }

    public LoginPage assertEmailErrorIsShown() {
        String expError = ErrorRepository.loginError_WrongEmail;
        Assert.assertEquals(emailError.getText(), expError);

        return this;
    }
}