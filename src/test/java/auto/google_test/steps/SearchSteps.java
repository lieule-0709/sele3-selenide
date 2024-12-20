package auto.google_test.steps;

import auto.google_test.pages.GooglePage;
import auto.google_test.pages.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SearchSteps {
    @When("I open duckduck page")
    public void openDuckDuckPage() {
        open("https://duckduckgo.com");
    }

    @When("I search for selenide")
    public void search() {
        new GooglePage().searchFor("selenide java");
    }

    @Then("check the results page")
    public void checkResultsPage() {
        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
