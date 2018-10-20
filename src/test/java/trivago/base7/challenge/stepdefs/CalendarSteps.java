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
import trivago.base7.challenge.objectRepository.CalendarObjects;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Class to implement the features corresponding to the Calendar
 */
public class CalendarSteps extends BaseStep {

    @FindBy(how = How.XPATH, using = CalendarObjects.CALENDAR_START_DATE)
    private WebElement calendarStartDate;

    @FindBy(how = How.XPATH, using = CalendarObjects.CALENDAR_END_DATE)
    private WebElement calendarEndDate;

    /**
     * Default constructor
     */
    public CalendarSteps() {
        PageFactory.initElements(chromeDriver, this);
    }

    /**
     * Method to select a start date from the calendar
     *
     * @param startDate date value to be selected
     */
    @When("^I click on a (.*) and select a day from calendar$")
    public void iClickOnAStartDateButtonAndEndDateButton(String startDate) {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(calendarStartDate));
        calendarStartDate.click();

        WebElement calendarElement = chromeDriver.findElement(By.xpath(CalendarObjects.DATE_PICKER));
        wait.until(ExpectedConditions.visibilityOf(calendarElement));
        chromeDriver.findElement(By.xpath(CalendarObjects.DAY + startDate.split(" ")[1] + "]")).click();
    }


    /**
     * Method to select an end date from the calendar
     *
     * @param endDate date value to be selected
     */
    @And("^I click on an (.*) and select an end day from calendar$")
    public void iClickOnAnEndDateAndSelectAnEndDayFromCalendar(String endDate) {
        calendarEndDate.click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 15);
        WebElement calendarElement = chromeDriver.findElement(By.xpath(CalendarObjects.DATE_PICKER));
        wait.until(ExpectedConditions.visibilityOf(calendarElement));

        chromeDriver.findElement(By.xpath(CalendarObjects.DAY + endDate.split(" ")[1] + "]")).click();
    }

    /**
     * Method to validate the reservation that is displayed for the selected start date and end date
     *
     * @param startDate start date selected from the calendar
     * @param endDate   end date selected from the calendar
     */
    @Then("^the reservations should be displayed for the selected (.*) and (.*)")
    public void theReservationsShouldBeDisplayedForTheSelectedDates(String startDate, String endDate) {
        String monthAndYearFromGrid = chromeDriver.findElement(By.xpath(CalendarObjects.MONTH_IN_GRID)).getText();
        WebElement gridDates = null;
        List<WebElement> gridDateValues = null;
        String[] monthAndYearValuesInGrid = monthAndYearFromGrid.split(" ");
        String monthInGrid = monthAndYearValuesInGrid[1];

        assertEquals(startDate.split(" ")[0], monthInGrid);

        gridDates = chromeDriver.findElement(By.xpath(CalendarObjects.GRID_BODY_DATES));
        gridDateValues = gridDates.findElements(By.xpath("div[contains(@id,'col')]"));

        explicitWait(5);

        String startDateGrid = gridDateValues.get(1).getText().trim();
        String endDateGrid = gridDateValues.get(gridDateValues.size() - 1).getText();
        assertEquals(startDate.split(" ")[1], startDateGrid);
        assertEquals(endDate.split(" ")[1], endDateGrid);
    }
}
