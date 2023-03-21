package non.critical.listener.bugservice;


import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.Configure.TOKEN;
import static non.critical.listener.Configure.baseUrl;
import static non.critical.listener.utils.APICommonUtils.executeMethod;

public class JiraBugService implements BugService {
    private static final Logger logger = LogManager.getLogger(JiraBugService.class);

    /**
     * getIssue()
     * param issueKey - required
     * param token - optional. if not provide, uses default - valid token.
     */
    public Response getBug(String bugId) {
        logger.info("getting Issue from server");

        Request request = new Request.Builder().url(baseUrl + bugId).addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + TOKEN).build();

        return executeMethod(request, logger);
    }

}
