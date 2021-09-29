import org.testng.annotations.Test;
import pages.LoginPage;

public class MenuTest extends SeleniumBaseTest{

    @Test
    public void menu_Test() {
        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .assertProcessesUrl()
                .assertProcessesHeader()
                .assertProcessesTitle()
                .goToCharacteristics()
                .assertCharacteristicsUrl()
                .assertCharacteristicsHeader()
                .assertCharacteristicsTitle()
                .goToDashboard()
                .assertDashboardUrl()
                .assertDashboardTitle()
                .assertDemoProjectIsShown();
    }
}
