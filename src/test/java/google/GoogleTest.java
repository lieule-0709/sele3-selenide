package google;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
  private static final Logger log = LoggerFactory.getLogger(GoogleTest.class);

  @Test
  public void userCanSearch() {
    log.info("Searching for user");
    open("https://duckduckgo.com");
    new GooglePage().searchFor("selenide java");

    SearchResultsPage results = new SearchResultsPage();
    results.getResults().shouldHave(sizeGreaterThan(1));
    results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
  }
}
