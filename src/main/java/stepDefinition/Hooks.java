package stepDefinition;

import context.TestContext;
import factory.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static factory.DriverFactory.*;
import static pages.baseMethods.getDataProperties;

public class Hooks
{

//    private AndroidDriver<WebElement> driver;
//
//    private IOSDriver<WebElement> driver;

    private final TestContext context;

    public Hooks(TestContext context)
    {
        this.context = context;
    }

    String path = "src/main/resources/TestData/Runner.properties";


    @Before
    public void before() throws IOException {

        if(getDataProperties(path,"DeviceType").equalsIgnoreCase("iOS"))
        {
            IOSDriver<WebElement> driver = IOSinitializeDriver();
            context.driver1 = driver;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else
        {
            AndroidDriver<WebElement> driver = AndroidinitializeDriver();
            context.driver = driver;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }

//    @After
//    public void after()
//    {
//        driver.quit();
//    }


}
