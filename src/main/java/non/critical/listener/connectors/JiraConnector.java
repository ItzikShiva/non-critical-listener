package non.critical.listener.connectors;

import non.critical.listener.BugStatus;
import non.critical.listener.Configure;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.DefaultBugService;
import non.critical.listener.jira.api.getbugresponse.JiraGetBugResponse;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class JiraConnector implements Connector {
    private static final Logger logger = LogManager.getLogger(Connector.class);

    public static BugService bugService = new DefaultBugService();

    @Override
    public BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            logger.warn("something wrong in the ticket system properties. please check the properties in config file");
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
