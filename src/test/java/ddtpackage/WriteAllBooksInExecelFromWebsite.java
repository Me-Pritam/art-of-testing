package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

public class WriteAllBooksInExecelFromWebsite
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://ecommerce.artoftesting.com/");

            driver.findElement(By.xpath("//button[text()='Login']")).click();


            List<WebElement> allBookBoxes = driver.findElements(By.xpath("//div[@class='Products_item__Za1Q4']"));

            System.out.println(allBookBoxes.size());

            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/BooksList.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet newSheet = wb.getSheet("Books");

            Row nameRow = newSheet.createRow(0);

            nameRow.createCell(0).setCellValue("Book Name");

            nameRow.createCell(1).setCellValue("Book Price");

            int count=1;


            for(WebElement box : allBookBoxes)
            {
                Row newRow = newSheet.createRow(count);

                String name= box.findElement(By.xpath(".//div[@class='Products_title__7ggYL']")).getText();
                String price = box.findElement(By.xpath(".//div[@class='Products_price__I96sm']")).getText();

                newRow.createCell(0).setCellValue(name);
                newRow.createCell(1).setCellValue(price);

                count++;



            }


            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/BooksList.xlsx");
            wb.write(fos);
            wb.close();






        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
