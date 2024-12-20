package auto.google_test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
  private final ElementsCollection results = $$("[data-testid=\"result\"]");

  public SelenideElement getResult(int index) {
    return results.get(index);
  }
  
  public ElementsCollection getResults() {
    return results;
  }
}
