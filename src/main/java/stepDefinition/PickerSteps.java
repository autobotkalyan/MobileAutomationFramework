package stepDefinition;

import com.codoid.products.exception.FilloException;
import com.github.javafaker.Faker;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LandingScreen;
import pages.PageFactoryManager;
import pages.PickerWheelScreen;

import static pages.baseMethods.readXL;

public class PickerSteps
{
    PickerWheelScreen pickerWheelScreen;
    Faker faker = new Faker();

    public PickerSteps(TestContext context)
    {
        pickerWheelScreen = PageFactoryManager.getPickerWheelScreen(context.driver1);
    }

    @When("^I perform operations in pickerwheel$")
    public void iSelectCountryFromTheDropdown() throws FilloException {
        pickerWheelScreen.pickValuesFromWheel();
    }

}
