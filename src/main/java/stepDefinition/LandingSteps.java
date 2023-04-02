package stepDefinition;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LandingScreen;
import pages.PageFactoryManager;

public class LandingSteps
{
    LandingScreen landingScreen;

    public LandingSteps(TestContext context)
    {
        landingScreen = PageFactoryManager.getLandingScreen(context.driver);
    }

    @When("^I select (.*) country from the dropdown$")
    public void iSelectCountryFromTheDropdown(String country)
    {
        landingScreen.selectingText(country);
    }

    @And("^I enter (.*) in the text field$")
    public void iEnterNameInTheTextField(String name) throws InterruptedException {
        landingScreen.enteringName(name);
    }

    @And("I click lets shop button")
    public void iClickLetsShopButton() throws InterruptedException {
        landingScreen.clickLetsShopButton();
    }
}
