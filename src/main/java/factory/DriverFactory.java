package factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static pages.baseMethods.getDataProperties;

public class DriverFactory
{
    static String path = "src/main/resources/iOSAutomation.TestData/AndroidRunner.properties";

    public static AndroidDriver<WebElement> initializeDriver() throws IOException {

        AndroidDriver<WebElement> driver;

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, getDataProperties(path,"PLATFORM_VERSION"));
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, getDataProperties(path,"PLATFORM_NAME"));
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, getDataProperties(path,"AUTOMATION_NAME"));
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, getDataProperties(path,"DEVICE_NAME"));
        dc.setCapability("app", getDataProperties(path,"app"));

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        return driver;
    }
}
