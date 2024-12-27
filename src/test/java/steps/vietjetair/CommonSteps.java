package steps.vietjetair;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import objects.vietjet.BookingInfo;
import objects.vietjet.Passengers;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pages.vietjet.HomePage;
import utils.ScenarioContext;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    private ScenarioContext scenarioContext;

    public CommonSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("I open vietjetair home page")
    public void openHomePage() {
        open("https://www.vietjetair.com/en/");
        HomePage homePage = new HomePage();
        homePage.acceptCookiesAndClosePopUp();
    }

    @Given("booking info:")
    public void createBookingInfo(DataTable dataTable) {
        // Use the transpose method to swap rows and columns
        DataTable transposedTable = dataTable.transpose();

        // Convert the transposed data to a List of Maps
        List<Map<String, String>> transposedRows = transposedTable.asMaps(String.class, String.class);

        for (Map<String, String> row : transposedRows) {
            Passengers passengers = new Passengers.Builder().setAdults(Integer.parseInt(row.get("adults"))).build();

            // Create a Person object or use the data as needed
            BookingInfo bookingInfo = new BookingInfo(row.get("from"), row.get("to"),
                    Integer.parseInt(row.get("fromDate")), Integer.parseInt(row.get("toDate")));
            System.out.println(ReflectionToStringBuilder.toString(bookingInfo));
            scenarioContext.setContext("bookingInfo", bookingInfo);
        }

    }

}
