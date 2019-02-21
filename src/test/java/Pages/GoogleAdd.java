package Pages;

import BroswerFactory.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class GoogleAdd {

    @FindBy(id="ad_unit")
    WebElement add_unit;

    private final static  By reportAddLocator=By.id("report_text");

    private final static  By notInterestInLocator=By.id("survey-container");

    private final static  By closeAddButton=By.id("cbb");

    WebBrowser browser ;


    public GoogleAdd(WebBrowser browser){
        PageFactory.initElements(browser,this);
        this.browser=browser;
    }

    public void clickCloseAdd(){

        WebElement closeBox=this.add_unit.findElement(GoogleAdd.closeAddButton);

        closeBox.click();
    }


    public void clickReportAdd(){
        WebElement report=this.browser.findElement(reportAddLocator);
        report.click();
    }


    public void clickNotInterestIn(){
        WebElement survey=this.browser.findElement(notInterestInLocator);
        String option="Not interested in this ad";
        List<WebElement> options=survey.findElements(By.tagName("a"));

        for(WebElement opt:options){
            System.out.println(opt.getText());
        }
    }


}
