package ddtpackage;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;

public class FetchingDataFromExcelWithEmptyCell
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/DataSheetWithEmptycells.xlsx");

            Workbook wb= WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheet("EmptyCellSheet");

            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();

            int firstCell = sheet.getRow(firstRow).getFirstCellNum();
            int lastCell = sheet.getRow(firstRow).getLastCellNum();

            for(int r=firstRow; r<=lastRow; r++)
            {
                Row newRow = sheet.getRow(r);

                for(int c=firstCell; c<lastCell; c++)
                {
                  Cell newCell= newRow.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                  if (newCell==null)
                  {
                      System.out.print("***"+" ");
                  }
                  else{
                      System.out.print(newCell.toString()+" ");
                  }
                }
                System.out.println();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
