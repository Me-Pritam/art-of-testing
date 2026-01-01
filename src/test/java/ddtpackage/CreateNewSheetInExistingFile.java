package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateNewSheetInExistingFile
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet newSheet= wb.createSheet("DemoTestSheetOne");
            Row newRow = newSheet.createRow(0);
            newRow.createCell(0).setCellValue("DemoText");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/NewWorkBookFile.xlsx");

            wb.write(fos);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
