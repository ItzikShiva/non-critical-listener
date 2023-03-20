package non.critical;

import non.critical.listener.NonCritical;
import non.critical.listener.NonCriticalListener;
import non.critical.listener.jira.api.IssueService;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static non.critical.IssueConstants.CLOSED_BUG_KEY;
import static non.critical.IssueConstants.OPEN_BUG_KEY;

@Listeners(NonCriticalListener.class)
public class JiraGetIssueTests {
    public static IssueService issueService = new IssueService();
//    @BeforeClass
//    public static void login() {
//        apiService.login();
//    }

    @NonCritical(bugKey = CLOSED_BUG_KEY)
    @Test
    public static void failedTestAndClosedBug() {
        Assert.assertEquals(0, 1, "test failed. bug id: " + CLOSED_BUG_KEY);
    }

    @NonCritical(bugKey = OPEN_BUG_KEY)
    @Test
    public static void failedTestAndOpenBug() {
        Assert.assertEquals(0, 1, "test failed. bug id: " + OPEN_BUG_KEY);
    }

    @NonCritical(bugKey = CLOSED_BUG_KEY)
    @Test
    public static void PassedTestAndClosedBug() {
        Assert.assertEquals(0, 0, "test passed. bug id: " + CLOSED_BUG_KEY);
    }

    @NonCritical(bugKey = OPEN_BUG_KEY)
    @Test
    public static void PassedTestAndOpenBug() {
        Assert.assertEquals(0, 0, "test passed. bug id: " + OPEN_BUG_KEY);
    }

}
