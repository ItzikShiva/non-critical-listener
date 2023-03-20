package non.critical.listener.connectors;

//import non.critical.AzureBaseBugTests.AzureBaseBugTests;
import non.critical.listener.NonCriticalListener;
import non.critical.listener.tfs.api.BugService;
import non.critical.listener.tfs.api.getbugresponse.GetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class TfsConnector implements Connector {
    public static BugService bugService = new BugService();

    @Override
    public boolean isBugOpen(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return false;
        }

        GetBugResponse getBugResponse = responseToObject(response, GetBugResponse.class);

        return getBugResponse.getFields().getSystemState().equals("Active") || getBugResponse.getFields().getSystemState().equals("New");
    }

    @Override
    public NonCriticalListener.BugStatus getBugStatus(String bugId){
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return null;
        }

        GetBugResponse getBugResponse = responseToObject(response, GetBugResponse.class);
        String bugStatus = getBugResponse.getFields().getSystemState();
        switch (bugStatus) {
            case "Active":
                return NonCriticalListener.BugStatus.ACTIVE;
            case "Closed":
                return NonCriticalListener.BugStatus.CLOSED;
            case "Resolved":
                return NonCriticalListener.BugStatus.RESOLVED;
            case "New":
                return NonCriticalListener.BugStatus.NEW;
            default:
                return null;
        }
    }

}