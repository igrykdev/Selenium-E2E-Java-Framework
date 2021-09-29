package pages;

import config.Config;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {
    protected WebDriver driver;
    protected Config config = new Config();

    public SeleniumPage (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException exc){}
        return false;
    }
}