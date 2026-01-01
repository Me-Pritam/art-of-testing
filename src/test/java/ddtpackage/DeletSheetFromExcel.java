package ddtpackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeletSheetFromExcel
{
    public static void main(String[] args) throws Exception{

        FileInputStream fis = new FileInputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

       Workbook wb= WorkbookFactory.create(fis);

     int desiredSheetIndex= wb.getSheetIndex("Sheet3");

     wb.removeSheetAt(desiredSheetIndex);

       FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ExeclData.xlsx");

       wb.write(fos);

       wb.close();



    }
}
