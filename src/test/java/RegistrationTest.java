import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class RegistrationTest extends SeleniumBaseTest {
    @Test
    public void Registration_Test() {
        String email = new Utils().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password)
                .submitRegister()
                .assertWelcomeElementIsShown();
    }
}
