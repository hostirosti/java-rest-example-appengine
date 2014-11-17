package hostirosti;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.logging.Logger;

public class JavaRESTExampleTestBase {

    protected static final Logger TEST_RESULTS_LOGGER = Logger.getLogger(JavaRESTExampleTestBase.class.getName());

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            TEST_RESULTS_LOGGER.info(
                    String.format("Runnning Test: %s() - %s() ...", description.getClassName(), description.getMethodName()));
        };

        @Override
        protected void finished(Description description) {
            TEST_RESULTS_LOGGER.info(
                    String.format("Finished Test: %s() - %s()", description.getClassName(), description.getMethodName()));
        }
    };
}
