package BroswerFactory;

/**
 * Created by santiago on 10/04/18.
 */
public class WebDriverFactory {

    public static WebBrowser createDriver(String type){
        WebBrowser dr=null;

        switch (type){
            case "crhome":
                dr=new Chrome();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                dr=new FireFox();
                break;
            case "remote":
                dr =new RemoteeDriver();
                break;
            default:
                dr=new Chrome();
                break;
        }

        return dr;
    }

}
