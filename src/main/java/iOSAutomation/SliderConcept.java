package iOSAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SliderConcept
{
    public static void main(String[] args) throws MalformedURLException {

        IOSDriver<WebElement> driver;

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.UDID, "17DECD8C-F1CD-4173-983A-117DB02BBEF5");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 14 pro");
        dc.setCapability("app", "/Users/kalyanparam/Downloads/ios-uicatalog-master/UIKitCatalog/UIKitCatalog-iphonesimulator.app");

        driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

        driver.findElement(By.id("Sliders")).click();

        WebElement sliderElement = driver.findElementByIosNsPredicate("value == \"42%\"");
        sliderElement.sendKeys("0");

        sliderElement = driver.findElementByIosNsPredicate("value == \"0%\"");
        sliderElement.sendKeys("1");






    }
}
