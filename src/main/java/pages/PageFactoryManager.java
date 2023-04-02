package pages;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class PageFactoryManager
{
    private static LandingScreen landingScreen;

    public static LandingScreen getLandingScreen(AndroidDriver<WebElement> driver)
    {
        return landingScreen == null ? new LandingScreen(driver): landingScreen;
    }

}
