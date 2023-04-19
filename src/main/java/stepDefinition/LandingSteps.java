package stepDefinition;

import com.codoid.products.exception.FilloException;
import com.github.javafaker.Faker;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LandingScreen;
import pages.PageFactoryManager;

import static pages.baseMethods.readXL;

public class LandingSteps
{
    LandingScreen landingScreen;
    Faker faker = new Faker();

    public LandingSteps(TestContext context)
    {
        landingScreen = PageFactoryManager.getLandingScreen(context.driver);
    }

    @When("^I select country from the dropdown for (.*)$")
    public void iSelectCountryFromTheDropdown(String testCase) throws FilloException {
        landingScreen.selectingText(readXL(testCase,"Country"));
    }

    @And("^I enter Name in the text field$")
    public void iEnterNameInTheTextField() throws InterruptedException {
        landingScreen.enteringName(faker.name().fullName());
    }

    @And("I click lets shop button")
    public void iClickLetsShopButton() throws InterruptedException {
        landingScreen.clickLetsShopButton();
    }
}
