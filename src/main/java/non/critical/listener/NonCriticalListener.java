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

    private BugStatus getBugStatus(String issueKey) {
        return this.connector.getBugStatus(issueKey);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(NonCritical.class)) {

//            NonCritical annotation = ;
            String bugKey = method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(NonCritical.class).bugKey();

            if (testResult.getStatus() == ITestResult.SUCCESS) {
                handleSuccessfulTest(testResult, bugKey);
            } else {
                handleFailureTest(testResult, bugKey);
            }
        }
    }

    /**
     * please do this best practice (think about the log level also)
     * and  please write me something correct and good looking english for the log also
     */
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
                logger.info("Test passed and related bug (" + bugId + ") is closed. Removing unneeded annotation from test.");
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
                logger.error("test originally was failed. BUG with: " + bugId + " already open. test was skipped");
                testResult.setStatus(ITestResult.SKIP);
                break;
            case CLOSED:
                logger.error("Test failed and related bug (" + bugId + ") is closed. Investigation is required for the related bug (" + bugId + ").");
                break;
            case RESOLVED:
                logger.warn("Test failed, but a related bug (" + bugId + ") is marked as resolved. Please verify that the bug has been properly resolved.");
                break;
        }
    }

    public enum BugStatus {
        ACTIVE, CLOSED, RESOLVED, NEW, DONE, TO_DO, IN_PROGRESS
    }


}