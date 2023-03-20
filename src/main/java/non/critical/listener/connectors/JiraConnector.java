package non.critical.listener.connectors;

import non.critical.listener.NonCriticalListener;
import non.critical.listener.jira.api.IssueService;
import non.critical.listener.jira.api.getissueresponse.GetIssueResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class JiraConnector implements Connector {
    public static IssueService issueService = new IssueService();


    @Override
    public boolean isBugOpen(String issueKey) {
        Response response = issueService.getIssue(issueKey);

        if (response.code() != 200) {
            return false;
        }

        GetIssueResponse getIssueResponse = responseToObject(response, GetIssueResponse.class);

        return getIssueResponse.getFields().getResolution() == null;
    }

    @Override
    public NonCriticalListener.BugStatus getBugStatus(String bugId) {
//        Response response = bugService.getBug(bugId);

//        if (response.code() != 200) {
//            return null;
//        }
//
//        GetBugResponse getBugResponse = responseToObject(response, GetBugResponse.class);
//        String bugStatus = getBugResponse.getFields().getSystemState();
//        switch (bugStatus) {
//            case "Active":
//                return NonCriticalListener.BugStatus.Active;
//            case "Closed":
//                return NonCriticalListener.BugStatus.Closed;
//            case "Resolved":
//                return NonCriticalListener.BugStatus.Resolved;
//            case "New":
//                return NonCriticalListener.BugStatus.New;
//            default:
        return null;
    }
}
