package trivago.base7.challenge.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import trivago.base7.challenge.objectRepository.RestrictionObjects;

import static org.junit.Assert.assertNotNull;

/**
 * Class to validate the Restrictions
 */
public class RestrictionSteps extends BaseStep {

    @FindBy(how = How.XPATH, using = RestrictionObjects.SETTINGS_TAB)
    private WebElement settingsTab;

    /**
     * Default constructor
     */
    public RestrictionSteps() {
        PageFactory.initElements(chromeDriver, this);
    }

    /**
     * Method to click on the settings
     */
    @When("^I click on Settings$")
    public void iClickOnSettings() {
        explicitWait(4000);
        settingsTab.click();
    }

    /**
     * Method to click on the accomodations
     */
    @And("^I click on Accomodations$")
    public void iClickOnAccomodations() {
        explicitWait(4000);
        chromeDriver.findElement(By.xpath(RestrictionObjects.ACCOMADATIONS_TAB)).click();
    }

    /**
     * Method to click on the reservations tab
     */
    @And("^I click on Restrictions$")
    public void iClickOnRestrictions() {
        explicitWait(2000);
        chromeDriver.findElement(By.xpath(RestrictionObjects.RESTRICTIONS_TAB)).click();
    }

    /**
     * Method to validate the information shown for restrictions
     */
    @Then("^I should see the price table$")
    public void iShouldSeeThePriceTable() {
        explicitWait(4000);
        assertNotNull(chromeDriver.findElement(By.xpath(RestrictionObjects.PRICE_TABLE)));
    }
}
