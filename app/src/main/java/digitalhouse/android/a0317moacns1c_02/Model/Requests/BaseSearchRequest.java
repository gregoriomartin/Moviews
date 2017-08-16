package digitalhouse.android.a0317moacns1c_02.Model.Requests;

/**
 * Created by Gregorio Martin on 28/5/2017.
 */

public class BaseSearchRequest {
    private String query;

    public BaseSearchRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
