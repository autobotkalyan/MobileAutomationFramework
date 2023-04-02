import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class VisualTesting
{
    public static void waitForElement(MobileElement element)
    {
        await("The element is not available within 10 seconds").
                ignoreExceptions().
                pollInterval(1, TimeUnit.SECONDS).
                atMost(10, TimeUnit.SECONDS).
                until(element::isDisplayed, is(true));
    }
    public static void main(String[] args) throws MalformedURLException {


        Eyes eyes = new Eyes();
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("SpdfL5bseEht109kfS3t12wujQtIlQwa539Hh6NryOL90110");

        // Setup appium - Make sure the capabilities meets your environment.
        // Refer to http://appium.io documentation if required.
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", ".MainActivity");


        // The original app from Appium github project.
//        dc.setCapability("app", "/Users/kalyanparam/AndroidStudioProjects/MyApplication/app/build/outputs/apk/debug/app-debug.apk");

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        try {
            // Start visual UI testing
            eyes.open(driver, "iOS test application", "test");

            // Visual validation point #1
            eyes.checkWindow("Login Window");

            driver.findElement(By.xpath("//*[@content-desc='test-Username']")).sendKeys("standard_user");
            driver.findElement(By.xpath("//*[@content-desc='test-Password']")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//*[@content-desc='test-LOGIN']")).click();

            eyes.checkWindow("Home Screen");

            // End visual UI testing. Validate visual correctness.
            eyes.close();
        } finally {
            eyes.abortIfNotClosed();
            driver.quit();
        }

    }
}
