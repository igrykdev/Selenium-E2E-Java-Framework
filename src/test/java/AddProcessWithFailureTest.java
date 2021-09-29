import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ErrorRepository;

public class AddProcessWithFailureTest extends SeleniumBaseTest {
    @DataProvider
    public static Object[][] getWrongProcessName() {
        return new Object[][]{
                {"ab", ErrorRepository.addProcessError_NameLength},
                {"ab12345678901234567890123456789 78787867676565456", ErrorRepository.addProcessError_NameLength},
                {"", ErrorRepository.addProcessError_NoName}
        };
    }
    @Test(dataProvider = "getWrongProcessName")
    public void addProcess_WithFailure_WrongName_Test(String wrongProcessName, String expErrorMessage){

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(wrongProcessName)
                .submitCreateWithFailure()
                .assertProcessNameError(expErrorMessage)
                .backToProcessesList()
                .assertProcessIsNotShown(wrongProcessName);
    }
}