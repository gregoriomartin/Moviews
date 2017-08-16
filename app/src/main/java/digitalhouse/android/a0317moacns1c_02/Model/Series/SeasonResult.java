package digitalhouse.android.a0317moacns1c_02.Model.Series;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import digitalhouse.android.a0317moacns1c_02.Helpers.DateHelper;

/**
 * Created by Gregorio Martin on 11/6/2017.
 */

public class SeasonResult implements Serializable {

    @SerializedName("air_date")
    protected String airDate;
    @SerializedName("episode_count")
    protected Integer episodeCount;
    protected Integer id;
    @SerializedName("poster_path")
    protected String posterPath;
    @SerializedName("season_number")
    protected Integer seasonNumber;

    public String getAirDate() {
        return DateHelper.apiDateToString(airDate);
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
