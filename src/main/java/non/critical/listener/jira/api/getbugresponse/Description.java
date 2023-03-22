
package non.critical.listener.jira.api.getbugresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class Description {

    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("content")
    @Expose
    private List<Content> content;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
