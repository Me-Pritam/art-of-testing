package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateNewCellInExcel
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

            Row headingRow = sheet.getRow(0);

            Cell newCell = headingRow.createCell(2);

            newCell.setCellValue("Features");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            wb.write(fos);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
