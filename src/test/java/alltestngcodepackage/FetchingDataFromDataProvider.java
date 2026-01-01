package alltestngcodepackage;

import dataproviderpackage.DataHolder;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FetchingDataFromDataProvider
{
    @Test(dataProvider = "TestTools",dataProviderClass = DataHolder.class)
    public void fetchData(String frmeWork,String tool )
    {
        Reporter.log(frmeWork+"~~~~~~"+tool,true);
    }
}
