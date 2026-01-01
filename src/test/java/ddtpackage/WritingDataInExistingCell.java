package ddtpackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WritingDataInExistingCell
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

            sheet.getRow(3).getCell(1).setCellValue("RegisterPage");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            wb.write(fos);

            wb.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
