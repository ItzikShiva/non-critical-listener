package non.critical.listener;

import non.critical.listener.connectors.TfsConnector;
import non.critical.listener.connectors.Connector;
import non.critical.listener.connectors.JiraConnector;

public class Configure {
    //TODO - take the class params to configure file
    //TODO - check how to get jira token like tfs PAT
    /**
     * TOKEN:
     * for "Tfs" should be after generating, example: "Basic OmluMzV3aGQzd3E3...."
     * for "Jira" should be after generating, example: "OmluMzV3aGQzd3E....." (without "Bearer")
     * TICKET_SYSTEM: examples: "Tfs" or "Jira"
     */
    private static final String TICKET_SYSTEM = "Tfs";
//    public static final String TOKEN = "Bearer eyJraWQiOiJmZTM2ZThkMzZjMTA2N2RjYTgyNTg5MmEiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiI4YzQxYTA3Yy04NjU1LTRlOGUtOTc0Zi1jOTYxNWNmN2VlOGMiLCJzdWIiOiI2MjM2Zjc1Njg2NmI4MTAwNjllMjBkOWMiLCJuYmYiOjE2NzkzMDE5MTIsImlzcyI6Imh0dHBzOi8vYXRsYXNzaWFuLWFjY291bnQtcHJvZC5wdXMyLmF1dGgwLmNvbS8iLCJpYXQiOjE2NzkzMDE5MTIsImV4cCI6MTY3OTMwNTUxMiwiYXVkIjoiRU1jWnphem1SZHFkR21ENDh6am1DRDN0VmllbG1wd04iLCJodHRwczovL2lkLmF0bGFzc2lhbi5jb20vYXRsX3Rva2VuX3R5cGUiOiJBQ0NFU1MiLCJodHRwczovL2F0bGFzc2lhbi5jb20vZmlyc3RQYXJ0eSI6ZmFsc2UsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9vYXV0aENsaWVudElkIjoiRU1jWnphem1SZHFkR21ENDh6am1DRDN0VmllbG1wd04iLCJodHRwczovL2F0bGFzc2lhbi5jb20vdmVyaWZpZWQiOnRydWUsInNjb3BlIjoibWFuYWdlOmppcmEtcHJvamVjdCBtYW5hZ2U6amlyYS1jb25maWd1cmF0aW9uIHJlYWQ6amlyYS13b3JrIHdyaXRlOnByb2plY3Q6amlyYSB3cml0ZTpib2FyZC1zY29wZS5hZG1pbjpqaXJhLXNvZnR3YXJlIiwiY2xpZW50X2F1dGhfdHlwZSI6IlBPU1QiLCJodHRwczovL2F0bGFzc2lhbi5jb20vZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vM2xvIjp0cnVlLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudElkIjoiNjNkNjM4Zjc4MmVlZWU3OGE0Y2QwNmNlIiwiaHR0cHM6Ly9pZC5hdGxhc3NpYW4uY29tL3Nlc3Npb25faWQiOiI5ZjgwMDQyYy1jNWY1LTRlZWMtOGVlYS1kODQxNDlmOTIzYWIiLCJodHRwczovL2lkLmF0bGFzc2lhbi5jb20vdWp0IjoiNzU2Y2Y3ZWItMTUzZi00YjRlLTk1NDctYTgyNGU1NzkzMDQ1IiwiaHR0cHM6Ly9pZC5hdGxhc3NpYW4uY29tL3ZlcmlmaWVkIjp0cnVlLCJjbGllbnRfaWQiOiJFTWNaemF6bVJkcWRHbUQ0OHpqbUNEM3RWaWVsbXB3TiIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9zeXN0ZW1BY2NvdW50RW1haWxEb21haW4iOiJjb25uZWN0LmF0bGFzc2lhbi5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudEVtYWlsIjoiMGQ0OTYzZTMtNTExMy00ODM2LTlkZjUtOTE2MzIwOGE2NTE2QGNvbm5lY3QuYXRsYXNzaWFuLmNvbSJ9.YH3WaRKsuvimrMYzeZ_0jzDZ08YKuFNEZSvauybt9ikyoo4tkigoaTjkAqjIHvY0r27q-YlFzUJi7JcWNmQtkDQIkoWoOweY_u70J91pzzDTcSzpGNvMKMO4y3aaJrwm1uwwYKfGJbYOAZ6n2CCS2J6pQlOlvAZ_7LbpTSS41-LlYzojSx7N6tXSe7E7JYEhE8hCR0IppCmRCn6C4NyXAWKR4MVnsSKWaBu3dGbewWmZm-NJPuVWrs8VcLv2urNlzvv7o9EWEx7OBIr_cF1Mzt-yG1ugsHKnqZN2VWWkMD_twgpXHHWUt2xILWXhJBzMGyrEv9aLdm2wioM0-l772A";
    public static final String TOKEN = "Basic OmluMzV3aGQzd3E3bGFweGgzZXV2dmF6dDVjbGlod201cXR0emNhcnYyZWpiMzQzaTR5M2E=";
    public static final String JIRA_CLOUD_ID = "93916ef5-a97b-47de-9a28-80fe8572a67e";
    public static String baseUrl = null;
    public static String tfs_organization = "itzikv3";
    public static String tfs_project = "bug-listener";
//    public static String TOKEN = "eyJraWQiOiJmZTM2ZThkMzZjMTA2N2RjYTgyNTg5MmEiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIzNDU0MTIxZi0wNmIwLTRlZjgtOWRlNC02ZTU5NjEwNWE5YzEiLCJzdWIiOiI2MjM2Zjc1Njg2NmI4MTAwNjllMjBkOWMiLCJuYmYiOjE2NzkzMTg1MDYsImlzcyI6Imh0dHBzOi8vYXRsYXNzaWFuLWFjY291bnQtcHJvZC5wdXMyLmF1dGgwLmNvbS8iLCJpYXQiOjE2NzkzMTg1MDYsImV4cCI6MTY3OTMyMjEwNiwiYXVkIjoiRU1jWnphem1SZHFkR21ENDh6am1DRDN0VmllbG1wd04iLCJzY29wZSI6InJlYWQ6amlyYS13b3JrIHJlYWQ6YWNjb3VudCByZWFkOm1lIHdyaXRlOmppcmEtd29yayIsImh0dHBzOi8vaWQuYXRsYXNzaWFuLmNvbS9hdGxfdG9rZW5fdHlwZSI6IkFDQ0VTUyIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9maXJzdFBhcnR5IjpmYWxzZSwiaHR0cHM6Ly9hdGxhc3NpYW4uY29tL29hdXRoQ2xpZW50SWQiOiJFTWNaemF6bVJkcWRHbUQ0OHpqbUNEM3RWaWVsbXB3TiIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS92ZXJpZmllZCI6dHJ1ZSwiY2xpZW50X2F1dGhfdHlwZSI6IlBPU1QiLCJodHRwczovL2F0bGFzc2lhbi5jb20vZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vM2xvIjp0cnVlLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudElkIjoiNjNkNjM4Zjc4MmVlZWU3OGE0Y2QwNmNlIiwiaHR0cHM6Ly9pZC5hdGxhc3NpYW4uY29tL3Nlc3Npb25faWQiOiI5ZjgwMDQyYy1jNWY1LTRlZWMtOGVlYS1kODQxNDlmOTIzYWIiLCJodHRwczovL2lkLmF0bGFzc2lhbi5jb20vdWp0IjoiMWExNTYxYjAtMzgzMC00ZDE1LTgxMWItNzY5MTViYWJiZWFiIiwiaHR0cHM6Ly9pZC5hdGxhc3NpYW4uY29tL3ZlcmlmaWVkIjp0cnVlLCJjbGllbnRfaWQiOiJFTWNaemF6bVJkcWRHbUQ0OHpqbUNEM3RWaWVsbXB3TiIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9zeXN0ZW1BY2NvdW50RW1haWxEb21haW4iOiJjb25uZWN0LmF0bGFzc2lhbi5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudEVtYWlsIjoiMGQ0OTYzZTMtNTExMy00ODM2LTlkZjUtOTE2MzIwOGE2NTE2QGNvbm5lY3QuYXRsYXNzaWFuLmNvbSJ9.bxV2bQJTS4gwpbpCtwaLE_3QzxrkSAO3ITZgAzro8-kjAkGn_cHbG7dnnjdgcjk09NZAMQYhNlNzGNmjgK4VMtDigCBYH8vlGz-uGmLtdXZIfbfiMIll6Hl0fpdY_riQqAggoaPV75tT8KMHKd932iZhGumzZZ1LEKJSx9zo4BSmH1hhJOA4HD08vX-30qKyZKDLaiXcdji5vJVuYR068rtwn8j0at_zBl240RTFxxk5_YjzwxpdGqIEUF_ajP7nLuTKpvJcsTOZGvRV9wQ-96AQOvrqQ8oOxoHccUzW6yChHlxK3dTOICQgvSK5y8jMi1VoOahnh8op077CBji_HQ";
    private static Connector connector;

    public Configure() {
        setTicketSystem();
        setBaseUrl();
    }

    public void setBaseUrl() {
        if ("Tfs".equals(TICKET_SYSTEM)) {
            this.baseUrl = "https://dev.azure.com/" + tfs_organization + "/" + tfs_project + "/_apis/wit/workitems/";
        } else if ("Jira".equals(TICKET_SYSTEM)) {
            this.baseUrl = "https://api.atlassian.com/ex/jira/" + JIRA_CLOUD_ID + "/rest/api/3/issue/";

        }
    }

    public void setTicketSystem() {
        if ("Jira".equals(TICKET_SYSTEM)) {
            this.connector = new JiraConnector();
        } else if ("Tfs".equals(TICKET_SYSTEM)) {
            this.connector = new TfsConnector();
        } else {
            throw new IllegalArgumentException("Unsupported ticketing system: " + TICKET_SYSTEM);
        }
    }

    public Connector getConnector() {
        return connector;
    }

}
