package digitalhouse.android.a0317moacns1c_02.Model.Movie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Model.Genres.Genre;
import digitalhouse.android.a0317moacns1c_02.Model.Misc.Company;
import digitalhouse.android.a0317moacns1c_02.Model.Misc.Country;
import digitalhouse.android.a0317moacns1c_02.Model.Misc.Language;

/**
 * Created by Gregorio Martin on 20/5/2017.
 */

public class MovieDetails implements Parcelable{
    public static final String tag = "movieDetails";
    private Boolean adult;
    private String backdrop_path;
    private Integer budget;
    private ArrayList<Genre> genres;
    private String homepage;
    private Integer id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private ArrayList<Company> production_companies;
    private ArrayList<Country> production_countries;
    private String release_date;
    private Integer revenue;
    private Integer runtime;
    private ArrayList<Language> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_count;

    protected MovieDetails(Parcel in) {
        backdrop_path = in.readString();
        homepage = in.readString();
        imdb_id = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        overview = in.readString();
        poster_path = in.readString();
        production_companies = in.createTypedArrayList(Company.CREATOR);
        production_countries = in.createTypedArrayList(Country.CREATOR);
        release_date = in.readString();
        spoken_languages = in.createTypedArrayList(Language.CREATOR);
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(backdrop_path);
        dest.writeString(homepage);
        dest.writeString(imdb_id);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeTypedList(production_companies);
        dest.writeTypedList(production_countries);
        dest.writeString(release_date);
        dest.writeTypedList(spoken_languages);
        dest.writeString(status);
        dest.writeString(tagline);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieDetails> CREATOR = new Creator<MovieDetails>() {
        @Override
        public MovieDetails createFromParcel(Parcel in) {
            return new MovieDetails(in);
        }

        @Override
        public MovieDetails[] newArray(int size) {
            return new MovieDetails[size];
        }
    };

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<Company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<Company> production_companies) {
        this.production_companies = production_companies;
    }

    public ArrayList<Country> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(ArrayList<Country> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public ArrayList<Language> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(ArrayList<Language> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public String getRuntimeString(){
        int horas = runtime / 60;
        int minutos = runtime - (horas * 60);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(horas + " hrs ");
        stringBuilder.append(minutos + " min");
        return  stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "MovieDetails{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }

    public String getYear(){
        return "(" + release_date.substring(0, 4) + ")";
    }
}