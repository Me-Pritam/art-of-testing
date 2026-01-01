package ddtpackage;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromProperty
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/ArtOfTestingProperty.properties");

            Properties property = new Properties();

            property.load(fis);

            System.out.println(property.getProperty("url" +
                    ""));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
