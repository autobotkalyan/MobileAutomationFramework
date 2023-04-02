import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class SwagLabsApp
{

    public static void waitForElement(MobileElement element)
    {
        await("The element is not available within 10 seconds").
                ignoreExceptions().
                pollInterval(1, TimeUnit.SECONDS).
                atMost(10, TimeUnit.SECONDS).
                until(element::isDisplayed, is(true));
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 27");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("noReset", "false");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);


        waitForElement(driver.findElement(By.xpath("//*[@content-desc='test-Username']")));

        driver.findElement(By.xpath("//*[@content-desc='test-Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@content-desc='test-Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@content-desc='test-LOGIN']")).click();


        //waitForElement(driver.findElement(By.xpath("//*[@content-desc='test-Modal Selector Button']")));

        String visibleText = "$15.99";
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().textContains(\""+visibleText+
                        "\").instance(0))").click();

       // waitForElement(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK TO PRODUCTS\"]/android.widget.TextView")));

        String visibleText1 = "ADD TO CART";
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().textContains(\""+visibleText1+
                        "\").instance(0))").click();

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();


        String checkout = "CHECKOUT";
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().textContains(\""+checkout+
                        "\").instance(0))").click();


        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));







    }
}
