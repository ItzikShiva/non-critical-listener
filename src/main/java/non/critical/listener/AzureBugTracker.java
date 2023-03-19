package non.critical.listener;

//import non.critical.AzureBaseBugTests.AzureBaseBugTests;
import non.critical.listener.azure.api.BugService;
import non.critical.listener.azure.api.getbugresponse.GetBugResponse;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils.responseToObject;

public class AzureBugTracker  implements BugTracker {
    public static BugService bugService = new BugService();

    @Override
    public boolean isBugOpen(String bugId) {
        Response response = bugService.getBug(bugId);

        if (response.code() != 200) {
            return false;
        }

        GetBugResponse getBugResponse = responseToObject(response, GetBugResponse.class);

        return getBugResponse.getFields().getSystemState().equals("Active") || getBugResponse.getFields().getSystemState().equals("New");
    }
}