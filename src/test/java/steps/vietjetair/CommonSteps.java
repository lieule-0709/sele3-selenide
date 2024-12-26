package steps.vietjetair;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import objects.vietjet.BookingInfo;
import objects.vietjet.Passengers;
import objects.vietjet.Person;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    @When("I open vietjetair home page")
    public void openHomePage() {
        open("https://www.vietjetair.com/en/");
    }

    @Given("trades with the following details are created:")
    public void tradeWithTheFollowingDetailsAreCreated(DataTable dataTable) {
        // transpose - transposes the table from the feature file
        // asList - creates a `List<Trade>`
//        List<Trade> list = dataTable.transpose().asList(Trade.class);
//        list.stream().forEach(System.out::println);

        // Use the transpose method to swap rows and columns
        DataTable transposedTable = dataTable.transpose();

        // Convert the transposed data to a List of Maps
        List<Map<String, String>> transposedRows = transposedTable.asMaps(String.class, String.class);

        for (Map<String, String> row : transposedRows) {
            String name = row.get("name");
            String age = row.get("age");
            String location = row.get("location");

            // Create a Person object or use the data as needed
            Person person = new Person(name, age, location);
            System.out.println(person);
        }

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
            BookingInfo bookingInfo = new BookingInfo(row.get("from"), row.get("to"), row.get("fromDate"), row.get("toDate"));
            System.out.println(ReflectionToStringBuilder.toString(bookingInfo));
        }

    }

}
