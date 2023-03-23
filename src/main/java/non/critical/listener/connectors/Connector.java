package non.critical.listener.connectors;

import non.critical.listener.BugStatus;
import non.critical.listener.NonCriticalListener;

public interface Connector {

    /**
     * getBugStatus(String bugId) - connector - depend - "Jira" / "Tfs" etc. from config file
     * If the response code isn't 200, the method returns null - response error.
     * else it checks if the bug has a resolution or not. If the bug has a resolution, it means that it is DONE, so the method returns false.
     * If the issue does not have a resolution, it means that it is OPEN, so the method returns true.
     */
    BugStatus getBugStatus(String bugId);
}
