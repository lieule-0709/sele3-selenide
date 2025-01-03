package utils.logAndReportUtils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static utils.DateTimeHelper.currentDateTime;


public class StepListener implements StepLifecycleListener {

    private static final Logger log = LoggerFactory.getLogger(StepListener.class);

    @Override
    public void beforeStepStart(StepResult result) {
        log.info("[Step]: {} is starting", result.getName());
    }

    @Override
    public void beforeStepStop(final StepResult result) {

        if (result.getStatus() == null || result.getStatus().equals(Status.FAILED) || result.getStatus().equals(Status.BROKEN)) {
            log.info("[Failed]: Taking screenshot...");
            //take screenshot in build/reports/tests folder for debug purpose
            Selenide.screenshot("currentDateTime");
            //take screenshot and add to report
            ByteArrayInputStream screenshotAsBase64 = new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES));
            Allure.addAttachment(String.format("Screenshot %s", currentDateTime()), screenshotAsBase64);
        }

    }

    @Override
    public void afterStepStop(StepResult result) {
        log.info("[Step]: {} ended", result.getName());
    }

}
