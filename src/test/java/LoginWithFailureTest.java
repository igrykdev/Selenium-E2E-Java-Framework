import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginWithFailureTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getWrongEmails() {
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void LoginWithFailure_WrongEmail_Test(String wrongEmail) {
        new LoginPage(driver)
                .typeEmail(wrongEmail)
                .submitLoginWithFailure()
                .assertEmailErrorIsShown();
    }

    @Test
    public void LoginWithFailure_WrongPassword_Test() {
        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password + "a")
                .submitLoginWithFailure()
                .assertLoginErrorIsShown();
    }
}