package Pages;

import BroswerFactory.WebBrowser;



public class DisplayZodiacPage {

    private String URL;
    private WebBrowser driver;

    public DisplayZodiacPage(String sign,String when)  {

        this.URL="http://www.harbourhoroscope.com/?ac=show&sign="+sign+"&item="+when;

    }

    public String getFormedUrl(){
        return this.URL;
    }
}
