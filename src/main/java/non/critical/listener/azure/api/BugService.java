package non.critical.listener.azure.api;


import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static non.critical.listener.Configure.*;
import static non.critical.listener.utils.APICommonUtils.executeMethod;


public class BugService {



    private static final Logger logger = LogManager.getLogger(BugService.class);

    public static Response getBug(String bugId){
        logger.info("getting Bug from server");

        Request request = new Request.Builder().url(baseUrl + bugId).addHeader("Accept", "application/json")
                .addHeader("Authorization", TOKEN).build();

        return executeMethod(request, logger);
    }




}
