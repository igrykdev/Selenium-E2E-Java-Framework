import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class ReportTest extends SeleniumBaseTest {

    @Test
    public void Report_Test() {
        String characteristicName = new Utils().generateRandomName();
        String lsl = "8.0000";
        String usl = "10.0000";
        String sampleName = "Test sample";
        String results = "8.0;9.0";

        String expMean = "8.5000";
        String expStandardDeviation = "0.7071";
        String expPerformanceIndex = "0.4714";
        String expPpl = "0.2357";
        String expPpu = "0.7071";
        String expPpk = "0.2357";

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
                .goToResults(characteristicName)
                .clickAddResults()
                .typeSampleName(sampleName)
                .typeResults(results)
                .submitCreate()
                .backToCharacteristics()
                .goToReport(characteristicName)
                .assertLsl(lsl)
                .assertUsl(usl)
                .assertMean(expMean)
                .assertStandardDeviation(expStandardDeviation)
                .assertPerformanceIndex(expPerformanceIndex)
                .assertPplIndex(expPpl)
                .assertPpuIndex(expPpu)
                .assertPpkIndex(expPpk);
    }
}
