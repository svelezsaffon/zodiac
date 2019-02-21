package Pages;


import BroswerFactory.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ZodiacHome {

    private String URL;
    private WebBrowser driver;
    private boolean loadedElements=false;

    /**
    TODO este boton no tiene id, nombre o algun identificador unico. Asiq ue debemos utilizar algo como xpath normal o por href.
    FindBy(xpath="//a[@href='http://www.smalltests.com/?ac=horoscope_match&channel=dhyiipol']")
    */
    @FindBy(xpath="/html/body/div[2]/section[2]/a")
    WebElement compButton;


    public ZodiacHome(String language,WebBrowser driver){
        this.URL="http://www.harbourhoroscope.com/?country="+language;
        this.driver=driver;
    }

    public void loadElements(){
        PageFactory.initElements(driver,this);
        this.loadedElements=true;
    }

    public String getURL(){
        return this.URL;
    }


    public void clickCompatibilityTest(){
        if(!this.loadedElements){
            this.loadElements();
        }
        this.compButton.click();
    }

    public List<String> getAllSymbols(){
        ArrayList<String> zodiacs=new ArrayList<>();

        WebElement section=this.driver.findElement(By.className("xz-list"));

        List<WebElement> fullZodiacList=section.findElements(By.cssSelector("li[class^='i']"));

        for(WebElement zodiac:fullZodiacList){
            String name=zodiac.findElement(By.className("name")).getText();
            String date=zodiac.findElement(By.className("ext")).getText();
            zodiacs.add(String.format("%s  %s", name,date));
        }

        return zodiacs;
    }

    public void closeAdd(){
        GoogleAdd add=new GoogleAdd(this.driver);
        add.clickCloseAdd();
    }

}
