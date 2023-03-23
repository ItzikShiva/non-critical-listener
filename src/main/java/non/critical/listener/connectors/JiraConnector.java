package non.critical.listener.connectors;

import non.critical.listener.BugStatus;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.DefaultBugService;
import non.critical.listener.jira.api.getbugresponse.JiraGetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class JiraConnector implements Connector {
    public static BugService bugService = new DefaultBugService();

    @Override
    public BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return null;
        }

        JiraGetBugResponse getBugResponse = responseToObject(response, JiraGetBugResponse.class);
        String bugStatus = getBugResponse.getFields().getStatus().getName();

        switch (bugStatus) {
            case "To Do":
                return BugStatus.TO_DO;
            case "Done":
                return BugStatus.DONE;
            case "In Progress":
                return BugStatus.IN_PROGRESS;
            default:
                return null;
        }
    }
}
