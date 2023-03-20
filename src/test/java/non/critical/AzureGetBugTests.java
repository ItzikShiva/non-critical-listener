package non.critical;

import non.critical.listener.NonCriticalListener;
import non.critical.listener.azure.api.BugService;
import non.critical.listener.azure.api.getbugresponse.GetBugResponse;
import non.critical.listener.NonCritical;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static non.critical.BugConstants.VALID_BUG_ID;
import static non.critical.APIUtils.responseToObject;
import static non.critical.IssueConstants.OPEN_BUG_KEY;

@Listeners(NonCriticalListener.class)
public class AzureGetBugTests  {
    public static BugService bugService = new BugService();
//TODO - make bug keys/ids constants

//    @NonCritical(bugKey = CLOSED_BUG_KEY)
    @NonCritical(bugKey = "2")
    @Test
    public static void failedTestAndClosedBug() {
        Assert.assertEquals(0, 1,"test failed. bug id: 2");
    }

    @NonCritical(bugKey = "1")
//    @NonCritical(bugKey = OPEN_BUG_KEY)
    @Test
    public static void failedTestAndOpenBug() {
        Assert.assertEquals(0, 1,"test failed. bug id: 1");
    }

    @NonCritical(bugKey = "2")
//    @NonCritical(bugKey = CLOSED_BUG_KEY)
    @Test
    public static void PassedTestAndClosedBug() {
        Assert.assertEquals(0, 0,"test passed. bug id: 2");
    }


    @NonCritical(bugKey = "1")
//    @NonCritical(bugKey = OPEN_BUG_KEY)
    @Test
    public static void PassedTestAndOpenBug() {
        Assert.assertEquals(0, 0,"test passed. bug id: 1");
    }




//regular getBug Test
    @Test
    public static void getBug() {

        Response response = bugService.getBug(BugConstants.VALID_BUG_ID);
        Assert.assertEquals(response.code(), 200);
        GetBugResponse getBugResponse = APIUtils.responseToObject(response, GetBugResponse.class);
        Assert.assertEquals(BugConstants.VALID_BUG_ID, "" + getBugResponse.getId());
//        logger.info("got work-item with id: " + VALID_WORKITEM_ID);
    }
}
