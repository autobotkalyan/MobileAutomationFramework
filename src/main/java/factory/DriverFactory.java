package factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory
{


    public static AndroidDriver<WebElement> initializeDriver() throws MalformedURLException {

        AndroidDriver<WebElement> driver;

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("app", "/Users/kalyanparam/Downloads/resources/General-Store.apk");

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        return driver;
    }
}
