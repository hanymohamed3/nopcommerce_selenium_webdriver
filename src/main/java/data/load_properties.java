package data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class load_properties {
    public static Properties userdata=Load_properties(System.getProperty("user.dir")+"\\src\\properties\\userdata.properties");

   private static Properties Load_properties(String path) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            System.out.println("error occured in " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error occured in " + e.getMessage());
        }

        return properties;
    }
}
