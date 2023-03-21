package non.critical.listener.bugservice;


import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.Configure.TOKEN;
import static non.critical.listener.Configure.baseUrl;
import static non.critical.listener.utils.APICommonUtils.executeMethod;


public class TfsBugService implements BugService {

    private static final Logger logger = LogManager.getLogger(TfsBugService.class);

    public Response getBug(String bugId) {
        logger.info("getting Bug from server");

        Request request = new Request.Builder().url(baseUrl + bugId).addHeader("Accept", "application/json")
                .addHeader("Authorization", TOKEN).build();

        return executeMethod(request, logger);
    }


}
