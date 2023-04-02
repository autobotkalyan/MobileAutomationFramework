package LetsCart;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.baseMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class Automation extends baseMethods
{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//        dc.setCapability(MobileCapabilityType.AUTO_WEBVIEW,true);


        // The original app from Appium github project.
        dc.setCapability("app", "/Users/kalyanparam/Downloads/resources/General-Store.apk");

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //waitForElement(driver.findElement(By.id("com.androidsample.generalstore:id/nameField")));

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("VV");

        //To hide the device keyboard
        driver.hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        driver.findElement(By.id("android:id/text1")).click();


        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"Belgium\").instance(0))").click();

        Thread.sleep(2000);

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@text='Air Jordan 4 Retro']/following::android.widget.TextView[2]")).click();

        Thread.sleep(2000);

        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"Jordan 6 Rings\").instance(0))");


        driver.findElement(By.xpath("//*[@text='Jordan 6 Rings']/following::android.widget.TextView[2]")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();



//        Thread.sleep(2000);
//
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//
//        Thread.sleep(2000);
//
//        driver.findElementByAndroidUIAutomator
//                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"Converse All Star\").instance(0))");
//
//        driver.findElement(By.xpath("//*[@text='Converse All Star']/following::android.widget.TextView[2]")).click();
//
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();


        WebElement longPressbtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

        //.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)longPressbtn).getId(),"duration",2000));

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(6000);

        Set<String> contexts = driver.getContextHandles();

        for(String x: contexts)
        {
            System.out.println(x);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //Pressing device back button
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //Back again to native
        driver.context("NATIVE_APP");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Back to Native");

       /* Set<String> contexts = driver.getContextHandles();

        for(String a: contexts)
        {
            System.out.println(a);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Native view"); */




//        double price1 = 1.2;
//        double price2 = 2.4;
//
//        double summation = 3.6;
//
//
//        assertThat(summation).isEqualTo(price1+price2);



       /* //To get the toast error message
        String errorMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.println(errorMessage);

        assertThat(errorMessage).isEqualTo("Please enter your name");*/


    }
}
