package non.critical.listener;

public class Configure {
    public String jira_token = "Bearer eyJraWQiOiJmZTM2ZThkMzZjMTA2N2RjYTgyNTg5MmEiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiJhMWQxMTlhMC1jNzhmLTRkZjUtYWIwMC04NzNmN2U3OTZmMzMiLCJzdWIiOiI2MjM2Zjc1Njg2NmI4MTAwNjllMjBkOWMiLCJuYmYiOjE2NzkyNDY0NjAsImlzcyI6Imh0dHBzOi8vYXRsYXNzaWFuLWFjY291bnQtcHJvZC5wdXMyLmF1dGgwLmNvbS8iLCJpYXQiOjE2NzkyNDY0NjAsImV4cCI6MTY3OTI1MDA2MCwiYXVkIjoiRU1jWnphem1SZHFkR21ENDh6am1DRDN0VmllbG1wd04iLCJodHRwczovL2lkLmF0bGFzc2lhbi5jb20vc2Vzc2lvbl9pZCI6ImUwYTk4MmE1LWRkYTYtNGY3Ni04NjdjLTU5ODkxNTQ1MjQ4OCIsImh0dHBzOi8vaWQuYXRsYXNzaWFuLmNvbS91anQiOiJlYjJhMGRlMS1iODU4LTQ5NjItODhiYi1jZTEzZTM5NmM0YWEiLCJzY29wZSI6InJlYWQ6amlyYS13b3JrIHJlYWQ6YWNjb3VudCByZWFkOm1lIHdyaXRlOmppcmEtd29yayIsImh0dHBzOi8vaWQuYXRsYXNzaWFuLmNvbS9hdGxfdG9rZW5fdHlwZSI6IkFDQ0VTUyIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9maXJzdFBhcnR5IjpmYWxzZSwiaHR0cHM6Ly9hdGxhc3NpYW4uY29tL29hdXRoQ2xpZW50SWQiOiJFTWNaemF6bVJkcWRHbUQ0OHpqbUNEM3RWaWVsbXB3TiIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS92ZXJpZmllZCI6dHJ1ZSwiY2xpZW50X2F1dGhfdHlwZSI6IlBPU1QiLCJodHRwczovL2F0bGFzc2lhbi5jb20vZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vM2xvIjp0cnVlLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudElkIjoiNjNkNjM4Zjc4MmVlZWU3OGE0Y2QwNmNlIiwiaHR0cHM6Ly9pZC5hdGxhc3NpYW4uY29tL3ZlcmlmaWVkIjp0cnVlLCJjbGllbnRfaWQiOiJFTWNaemF6bVJkcWRHbUQ0OHpqbUNEM3RWaWVsbXB3TiIsImh0dHBzOi8vYXRsYXNzaWFuLmNvbS9zeXN0ZW1BY2NvdW50RW1haWxEb21haW4iOiJjb25uZWN0LmF0bGFzc2lhbi5jb20iLCJodHRwczovL2F0bGFzc2lhbi5jb20vc3lzdGVtQWNjb3VudEVtYWlsIjoiMGQ0OTYzZTMtNTExMy00ODM2LTlkZjUtOTE2MzIwOGE2NTE2QGNvbm5lY3QuYXRsYXNzaWFuLmNvbSJ9.UMUhebVcoAtjpmV0x9BuAWnbC6FLkybjm90C0WFXI09q2NVxPYUCmYbriCYr8VSSk7Rd_C1DCaIfbMae6O37befEU1AeoyDXBhgNlOG4qxw4RfSYVXBkheIbzJRhB9QHllR-pAfiIWrhzqsnfoJiOiwvJT4YfAfZxQT8-lmGLESGuoCheZNC1r5DEMUIxngBq0sDnoQcISf0-NmbPgRo1dnnfDR1OG_fZ0Bg10Vxix4IYZlxMW0B7JPaqimW-YaWolpTN6fboW-tgHm1RE6M5b4aZBREcKKO2zH9bwmd8lDz_lgIjERup2HdsE0USd2Fo0_RGWNS2FoThGFzjvmKfQ";
    //TODO - take the class params to configure file
    public static final String TOKEN = "Basic OmluMzV3aGQzd3E3bGFweGgzZXV2dmF6dDVjbGlod201cXR0emNhcnYyZWpiMzQzaTR5M2E=";
    public static final String baseUrl = "https://dev.azure.com/itzikv3/bug-listener/_apis/wit/workitems/";
    private static final String DEFAULT_TICKET_SYSTEM = "Azure";
    private static final String CURRENT_TICKET_SYSTEM = null;
    private static BugTracker bugTracker;

    public Configure() {
        setTicketSystem();
    }

    public void setTicketSystem(){
        String ticketSystem = CURRENT_TICKET_SYSTEM == null ? DEFAULT_TICKET_SYSTEM : CURRENT_TICKET_SYSTEM;

        if ("Jira".equals(ticketSystem)) {
            this.bugTracker = new JiraBugTracker();
        } else if ("Azure".equals(ticketSystem)) {
            this.bugTracker = new AzureBugTracker();
        } else {
            throw new IllegalArgumentException("Unsupported ticketing system: " + ticketSystem);
        }
    }

    public BugTracker getBugTracker() {
        return bugTracker;
    }

}
