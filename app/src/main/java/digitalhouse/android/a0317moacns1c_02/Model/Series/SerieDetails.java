package digitalhouse.android.a0317moacns1c_02.Model.Series;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Model.General.Network;
import digitalhouse.android.a0317moacns1c_02.Model.Genres.Genre;
import digitalhouse.android.a0317moacns1c_02.Model.Misc.Company;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonBase;

/**
 * Created by Gregorio Martin on 11/6/2017.
 */

public class SerieDetails extends SerieResult implements Parcelable, Serializable {

    @SerializedName("created_by") protected List<PersonBase> createdBy;
    @SerializedName("episode_run_time") protected List<Integer> episodeRunTimes;
    protected List<Genre> genres;
    protected String homepage;
    @SerializedName("in_production") protected Boolean inProduction;
    protected List<String> languages;
    @SerializedName("last_air_date") protected String lastAirDate;
    protected List<Network> networks;
    @SerializedName("number_of_episodes") protected Integer numberOfEpisodes;
    @SerializedName("number_of_seasons") protected Integer numberOfSeasons;
    @SerializedName("production_companies") protected List<Company> productionCompanies;
    protected List<SeasonResult> seasons;
    protected String status;
    protected String type;

    public SerieDetails(){

    }

    protected SerieDetails(Parcel in) {
        super(in);
        createdBy = in.createTypedArrayList(PersonBase.CREATOR);
        homepage = in.readString();
        languages = in.createStringArrayList();
        lastAirDate = in.readString();
        productionCompanies = in.createTypedArrayList(Company.CREATOR);
        status = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(createdBy);
        dest.writeString(homepage);
        dest.writeStringList(languages);
        dest.writeString(lastAirDate);
        dest.writeTypedList(productionCompanies);
        dest.writeString(status);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SerieDetails> CREATOR = new Creator<SerieDetails>() {
        @Override
        public SerieDetails createFromParcel(Parcel in) {
            return new SerieDetails(in);
        }

        @Override
        public SerieDetails[] newArray(int size) {
            return new SerieDetails[size];
        }
    };

    public List<PersonBase> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<PersonBase> createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getEpisodeRunTimes() {
        return episodeRunTimes;
    }

    public void setEpisodeRunTimes(List<Integer> episodeRunTimes) {
        this.episodeRunTimes = episodeRunTimes;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Boolean getInProduction() {
        return inProduction;
    }

    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public String getNumberOfEpisodes() {
        if(numberOfEpisodes != null)
            return numberOfEpisodes.toString();
        else
            return "N/A";
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getNumberOfSeasons() {
        if(numberOfSeasons != null)
            return numberOfSeasons.toString();
        else
            return "N/A";
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<Company> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<Company> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<SeasonResult> getSeasonResults() {
        return seasons;
    }

    public void setSeasonResults(List<SeasonResult> seasonResults) {
        this.seasons = seasonResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
