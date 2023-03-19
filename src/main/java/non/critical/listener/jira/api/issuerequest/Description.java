
package non.critical.listener.jira.api.issuerequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class Description {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private int version;
    @SerializedName("content")
    @Expose
    private List<Content> content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
