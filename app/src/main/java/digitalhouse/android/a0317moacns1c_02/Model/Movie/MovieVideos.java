package digitalhouse.android.a0317moacns1c_02.Model.Movie;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Model.Media.VideoData;

/**
 * Created by Pablo on 25/05/2017.
 */

public class MovieVideos {
    private Integer id;
    private ArrayList<VideoData> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<VideoData> getResults() {
        return results;
    }

    public void setResults(ArrayList<VideoData> results) {
        this.results = results;
    }
}
