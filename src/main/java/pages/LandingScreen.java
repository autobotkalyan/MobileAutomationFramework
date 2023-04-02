package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import static pages.baseMethods.waitForElement;

public class LandingScreen extends AndroidActions
{
    AndroidDriver<WebElement> driver;

    public LandingScreen(AndroidDriver<WebElement> driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //Clicking Select
    @AndroidFindBy(id="android:id/text1")
    WebElement btn_SelectComboBox;

    //Text name field
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    WebElement txt_Name;

    //Radio button
    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    WebElement rdo_genderMale;

    //Radio button
    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    WebElement rdo_genderFeMale;

    //Lets Shop button
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    WebElement btn_LetsShop;


    public void enteringName(String name)
    {
        txt_Name.sendKeys(name);
    }

    public void selectGender(String option)
    {
        if(option.equalsIgnoreCase("male"))
        {
            this.rdo_genderMale.click();
        }
        else
        {
            this.rdo_genderFeMale.click();
        }
    }
    public void clickLetsShopButton()
    {
        waitForElement(btn_LetsShop);
        btn_LetsShop.click();
    }

    public void selectingText(String country)
    {
        btn_SelectComboBox.click();
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\""+country+"\").instance(0))").click();
    }


}
