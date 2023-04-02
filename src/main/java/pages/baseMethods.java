package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class baseMethods
{
    public static void waitForElement(WebElement element)
    {
        await("The element is not available within 10 seconds").
                ignoreExceptions().
                pollInterval(1, TimeUnit.SECONDS).
                atMost(10, TimeUnit.SECONDS).
                until(element::isDisplayed, is(true));
    }
}
