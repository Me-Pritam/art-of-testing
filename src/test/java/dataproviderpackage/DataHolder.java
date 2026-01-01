package dataproviderpackage;

import org.testng.annotations.DataProvider;

public class DataHolder
{
    @DataProvider(name = "TestTools")
    public Object[][] getData()
    {
        Object[][] arr = new Object[3][2];

        arr[0][0] = "TDD";
        arr[0][1] = "TestNG";

        arr[1][0] = "BDD";
        arr[1][1] = "Cucumber";

        arr[2][0] = "ATDD";
        arr[2][1] = "Playwrite";

        return arr;

    }
}
