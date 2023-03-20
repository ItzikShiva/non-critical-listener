package non.critical.listener.connectors;

import non.critical.listener.jira.api.getissueresponse.GetIssueResponse;
import non.critical.listener.jira.api.IssueService;
import okhttp3.Response;

import static non.critical.listener.utils.APIUtils .responseToObject;

public class JiraConnector implements Connector {
    public static IssueService issueService = new IssueService();


    @Override
    public boolean isBugOpen(String issueKey) {
        Response response = issueService.getIssue(issueKey);

        if (response.code() != 200) {
            return false;
        }

        GetIssueResponse getIssueResponse = responseToObject(response, GetIssueResponse.class);

        return getIssueResponse.getFields().getResolution() == null;
    }

}