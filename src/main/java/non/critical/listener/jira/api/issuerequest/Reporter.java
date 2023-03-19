
package non.critical.listener.jira.api.issuerequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Reporter {

    @SerializedName("id")
    @Expose
    private String id;

    public Reporter(String id) {
		super();
		this.id = id;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
