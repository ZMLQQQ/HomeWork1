package InfoStuCou.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManage {
    private static  final Properties prop=new Properties();
    static {
        InputStream io=ConfigManage.class.getClassLoader().getResourceAsStream("config1.properties");
        try{
            prop.load(io);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProp(String key){
        return prop.getProperty(key);
    }
}
