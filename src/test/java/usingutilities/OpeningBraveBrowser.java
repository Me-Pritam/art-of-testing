package usingutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class OpeningBraveBrowser
{
    public static void main(String[] args) {
        try
        {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
            WebDriver driver = new ChromeDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
