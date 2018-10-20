package trivago.base7.challenge.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trivago.base7.challenge.objectRepository.LoginObjects;

import static org.junit.Assert.assertNotNull;

/**
 * Class to validate the features corresponding to login
 */
public class LoginSteps extends BaseStep {

    @FindBy(how = How.XPATH, using = LoginObjects.USER_NAME)
    private WebElement loginEmail;

    @FindBy(how = How.XPATH, using = LoginObjects.PASSWORD)
    private WebElement loginPassword;

    @FindBy(how = How.XPATH, using = LoginObjects.LOGIN)
    private WebElement loginButton;

    @After
    public void cleanUp() {
        chromeDriver.close();
    }

    /**
     * Method to load the dashboard
     */
    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        openBrowser();
        PageFactory.initElements(chromeDriver, this);
        chromeDriver.get(getPropertyValue("dashboardUrl"));
    }

    /**
     * Method to enter the user name
     */
    @When("^I enter valid user name$")
    public void iEnterValidUserName() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(this.loginEmail));
        this.loginEmail.sendKeys(getPropertyValue("email"));
    }

    /**
     * Method to enter the password
     */
    @And("^I enter valid password$")
    public void iEnterValidPassword() {
        this.loginPassword.sendKeys(getPropertyValue("password"));
    }


    /**
     * Method to click on sign in
     */
    @And("^I click on Sign In$")
    public void iClickOnSignIn() {
        this.loginButton.click();
    }

    /**
     * Method to validate the loaded home page for the user
     */
    @Then("^I should be able to see my reservations page$")
    public void iShouldBeAbleToSeeMyReservationsPage() {
        explicitWait(3000);
        WebElement calendar = chromeDriver.findElement(By.xpath(LoginObjects.CALENDAR_CONTENT));
        assertNotNull(calendar);
    }
}
