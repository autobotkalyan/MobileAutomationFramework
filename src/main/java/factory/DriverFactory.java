package factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static pages.baseMethods.getDataProperties;

public class DriverFactory
{
    static String androidpath = "src/main/resources/TestData/AndroidRunner.properties";

    static String iOSpath = "src/main/resources/TestData/iOSRunner.properties";

    public static AndroidDriver<WebElement> AndroidinitializeDriver() throws IOException {

        AndroidDriver<WebElement> driver;

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, getDataProperties(androidpath,"PLATFORM_VERSION"));
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, getDataProperties(androidpath,"PLATFORM_NAME"));
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, getDataProperties(androidpath,"AUTOMATION_NAME"));
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, getDataProperties(androidpath,"DEVICE_NAME"));
        dc.setCapability("app", getDataProperties(androidpath,"app"));

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        return driver;
    }

    public static IOSDriver<WebElement> IOSinitializeDriver() throws IOException {

        IOSDriver<WebElement> driver;

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.UDID, getDataProperties(iOSpath,"udid"));
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, getDataProperties(iOSpath,"PLATFORM_NAME"));
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, getDataProperties(iOSpath,"AUTOMATION_NAME"));
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, getDataProperties(iOSpath,"DEVICE_NAME"));
        dc.setCapability("app", getDataProperties(iOSpath,"app"));

        driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        return driver;
    }


}
