package digitalhouse.android.a0317moacns1c_02.Model.General;

import com.google.gson.annotations.SerializedName;

/**
 * Created by forev on 15-Jun-17.
 */

public class RateOmdb {
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @SerializedName("Source")
    protected String source;

    @SerializedName("Value")
    protected String value;
}
