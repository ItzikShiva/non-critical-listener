package non.critical.listener.connectors;


import non.critical.listener.BugStatus;
import non.critical.listener.bugservice.BugService;
import non.critical.listener.bugservice.DefaultBugService;
import non.critical.listener.tfs.api.getbugresponse.TfsGetBugResponse;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class TfsConnector implements Connector {
    private static final Logger logger = LogManager.getLogger(Connector.class);

    public static BugService bugService = new DefaultBugService();

    @Override
    public BugStatus getBugStatus(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            logger.warn("something wrong in the ticket system properties. please check the properties in config file.");
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