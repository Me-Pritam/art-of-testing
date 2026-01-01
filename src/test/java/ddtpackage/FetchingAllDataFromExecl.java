package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class FetchingAllDataFromExecl
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("TestCasesCount");

            int rowCount= sheet.getLastRowNum();

            int cellCount = sheet.getRow(0).getLastCellNum();

            for(int r=1;r<=rowCount;r++)
            {
                Row newRow = sheet.getRow(r);

                for(int c=0;c<cellCount;c++)
                {
                    System.out.print(newRow.getCell(c).toString());
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
