package trivago.base7.challenge.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trivago.base7.challenge.objectRepository.ReservationObjects;

import static junit.framework.TestCase.assertEquals;

/**
 * Class to implement the methods corresponding to the Reservations feature
 */
public class ReservationSteps extends BaseStep {

    @FindBy(how = How.XPATH, using = ReservationObjects.RESERVATIONS_PAGE)
    private WebElement reservationTab;

    /**
     * Default constructor
     */
    public ReservationSteps() {
        PageFactory.initElements(chromeDriver, this);
    }

    /**
     * Method to click on the Reservations tab
     */
    @When("^I click on reservations tab$")
    public void iClickOnReservationsTab() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(reservationTab));

        reservationTab.click();
    }

    /**
     * Method to click on the first reservation
     */
    @And("^I select the first reservation details$")
    public void iSelectTheFirstStReservationDetails() {
        explicitWait(8000);
        WebElement firstReservation = chromeDriver.findElement(By.xpath(ReservationObjects.FIRST_RESERVATION));
        firstReservation.click();

    }

    /**
     * Method to validate the clicked reservation
     *
     * @param name Name of the person who made the reservation
     */
    @Then("^I should see the reservation name \"([^\"]*)\"$")
    public void iShouldSeeTheReservationName(String name) {
        explicitWait(5000);
        WebElement reservationName = chromeDriver.findElement(By.xpath(ReservationObjects.RESERVATION_NAME));
        String actualName = reservationName.getText().trim();
        assertEquals(name.toLowerCase(), actualName.toLowerCase());
    }
}
