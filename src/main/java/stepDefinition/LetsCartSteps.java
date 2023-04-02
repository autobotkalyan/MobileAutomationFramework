/*
package stepDefinition;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LetsCartSteps
{
    AndroidDriver<WebElement> driver;

    @Given("I am on Lets Cart Application")
    public void iamonletsCartApplication() throws MalformedURLException {

    }

    @When("^I select (.*) country from the dropdown$")
    public void iSelectCountryFromTheDropdown(String country)
    {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\""+country+"\").instance(0))").click();
    }


    @And("^I enter (.*) in the text field$")
    public void iEnterNameInTheTextField(String name)
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
    }

    @And("I click lets shop button")
    public void iClickLetsShopButton()
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

    @Then("I am on Products screen")
    public void iAmOnProductsScreen()
    {
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"Jordan 6 Rings\").instance(0))");

    }

    @And("I quit the application")
    public void iQuitTheApplication()
    {
        driver.quit();
    }

    @And("^I am selecting the item (.*)$")
    public void iAmSelectingTheItems(String item) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='"+item+"']/following::android.widget.TextView[2]")).click();

        //Thread.sleep(2000);

        //driver.findElementByAndroidUIAutomator
         //       ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"Jordan 6 Rings\").instance(0))");

        //driver.findElement(By.xpath("//*[@text='Jordan 6 Rings']/following::android.widget.TextView[2]")).click();
    }

    @Then("I click cart button")
    public void iClickCartButton()
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    @And("I click the checkbox")
    public void iClickTheCheckbox()
    {
        WebElement longPressbtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

        //.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)longPressbtn).getId(),"duration",2000));

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
    }

    @Then("I click visit the website button")
    public void iClickVisitTheWebsiteButton()
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }
}
*/
