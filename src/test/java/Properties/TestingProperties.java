package Properties;

import java.io.*;
import java.util.Properties;

public class TestingProperties {

    public static final String DRIVER_TYPE="driver";
    public static final String USER_ROLE="user";
    public static final String LOCAL_CHROME="lchrome";

    private Properties prop ;

    private static TestingProperties instance=null;

    private TestingProperties() throws IOException {
        this.prop=new Properties();
        InputStream input =  new FileInputStream("src/test/resources/properties.properties");
        prop.load(input);
    }

    public static TestingProperties getInstance() throws IOException {
        if(instance==null){
            instance= new TestingProperties();
        }
        return instance;
    }

    public Object getProperty(String keyName){
       return this.prop.get(keyName);
    }

    public String getStringProperty(String keyName){
        return this.prop.get(keyName).toString();
    }

}
