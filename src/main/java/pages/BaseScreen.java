package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class BaseScreen
{
    //Instance Variable
    AndroidDriver driver;

    //Constructor
    public BaseScreen(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static void waitForElement(WebElement element)
    {
        await("The element is not available within 10 seconds").
                ignoreExceptions().
                pollInterval(1, TimeUnit.SECONDS).
                atMost(10, TimeUnit.SECONDS).
                until(element::isDisplayed, is(true));
    }
}
