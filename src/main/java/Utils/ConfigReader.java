package Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties loadProperties(String filePath){
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(filePath)){
            properties.load(input);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return properties;
    }
}
