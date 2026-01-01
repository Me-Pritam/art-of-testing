package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeletingRowFromExcel
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb= WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

           Row desiredRow =  sheet.getRow(1);

           sheet.removeRow(desiredRow);

           FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

           wb.write(fos);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
