package stepDefinition;

import context.TestContext;
import factory.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static factory.DriverFactory.initializeDriver;

public class Hooks
{

    private AndroidDriver<WebElement> driver;

    private final TestContext context;

    public Hooks(TestContext context)
    {
        this.context = context;
    }


    @Before
    public void before() throws MalformedURLException {

        driver = initializeDriver();
        context.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after()
    {
        driver.quit();
    }


}
