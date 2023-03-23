package non.critical.listener.bugservice;


import non.critical.listener.BugStatus;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CostumBugService implements BugService {
    private static final Logger logger = LogManager.getLogger(CostumBugService.class);

    /**
     *      This method is for custom implementation by the user.
     *      It should be updated to retrieve the status of a bug with the given ID from the TicketSystem and return it as a
     *      {@link BugStatus} value.
     *      If the bug cannot be found or if there is an error retrieving its status, this method should return null.
     *      It is important to ensure that this method is properly implemented in order to provide accurate bug status information to users of the system.
     */
    public Response getBug(String bugId) {
        return null;
    }


}
