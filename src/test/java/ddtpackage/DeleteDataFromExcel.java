package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeleteDataFromExcel
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

            Row row = sheet.getRow(1);

            Cell cell = row.getCell(1);

            cell.setBlank();

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            wb.write(fos);

        }
        catch (Exception e)
        {
            e.printStackTrace();
                    }

    }
}
