import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends SeleniumBaseTest {
    @Test
    public void correctLogin_Test() {
        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .assertWelcomeElementIsShown();
    }
}
