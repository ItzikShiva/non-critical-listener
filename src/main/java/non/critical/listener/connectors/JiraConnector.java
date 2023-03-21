package non.critical.listener.connectors;

import non.critical.listener.NonCriticalListener;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.JiraBugService;
import non.critical.listener.jira.api.getbugresponse.JiraGetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class JiraConnector implements Connector {
    public static BugService bugService = new JiraBugService();


    @Override
    public NonCriticalListener.BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return null;
        }

        JiraGetBugResponse getBugResponse = responseToObject(response, JiraGetBugResponse.class);
        String bugStatus = getBugResponse.getFields().getStatus().getName();

        switch (bugStatus) {
            case "To Do":
                return NonCriticalListener.BugStatus.TO_DO;
            case "Done":
                return NonCriticalListener.BugStatus.DONE;
            case "In Progress":
                return NonCriticalListener.BugStatus.IN_PROGRESS;
            default:
                return null;
        }
    }
}
