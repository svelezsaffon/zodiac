package tests;

import BroswerFactory.WebBrowser;
import BroswerFactory.WebDriverFactory;

import Pages.DisplayZodiacPage;
import Properties.TestingProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestSignPage {
    private TestingProperties prop;

    private WebBrowser browser;

    private DisplayZodiacPage home;

    @BeforeTest
    public void setUpTest() throws IOException {
        prop=TestingProperties.getInstance();
        browser= WebDriverFactory.createDriver(this.prop.getStringProperty(TestingProperties.DRIVER_TYPE));
        String sign = System.getProperty("sign");
        String when = System.getProperty("when");
        home=new DisplayZodiacPage(sign,when);
        browser.get(home.getFormedUrl());
    }

    @Test
    public void test(){

        File src= ((TakesScreenshot)this.browser).getScreenshotAs(OutputType.FILE);

        System.out.println("-----------------------OUT-TEST---------------------");
        System.out.println("SCREENSHOT STORED IN \"src/test/screenshots/latest.png\"");
        System.out.println("-----------------------END-OUT-TEST---------------------");
        try {
            FileHandler.copy(src, new File("src/test/screenshots/latest.png"));
        }


        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
    }

    @AfterTest
    public void afterTest(){
         this.browser.quit();
    }
}
