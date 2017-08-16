package digitalhouse.android.a0317moacns1c_02.Model.General;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by forev on 15-Jun-17.
 */

public class OmdbBaseResponse implements Serializable {

    protected boolean longPlot = false;

    @SerializedName("Title")
    protected String title;

    @SerializedName("Year")
    protected String year;

    @SerializedName("Rated")
    protected String rated;

    @SerializedName("Released")
    protected String released;

    @SerializedName("Runtime")
    protected String runtime;

    @SerializedName("Genre")
    protected String genre;

    @SerializedName("Director")
    protected String director;

    @SerializedName("Writer")
    protected String writer;

    @SerializedName("Actors")
    protected String actors;

    @SerializedName("Plot")
    protected String plot;

    @SerializedName("Language")
    protected String language;

    @SerializedName("Country")
    protected String country;

    @SerializedName("Awards")
    protected String awards;

    @SerializedName("Poster")
    protected String poster;

    @SerializedName("Ratings")
    protected List<RateOmdb> ratings;

    protected String imdbRating;

    protected String imdbVotes;

    protected String imdbID;

    @SerializedName("Type")
    protected String Type;

    @SerializedName("Metascore")
    protected String metascore;

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<RateOmdb> getRatings() {
        return ratings;
    }

    public void setRatings(List<RateOmdb> ratings) {
        this.ratings = ratings;
    }

    public boolean isLongPlot() {
        return longPlot;
    }

    public void setLongPlot(boolean longPlot) {
        this.longPlot = longPlot;
    }
}
