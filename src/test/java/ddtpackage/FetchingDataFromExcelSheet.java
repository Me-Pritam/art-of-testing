package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingDataFromExcelSheet
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

            System.out.println(cell.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
