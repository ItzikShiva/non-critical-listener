
package non.critical.listener.jira.api.getbugresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Issuerestriction {

    @SerializedName("issuerestrictions")
    @Expose
    private Issuerestrictions issuerestrictions;
    @SerializedName("shouldDisplay")
    @Expose
    private Boolean shouldDisplay;

    public Issuerestrictions getIssuerestrictions() {
        return issuerestrictions;
    }

    public void setIssuerestrictions(Issuerestrictions issuerestrictions) {
        this.issuerestrictions = issuerestrictions;
    }

    public Boolean getShouldDisplay() {
        return shouldDisplay;
    }

    public void setShouldDisplay(Boolean shouldDisplay) {
        this.shouldDisplay = shouldDisplay;
    }

}
