
package non.critical.listener.tfs.api.getbugresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Links__2 {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("workItemUpdates")
    @Expose
    private WorkItemUpdates workItemUpdates;
    @SerializedName("workItemRevisions")
    @Expose
    private WorkItemRevisions workItemRevisions;
    @SerializedName("workItemComments")
    @Expose
    private WorkItemComments workItemComments;
    @SerializedName("html")
    @Expose
    private Html html;
    @SerializedName("workItemType")
    @Expose
    private WorkItemType workItemType;
    @SerializedName("fields")
    @Expose
    private Fields__1 fields;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public WorkItemUpdates getWorkItemUpdates() {
        return workItemUpdates;
    }

    public void setWorkItemUpdates(WorkItemUpdates workItemUpdates) {
        this.workItemUpdates = workItemUpdates;
    }

    public WorkItemRevisions getWorkItemRevisions() {
        return workItemRevisions;
    }

    public void setWorkItemRevisions(WorkItemRevisions workItemRevisions) {
        this.workItemRevisions = workItemRevisions;
    }

    public WorkItemComments getWorkItemComments() {
        return workItemComments;
    }

    public void setWorkItemComments(WorkItemComments workItemComments) {
        this.workItemComments = workItemComments;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public WorkItemType getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(WorkItemType workItemType) {
        this.workItemType = workItemType;
    }

    public Fields__1 getFields() {
        return fields;
    }

    public void setFields(Fields__1 fields) {
        this.fields = fields;
    }

}
