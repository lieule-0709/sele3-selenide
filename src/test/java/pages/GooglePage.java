package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GooglePage {
  private SelenideElement searchField = $(byName("q"));

  public void searchFor(String text) {
    searchField.val(text).pressEnter();
  }
}
