package Pages;

import BroswerFactory.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class MiniTestPage {



    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]")
    WebElement startMiniTestsButton;


    private WebBrowser driver;

    /**
     * TODO
     * I do not agree to use xpath, but the zodiac page is terrible written
     */

    private final static  By wheelSelector=By.xpath("//*[@id=\"wheelpicker-\"]/div[2]/div[2]/div[1]/div[1]/ul");

    private final static  By wheelSelector2=By.xpath("//*[@id='wheelpicker-']/div[2]/div[2]/div[1]/div[2]/ul");

    private final static  By getLoveTest=By.xpath("/html/body/div[1]/div[2]/div[2]/a[1]");

    private WebDriverWait wait;

    public MiniTestPage(WebBrowser driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        wait = new WebDriverWait(this.driver, 50);
    }


    public void openWheelSelector(){
        this.startMiniTestsButton.click();
    }

    public void selectFirstSymbol(String symbolText) throws InterruptedException {
        this.selectSymbol(symbolText,MiniTestPage.wheelSelector);
    }


    public void selectSecondSymbol(String symbolText) throws InterruptedException {
        this.selectSymbol(symbolText,MiniTestPage.wheelSelector2);
    }


    private void selectSymbol(String symbolText,By selector) throws InterruptedException {

        WebElement wheelPicker = this.driver.findElement(selector);

        List<WebElement> lis = wheelPicker.findElements(By.tagName("li"));

        Map<String,Integer> position=new HashMap<>();
        position.put("Aries",0);
        position.put("Taurus",1);
        position.put("Gemini",2);
        position.put("Cancer",3);
        position.put("Leo",4);
        position.put("Virgo",5);
        position.put("Libra",6);
        position.put("Scorpio",7);
        position.put("Sagittarius",8);
        position.put("Capricorn",9);
        position.put("Aquarius",10);
        position.put("Pisces",11);

        int moves=position.get(symbolText);

        for(int i=0;i<moves;i++){
            WebElement li=lis.get(i);
            Actions act=new Actions(driver);
            act.clickAndHold(li).moveByOffset(10,0).release(li).build().perform();
        }



    }

    /*


*/
    public void  getYourLoveCompatibility(){
        wait.until(ExpectedConditions.elementToBeClickable(getLoveTest));
        WebElement get=this.driver.findElement(getLoveTest);
        get.click();
    }

    public void confirmSelection(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-set")));
        WebElement actions=this.driver.findElement(By.className("btn-set"));
        actions.click();
        wait.until(ExpectedConditions.invisibilityOf(actions));
    }

}
