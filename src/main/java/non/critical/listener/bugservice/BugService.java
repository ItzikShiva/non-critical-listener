package non.critical.listener.bugservice;

import non.critical.listener.BugStatus;
import okhttp3.Response;

public interface BugService {

    /**
     * Retrieves the status of a bug of TicketSystem.
     *
     * @param bugId The ID of the bug to retrieve the status for.
     * @return The status of the bug, as a {@link BugStatus} value.
     *         Returns null if the bug cannot be found or if there is an error retrieving its status.
     */
    Response getBug(String bugId);
}
