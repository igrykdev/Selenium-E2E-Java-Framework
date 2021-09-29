import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class AddCharacteristicTest extends SeleniumBaseTest {
    @Test
    public void addCharacteristic_Test() {
        String characteristicName = new Utils().generateRandomName();
        String lsl = "8";
        String usl = "10";

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(demoProcessName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreate()
                .assertCharacteristicExists(characteristicName, lsl, usl, "");
    }

    @Test
    public void addCharacteristic_ShownOnDashboard_Test() {
        String characteristicName = new Utils().generateRandomName();
        String lsl = "8";
        String usl = "10";

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(demoProcessName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreate()
                .goToDashboard()
                .assertCharacteristicExistsOnDashboard(demoProcessName, characteristicName);
    }
}
