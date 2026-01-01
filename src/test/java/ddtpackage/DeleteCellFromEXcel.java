package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeleteCellFromEXcel
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet= wb.getSheet("TestCasesCount");

            Row row = sheet.getRow(0);

            Cell desiredCell = row.getCell(2);

            desiredCell.setBlank();

            row.removeCell(desiredCell);

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            wb.write(fos);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
