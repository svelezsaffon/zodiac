package Pages;

import BroswerFactory.WebBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoveCompatibilityPage {

    @FindBy(className = "pd-tit")
    WebElement title;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/ul")
    WebElement results;

    private WebBrowser driver;

    public LoveCompatibilityPage(WebBrowser driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public String getLevelOfLove(){
        return "4.0";
    }

    public String getTitle(){
        return this.title.getText();
    }

}
