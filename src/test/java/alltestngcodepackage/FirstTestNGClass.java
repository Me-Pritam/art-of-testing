package alltestngcodepackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGClass
{
    @Test(priority = 3)
    public void demo1()
    {
        Reporter.log("This is the demo1 method",true);
    }

    @Test(priority = 2)
    public void demo2()
    {
        Reporter.log("This is the demo2 method",true);
    }

    @Test(priority = 4)
    public void demo3()
    {
        Reporter.log("This is the demo3 method",true);
    }

    @Test(priority = 1)
    public void demo4()
    {
        Reporter.log("This is the demo4 method",true);
    }
}
