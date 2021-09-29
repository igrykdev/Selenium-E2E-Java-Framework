import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class AddProcessTest extends SeleniumBaseTest {

    @Test
    public void addProcess_Test() {
        String processName = new Utils().generateRandomName();

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(processName)
                .submitCreate()
                .assertProcessExists(processName, "", "");
    }

    @Test
    public void addProcess_ShownOnDashboard_Test() {
        String processName = new Utils().generateRandomName();

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(processName)
                .submitCreate()
                .goToDashboard()
                .assertProcessExistsOnDashboard(processName);
    }
}
