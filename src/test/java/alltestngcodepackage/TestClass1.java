package alltestngcodepackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass1
{
    @Test(groups = "Integration")
    public void m1()
    {
        Reporter.log("This is m1 method from TestClass1",true);
    }

    @Test
    public void m2()
    {
        Reporter.log("This is m2 method from TestClass1",true);
    }

    @Test
    public void m3()
    {
        Reporter.log("This is m3 method from TestClass1",true);
    }

    @Test(groups = "Integration")
    public void m4()
    {
        Reporter.log("This is m4 method from TestClass1",true);
    }
}
