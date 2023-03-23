
package non.critical.listener.tfs.api.getbugresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class TfsGetBugResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rev")
    @Expose
    private Integer rev;
    @SerializedName("fields")
    @Expose
    private Fields fields;
    @SerializedName("_links")
    @Expose
    private Links__2 links;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }


    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public Links__2 getLinks() {
        return links;
    }

    public void setLinks(Links__2 links) {
        this.links = links;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
