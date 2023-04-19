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

public class PickerWheelConcept
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

        driver.findElement(By.id("Picker View")).click();


        boolean flag = false;

        while(!flag) {
            WebElement redPickerWheel = driver.findElementByIosNsPredicate("label == \"Red color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(redPickerWheel.getText().equals("100"))
            {
                flag = true;
            }
        }

        flag = false;

        while(!flag) {
            WebElement greenPickerWheel = driver.findElementByIosNsPredicate("label == \"Green color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) greenPickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(greenPickerWheel.getText().equals("150"))
            {
                flag = true;
            }
        }

        flag = false;

        while(!flag) {
            WebElement bluePickerWheel = driver.findElementByIosNsPredicate("label == \"Blue color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) bluePickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(bluePickerWheel.getText().equals("200"))
            {
                flag = true;
            }
        }









    }
}
