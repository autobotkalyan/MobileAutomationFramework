import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Sample
{


    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 27");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.example.myapplication");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("noReset", "false");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement button = driver.findElement(By.id("com.example.myapplication:id/button_first"));

        button.click();

        driver.findElement(By.id("com.example.myapplication:id/button_second")).click();
    }
}
