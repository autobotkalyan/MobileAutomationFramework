import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class SauceLabsIntegration
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

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion","12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.2.1.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "appium-build-78TTM");
        sauceOptions.setCapability("name", "Sauce Demo");
        caps.setCapability("sauce:options", sauceOptions);


        URL url = new URL("https://oauth-be.kalyankumar-9434b:61356ee1-f7e1-4a2f-a2e6-d05d71700eeb@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(url, caps);

//        Thread.sleep(5000);

        waitForElement(driver.findElement(By.xpath("//*[@content-desc='test-Username']")));


        driver.findElement(By.xpath("//*[@content-desc='test-Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@content-desc='test-Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@content-desc='test-LOGIN']")).click();
        driver.quit();


    }
}
