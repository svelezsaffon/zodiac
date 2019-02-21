package tests;

import BroswerFactory.WebBrowser;
import Pages.ZodiacHome;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BroswerFactory.WebDriverFactory;
import Properties.TestingProperties;

import java.io.IOException;
import java.util.List;


public class TestHoroscope {

    private TestingProperties prop;
    private WebBrowser browser;

    private ZodiacHome home;

    @BeforeTest
    public void setUpTest() throws IOException {
        prop=TestingProperties.getInstance();
        browser= WebDriverFactory.createDriver(this.prop.getStringProperty(TestingProperties.DRIVER_TYPE));
        String lang = System.getProperty("lang");
        home=new ZodiacHome(lang,browser);
    }

    @Test
    public void test(){
        browser.get(home.getURL());
        List<String> print=home.getAllSymbols();
        System.out.println("------------------------OUT-TEST---------------------");
        for(String name:print){
            System.out.println(name);
        }
        System.out.println("-----------------------END-OUT-TEST---------------------");
    }

    @AfterTest
    public void afterTest(){
        this.browser.quit();
    }

}
