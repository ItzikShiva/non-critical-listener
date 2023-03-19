package non.critical.listener.jira.api;


import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.utils.APICommonUtils.*;

public class IssueService {
    private static final Logger logger = LogManager.getLogger(IssueService.class);
    private static String baseUrl = "https://api.atlassian.com/ex/jira/93916ef5-a97b-47de-9a28-80fe8572a67e/rest/api/3/issue/";
    public static final MediaType jsonMediaType = MediaType.parse("application/json");


    /**
     * getIssue()
     * param issueKey - required
     * param token - optional. if not provide, uses default - valid token.
     */
    public Response getIssue(String issueKey) {
//        return getIssue(issueKey, apiService.token);
        return getIssue(issueKey, "to change, just for compile");
    }

    public Response getIssue(String issueKey, String token) {
        logger.info("getting Issue from server");

        Request request = new Request.Builder().url(baseUrl + issueKey).addHeader("Accept", "application/json")
                .addHeader("Authorization", token).build();

        return executeMethod(request, logger);
    }
}
