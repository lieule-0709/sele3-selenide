package steps.parallel;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefs {

    private static final Logger log = LoggerFactory.getLogger(StepDefs.class);

    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        String info = "Thread ID - %2d - %s from %s feature file.\n".formatted(Thread.currentThread().getId(), scenario, file);
        log.info(info);
    }
}