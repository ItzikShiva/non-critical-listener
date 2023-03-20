package non.critical.listener.connectors;

import non.critical.listener.NonCriticalListener;

public interface Connector {
//    enum BugStatus {
//        Active,Closed,Resolved,New
//    }

    /**
     * isBugOpen(String issueKey) - connector - depend - "Jira" / "Tfs" etc. from config file
     * If the response code isn't 200, the method returns false - bug is NOT open.
     * Then it checks if the issue has a resolution or not. If the issue has a resolution, it means that it is DONE, so the method returns false.
     * If the issue does not have a resolution, it means that it is OPEN, so the method returns true.
     */
    boolean isBugOpen(String bugId);
    NonCriticalListener.BugStatus getBugStatus(String bugId);
}
