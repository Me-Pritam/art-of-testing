package ddtpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FetchDataFromDemoProperty
{
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("./src/test/resources/CommondataFolder/ConfigProperty.properties");

            Properties property = new Properties();

            property.load(fis);

            System.out.println(property.getProperty("browser"));

            property.setProperty("browser","Edge");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/CommondataFolder/ConfigProperty.properties");

            property.store(fos,"Required CHanges done by NAME");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
