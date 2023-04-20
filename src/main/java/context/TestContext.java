package context;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import pages.LandingScreen;

public class TestContext
{
    public AndroidDriver<WebElement> driver;

    public IOSDriver<WebElement> driver1;

    public LandingScreen landingScreen;
}
