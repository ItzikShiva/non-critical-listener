package non.critical.listener.connectors;


import non.critical.listener.BugStatus;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.DefaultBugService;
import non.critical.listener.tfs.api.getbugresponse.TfsGetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class TfsConnector implements Connector {
    public static BugService bugService = new DefaultBugService();

    @Override
    public BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return null;
        }

        TfsGetBugResponse getBugResponse = responseToObject(response, TfsGetBugResponse.class);
        String bugStatus = getBugResponse.getFields().getSystemState();

        switch (bugStatus) {
            case "Active":
                return BugStatus.ACTIVE;
            case "Closed":
                return BugStatus.CLOSED;
            case "Resolved":
                return BugStatus.RESOLVED;
            case "New":
                return BugStatus.NEW;
            default:
                return null;
        }
    }
}