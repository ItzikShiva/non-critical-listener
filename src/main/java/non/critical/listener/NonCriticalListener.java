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
        this.connector = config.getBugTracker();
    }

    private boolean isBugOpen(String issueKey) {
        return this.connector.isBugOpen(issueKey);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(NonCritical.class)) {

            NonCritical annotation = method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(NonCritical.class);
            String bugKey = annotation.bugKey();

            if (testResult.getStatus() == ITestResult.SUCCESS) {
                caseTestSuccess(testResult, bugKey);
            } else {
                caseTestFailed(testResult, bugKey);
            }
        }
    }

    private void caseTestSuccess(ITestResult testResult, String bugKey) {
        if (isBugOpen(bugKey)) {
            logger.error("test originally was passed. and BUG with: " + bugKey + " is open. please close that bug!");
            testResult.setStatus(ITestResult.FAILURE);
        } else {
            logger.warn("remove unneeded annotation from this test");
        }
    }

    private void caseTestFailed(ITestResult testResult, String bugKey) {
        if (isBugOpen(bugKey)) {
            logger.error("test originally was failed. BUG with: " + bugKey + " already open. test was skipped");
            testResult.setStatus(ITestResult.SKIP);
        } else {
            logger.error("investigation for the test and bug: " + bugKey + " required!");
        }
    }


}