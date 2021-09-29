import config.Config;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config;
    protected String url;
    protected String user;
    protected String password;
    protected String demoProcessName;

    @BeforeClass
    public void baseBeforeClass() {
        config = new Config();
        System.setProperty("webdriver.chrome.driver", config.getApplicationDriverPath());
        url = config.getApplicationUrl();
        user = config.getApplicationUser();
        password = config.getApplicationPassword();
        demoProcessName = config.getApplicationDemoProjectName();
    }

    @BeforeMethod
    public void baseBeforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getApplicationUrl());
    }

    @AfterMethod
    public void baseAfterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            getScreenShot(testResult.getMethod().getMethodName());
        }
        driver.quit();
    }

    private void getScreenShot(String name) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName = "\\snapshots\\" + name + "_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
            String filePath = System.getProperties().get("user.dir") + fileName;
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException ex) {
            System.out.println("Exception while taking screenshot: " + ex.getMessage());
        }
    }
}