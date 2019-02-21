package tests;

import BroswerFactory.WebBrowser;
import BroswerFactory.WebDriverFactory;
import Pages.LoveCompatibilityPage;
import Pages.MiniTestPage;
import Pages.ZodiacHome;
import Properties.TestingProperties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;



public class TestLoveCompatibility {

    private TestingProperties prop;

    private WebBrowser browser;

    private ZodiacHome home;

    @BeforeTest
    public void setUpTest() throws IOException {
        prop=TestingProperties.getInstance();
        browser= WebDriverFactory.createDriver(this.prop.getStringProperty(TestingProperties.DRIVER_TYPE));
        home=new ZodiacHome("EN",browser);
        browser.get(home.getURL());
    }

    @Test
    public void test() throws InterruptedException {

        String symbol1=System.getProperty("sign1");

        String symbol2=System.getProperty("sign2");

        this.home.clickCompatibilityTest();

        MiniTestPage test=new MiniTestPage(this.browser);

        test.openWheelSelector();

        test.selectFirstSymbol(symbol1);

        test.selectSecondSymbol(symbol2);

        test.confirmSelection();

        test.getYourLoveCompatibility();

        LoveCompatibilityPage resultPage=new LoveCompatibilityPage(this.browser);
        System.out.println("------------------------OUT-TEST---------------------");
        System.out.println(String.format("%s + %s: %s Love:%s", symbol1,symbol2,resultPage.getTitle(),resultPage.getLevelOfLove()));
        System.out.println("-----------------------END-OUT-TEST---------------------");
    }

    @AfterTest
    public void afterTest(){
//        this.browser.quit();
    }

}
