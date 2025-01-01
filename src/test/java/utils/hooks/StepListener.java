package utils.hooks;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
            //take screenshot and add to rp
        }

    }

    @Override
    public void afterStepStop(StepResult result) {
        log.info("[Step]: {} ended", result.getName());
    }

}
