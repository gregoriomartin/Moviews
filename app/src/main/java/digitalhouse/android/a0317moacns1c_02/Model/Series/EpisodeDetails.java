package digitalhouse.android.a0317moacns1c_02.Model.Series;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Model.Credits.Crew;

/**
 * Created by forev on 18-Jun-17.
 */

public class EpisodeDetails implements Serializable {
    @SerializedName("air_date")
    protected String  airDate;
    protected List<Crew> crew;
    @SerializedName("episode_number")
    protected Integer espisodeNumber;
    @SerializedName("guest_stars")
    protected Object guestStars;
    protected String name;
    protected String overview;
    protected Integer id;
    @SerializedName("production_code")
    protected String production_code;
    @SerializedName("season_number")
    protected Integer seasonNumber;
    @SerializedName("still_path")
    protected String stillPath;
    @SerializedName("vote_average")
    protected Double voteAverage;
    @SerializedName("vote_count")
    protected Integer voteCount;

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public Integer getEspisodeNumber() {
        return espisodeNumber;
    }

    public void setEspisodeNumber(Integer espisodeNumber) {
        this.espisodeNumber = espisodeNumber;
    }

    public Object getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(Object guestStars) {
        this.guestStars = guestStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
