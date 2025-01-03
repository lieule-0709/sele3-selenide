package utils.logAndReportUtils;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void beforeScenario() {
        Selenide.open();
    }

    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }

}
