package digitalhouse.android.a0317moacns1c_02.Model.Movie;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import digitalhouse.android.a0317moacns1c_02.Model.General.OmdbBaseResponse;

/**
 * Created by forev on 15-Jun-17.
 */

public class MovieOmdb extends OmdbBaseResponse implements Serializable {


    @SerializedName("DVD")
    protected String dvd;

    @SerializedName("BoxOffice")
    protected String boxOffice;

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @SerializedName("Production")
    protected String production;

    @SerializedName("Website")
    protected String website;
}
