import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class AddCharacteristicWithFailureTest extends SeleniumBaseTest{
    @Test
    public void addCharacteristic_WithFailure_ProcessError_Test() {
        String characteristicName = new Utils().generateRandomName();
        String lsl = "8";
        String usl = "10";

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .typeName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreateWithFailure()
                .assertProcessError()
                .backToCharacteristicsList()
                .assertCharacteristicIsNotShown(characteristicName);
    }

    @Test
    public void addCharacteristic_WithFailure_EmptyUslFieldError_Test() {
        String characteristicName = new Utils().generateRandomName();
        String lsl = "8";

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(demoProcessName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .submitCreateWithFailure()
                .assertEmptyUslFieldError()
                .backToCharacteristicsList()
                .assertCharacteristicIsNotShown(characteristicName);
    }

}
