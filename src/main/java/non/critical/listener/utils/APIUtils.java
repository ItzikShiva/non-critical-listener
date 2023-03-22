package non.critical.listener.utils;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class APIUtils {
    private static final Logger logger = LogManager.getLogger(APIUtils.class);

    public static Gson gson = new Gson();
    public static OkHttpClient client = new OkHttpClient();

    /**
     * this method execute http request with okHttp client
     * get request and logger as parameter
     * execute the request, log and return response as Response type
     **/
    public static Response executeMethod(Request request, Logger logger) {
        logger.info("Performing " + request.method() + " request to: " + request.url());
        Response response = null;
        try {
            response = client.newCall(request).execute();
            logger.info("got response from server");
        } catch (IOException e) {
            logger.error("error in getting response from server", e);
        }
        return response;
    }

    /**
     This method is used to parse a response body into a Java object of a specified class.
     @param response the HTTP response to parse
     @param clazz the class of the Java object to parse the response into
     @return a Java object of the specified class, populated with data from the response body
     */
    public static <T> T responseToObject(Response response, Class<T> clazz) {
        ResponseBody responseBody = response.body();
        String jsonString = null;

        try {
            jsonString = responseBody.string();
        } catch (IOException e) {
            logger.error("error while parsing response body", e);
        }

        T responseObject = gson.fromJson(jsonString, clazz);
        return responseObject;
    }
}
