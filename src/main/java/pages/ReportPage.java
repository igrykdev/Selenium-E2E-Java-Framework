package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ReportPage extends MenuPage {
    public ReportPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//td[text()='Lower Specification Limit (LSL)']/../td[2]")
    private WebElement lslCell;

    @FindBy(xpath = "//td[text()='Upper Specification Limit (USL)']/../td[2]")
    private WebElement uslCell;

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;

    @FindBy(xpath = "//td[text()='Standard deviation (s)']/../td[2]")
    private WebElement standardDeviationCell;

    @FindBy(xpath = "//td[text()='Performance index (Pp)']/../td[2]")
    private WebElement performanceIndexCell;

    @FindBy(xpath = "//td[text()='Lower process performance index (Ppl)']/../td[2]")
    private WebElement pplIndexCell;

    @FindBy(xpath = "//td[text()='Upper process performance index (Ppu)']/../td[2]")
    private WebElement ppuIndexCell;

    @FindBy(xpath = "//td[text()='Process performance index (Ppk)']/../td[2]")
    private WebElement ppkIndexCell;

    public ReportPage assertLsl(String expLsl){
        Assert.assertEquals(lslCell.getText(), expLsl);

        return this;
    }

    public ReportPage assertUsl(String expUsl){
        Assert.assertEquals(uslCell.getText(), expUsl);

        return this;
    }

    public ReportPage assertMean(String expMean){
        Assert.assertEquals(meanCell.getText(), expMean);

        return this;
    }

    public ReportPage assertStandardDeviation(String expStandardDeviation){
        Assert.assertEquals(standardDeviationCell.getText(), expStandardDeviation);

        return this;
    }

    public ReportPage assertPerformanceIndex(String expPerformanceIndex){
        Assert.assertEquals(performanceIndexCell.getText(), expPerformanceIndex);

        return this;
    }

    public ReportPage assertPplIndex(String expPplIndex){
        Assert.assertEquals(pplIndexCell.getText(), expPplIndex);

        return this;
    }

    public ReportPage assertPpuIndex(String expPpuIndex){
        Assert.assertEquals(ppuIndexCell.getText(), expPpuIndex);

        return this;
    }

    public ReportPage assertPpkIndex(String expPpkIndex){
        Assert.assertEquals(ppkIndexCell.getText(), expPpkIndex);

        return this;
    }
}