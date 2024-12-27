package steps.vietjetair;

import io.cucumber.java.en.Then;
import objects.vietjet.BookingInfo;
import pages.vietjet.HomePage;
import utils.ScenarioContext;

public class FillBookingInfoSteps {
    private ScenarioContext scenarioContext;

    public FillBookingInfoSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("I fill the booking info")
    public void fillBookingInfo() {
        HomePage homePage = new HomePage();
        homePage.fillBookingInfo((BookingInfo) scenarioContext.getContext("bookingInfo"));
    }
}
