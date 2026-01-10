package alltestngcodepackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass2
{
    @Test
    public void m5()
    {
        Reporter.log("This is m5 method from TestClass2",true);
    }

    @Test
    public void m6()
    {
        Reporter.log("This is m6 method from TestClass2",true);
    }

    @Test(groups = "Integration")
    public void m7()
    {
        Reporter.log("This is m7 method from TestClass2",true);
    }

    @Test
    public void m8()
    {
        Reporter.log("This is m8 method from TestClass2",true);
    }
}
