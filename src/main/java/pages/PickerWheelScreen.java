package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.HashMap;
import java.util.Map;

import static pages.baseMethods.waitForElement;

public class PickerWheelScreen
{
    IOSDriver<WebElement> driver;

    public PickerWheelScreen(IOSDriver<WebElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //Clicking Select
    @iOSXCUITFindBy(id="Picker View")
     WebElement btn_pickerView;



    public void pickValuesFromWheel()
    {

        btn_pickerView.click();

        boolean flag = false;

        while(!flag) {
            WebElement redPickerWheel = driver.findElementByIosNsPredicate("label == \"Red color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(redPickerWheel.getText().equals("100"))
            {
                flag = true;
            }
        }

        flag = false;

        while(!flag) {
            WebElement greenPickerWheel = driver.findElementByIosNsPredicate("label == \"Green color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) greenPickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(greenPickerWheel.getText().equals("150"))
            {
                flag = true;
            }
        }

        flag = false;

        while(!flag) {
            WebElement bluePickerWheel = driver.findElementByIosNsPredicate("label == \"Blue color component value\"");

            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) bluePickerWheel).getId());

            driver.executeScript("mobile: selectPickerWheelValue", params);

            if(bluePickerWheel.getText().equals("200"))
            {
                flag = true;
            }
        }
    }

}
