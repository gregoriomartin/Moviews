package digitalhouse.android.a0317moacns1c_02.Model.Requests;

import java.util.HashMap;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.SeriesClient;

/**
 * Created by Gregorio Martin on 6/6/2017.
 */

public class PopularSeriesRequest {

    private String apiKey;
    private String lenguage;
    private Integer page;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public HashMap<String, String> getHashMap(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_key" ,SeriesClient.API_KEY);
        if(lenguage != null) hashMap.put("lenguage", lenguage);
        if(page!=null) hashMap.put("page", page.toString());
        return  hashMap;
    }
}
