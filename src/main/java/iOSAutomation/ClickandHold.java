package iOSAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ClickandHold
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

        driver.findElement(By.id("Steppers")).click();

        WebElement element = driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]");

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 2);

        driver.executeScript("mobile: touchAndHold", params);

    }
}
