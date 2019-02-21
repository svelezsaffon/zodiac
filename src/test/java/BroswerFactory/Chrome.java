package BroswerFactory;

import Properties.TestingProperties;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by santiago on 10/04/18.
 */

class Chrome extends ChromeDriver implements WebBrowser {

    static {
        TestingProperties prop;
        try {
            prop=TestingProperties.getInstance();
            System.setProperty("webdriver.chrome.driver", prop.getStringProperty(TestingProperties.LOCAL_CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Chrome(){
        super();
    }
}
