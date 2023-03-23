package non.critical.listener.bugservice;


import non.critical.listener.Configure;
import non.critical.listener.utils.APIUtils;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultBugService implements BugService {
    private static final Logger logger = LogManager.getLogger(DefaultBugService.class);

    public Response getBug(String bugId) {
        logger.info("getting Issue from server");

        Request request = new Request.Builder().url(Configure.baseUrl + bugId).addHeader("Accept", "application/json")
                .addHeader("Authorization", Configure.TOKEN).build();

        return APIUtils.executeMethod(request, logger);
    }

}
