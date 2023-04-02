package LetsCart;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserTest
{
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.AUTO_WEBVIEW,true);

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("http://google.com");

        driver.findElement(By.name("q")).sendKeys("appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
}
