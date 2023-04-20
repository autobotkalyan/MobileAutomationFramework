package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class PageFactoryManager
{
    private static LandingScreen landingScreen;

    private static PickerWheelScreen pickerWheelScreen;

    public static LandingScreen getLandingScreen(AndroidDriver<WebElement> driver)
    {
        return landingScreen == null ? new LandingScreen(driver): landingScreen;
    }

    public static PickerWheelScreen getPickerWheelScreen(IOSDriver<WebElement> driver)
    {
        return pickerWheelScreen == null ? new PickerWheelScreen(driver): pickerWheelScreen;
    }

}
