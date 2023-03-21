package non.critical.listener.connectors;


import non.critical.listener.NonCriticalListener;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.TfsBugService;
import non.critical.listener.tfs.api.getbugresponse.TfsGetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class TfsConnector implements Connector {
    public static BugService bugService = new TfsBugService();

    @Override
    public NonCriticalListener.BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return null;
        }

        TfsGetBugResponse getBugResponse = responseToObject(response, TfsGetBugResponse.class);
//        TfsGetBugResponse getBugResponse = getBugResponse(response);
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

//    public GetBugResponse getBugResponse(Response response) {
//        String source = "Tfs"; // or "TFS"
//
//        if (source.equals("JIRA")) {
//            return responseToObject(response, JiraGetBugResponse.class);
//        } else {
//            return responseToObject(response, TfsGetBugResponse.class);
//        }
//    }

}