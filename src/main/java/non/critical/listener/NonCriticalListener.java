package non.critical.listener;

import non.critical.listener.connectors.Connector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class NonCriticalListener implements IInvokedMethodListener {
    private static final Logger logger = LogManager.getLogger(NonCriticalListener.class);
    private final Connector connector;

    /**
     * this constructor called from by annotation:  @Listeners(NonCriticalListener.class)
     * from testNG library: import org.testng.annotations.Listeners; in the test file that use the @NonCriticalListener
     */
    public NonCriticalListener() {
        Configure config = new Configure();
        this.connector = config.getConnector();
    }

    private BugStatus getBugStatus(String bugId) {
        return this.connector.getBugStatus(bugId);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(NonCritical.class)) {

            String bugId = method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(NonCritical.class).bugId();
            logger.info("start non-critical-listener, with bug id: " + bugId);
            if (testResult.getStatus() == ITestResult.SUCCESS) {
                handleSuccessfulTest(testResult, bugId);
            } else {
                handleFailureTest(testResult, bugId);
            }
        }
    }

    private void handleSuccessfulTest(ITestResult testResult, String bugId) {
        BugStatus bugStatus = getBugStatus(bugId);

        switch (bugStatus) {
            case ACTIVE:
            case NEW:
            case TO_DO:
            case IN_PROGRESS:
                logger.error("Test passed, but a related bug (" + bugId + ") is still open. Please resolve the bug and re-run the test.");
                testResult.setStatus(ITestResult.FAILURE);
                break;
            case CLOSED:
            case DONE:
                logger.warn("Test passed and related bug (" + bugId + ") is closed. Removing unneeded annotation from test.");
                break;
            case RESOLVED:
                logger.error("Test passed, but a related bug (" + bugId + ") is marked as resolved. Please close the bug and remove the @NonCritical annotation from the test.");
                testResult.setStatus(ITestResult.FAILURE);
                break;
        }
    }

    private void handleFailureTest(ITestResult testResult, String bugId) {
        BugStatus bugStatus = getBugStatus(bugId);

        switch (bugStatus) {
            case ACTIVE:
            case NEW:
            case TO_DO:
                logger.error("test originally was failed. BUG with: " + bugId + " already open. test was skipped");
                testResult.setStatus(ITestResult.SKIP);
                break;
            case CLOSED:
            case DONE:
                logger.error("Test failed and related bug (" + bugId + ") is closed/done. Investigation is required for the related bug (" + bugId + ").");
                break;
            case RESOLVED:
                logger.warn("Test failed, but a related bug (" + bugId + ") is marked as resolved. Please verify that the bug has been properly resolved.");
                break;
        }
    }


}