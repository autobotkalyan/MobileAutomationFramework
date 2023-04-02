package context;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import pages.LandingScreen;

public class TestContext
{
    public AndroidDriver<WebElement> driver;

    public LandingScreen landingScreen;
}
