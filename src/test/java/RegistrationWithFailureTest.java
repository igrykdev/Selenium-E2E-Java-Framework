import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ErrorRepository;
import utils.Utils;

public class RegistrationWithFailureTest extends SeleniumBaseTest {
    @Test
    public void Registration_WithFailure_WrongConfirmPassword_Test() {
        String email = new Utils().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password + "a")
                .submitRegisterWithFailure()
                .assertConfirmPasswordErrorIsShown();
    }

    @DataProvider
    public static Object[][] getWrongPasswords() {
        return new Object[][]{
                {"Te!1", ErrorRepository.registrationError_WrongPassword_Length},
                {"Te!12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678", ErrorRepository.registrationError_WrongPassword_Length},
                {"test1!", ErrorRepository.registrationError_WrongPassword_NoUppercase},
                {"TEST1!", ErrorRepository.registrationError_WrongPassword_NoLowercase},
                {"Test11", ErrorRepository.registrationError_WrongPassword_NoAlphanumeric},
                {"Test!!", ErrorRepository.registrationError_WrongPassword_NoDigit},
                {"", ErrorRepository.registrationError_NoPassword}
        };
    }

    @Test(dataProvider = "getWrongPasswords")
    public void Registration_WithFailure_WrongPassword_Test(String wrongPassword, String expErrorMessage) {
        String email = new Utils().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(wrongPassword)
                .typeConfirmPassword(wrongPassword)
                .submitRegisterWithFailure()
                .assertPasswordErrorIsShown(expErrorMessage);
    }

    @DataProvider
    public Object[][] getWrongEmails() {
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void Registration_WithFailure_WrongEmail_Test(String wrongEmail) {
        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(wrongEmail)
                .submitRegisterWithFailure()
                .assertEmailErrorIsShown();
    }
}
