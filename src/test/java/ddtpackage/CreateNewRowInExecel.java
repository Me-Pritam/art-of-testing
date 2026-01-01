package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateNewRowInExecel
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

            Row newRow = sheet.createRow(9);

            newRow.createCell(0).setCellValue("5");

            newRow.createCell(1).setCellValue("HelpPage");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            wb.write(fos);

            wb.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
