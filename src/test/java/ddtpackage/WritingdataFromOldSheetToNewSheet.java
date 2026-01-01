package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WritingdataFromOldSheetToNewSheet
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet oldSheet = wb.getSheet("TestCasesCount");
            Sheet newSheet = wb.getSheet("NewSheet");

            int startingRow = oldSheet.getFirstRowNum();
            int lastRow = oldSheet.getLastRowNum();

            int firstCell = oldSheet.getRow(0).getFirstCellNum();
            int lastCell = oldSheet.getRow(0).getLastCellNum();

            

            for(int r=startingRow;r<lastRow;r++)
            {
                Row oldRow = oldSheet.getRow(r);
                Row newRow = newSheet.createRow(r);

                for(int c=firstCell;c<lastCell;c++)
                {
                    newRow.createCell(c).setCellValue(oldRow.getCell(c).toString());
                }
            }

            FileOutputStream fos = new FileOutputStream("./src/test/resources/CommondataFolder/NewExcelDataSheet.xlsx");

            wb.write(fos);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
