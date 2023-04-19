package iOSAutomation;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static pages.baseMethods.getDataProperties;

public class TestData
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

         /*driver.findElement(By.id("Steppers")).click();

         for(int i=1; i<=4; i++) {
             driver.findElement(By.name("Increment")).click();
         }

         String incrementedCount = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Decrement\"])[1]/following::XCUIElementTypeStaticText[1]")).getText();
        System.out.println(incrementedCount);
         BiPredicate<String,String> verifyingCount = String::equals;

        if(!verifyingCount.test(incrementedCount, "3"))
        {
            System.out.println("Fail");
        }
        else
        {
            System.out.println("Pass");
        }*/

        //Toggle the switch
        /*driver.findElement(By.name("Switches")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='DEFAULT'])[1]/following::" +
                "XCUIElementTypeSwitch[1]")).click();*/

        //Accessing text fields
        driver.findElement(By.id("Text Fields")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='DEFAULT'])[1]/following::XCUIElementTypeTextField[1]")).sendKeys("test");


        //System.out.println(driver.findElement(By.name("Increment")).getAttribute("type"));

    }
}
