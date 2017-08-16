package digitalhouse.android.a0317moacns1c_02.Model.General;

import java.io.Serializable;

/**
 * Created by forev on 15-Jun-17.
 */

public class RatingsContainer implements Serializable {

    private static final String NO_RATE = "N/A";
    private String imdbRateString;
    private Double imdbRate;
    private String imdbMaxRateString;
    private String metascoreString;
    private Integer metascore;
    private String maxMetascoreString;
    private String tmdbRateString;
    private Double tmdbRate;
    private String tmdbMaxRateString;
    private String rottenTomatoesPercentageString;
    private Integer rottenTomatoesPercentage;
    private Integer totalOfVoteSources = 0;
    private Integer averageScore;

    public Integer getAverageScore(){
        if(averageScore == null){
            int total = 0;
            total += metascore != null ? metascore : 0;
            total += tmdbRate != null ? tmdbRate * 10 : 0;
            total += rottenTomatoesPercentage != null ? rottenTomatoesPercentage : 0;
            total += imdbRate != null ? imdbRate * 10 : 0;
            averageScore = total / totalOfVoteSources;
        }
        return averageScore;
    }

    public String getImdbRate() {
        return imdbRateString;
    }

    public void setImdbRate(String imdbRate) {
        this.imdbRateString = imdbRate;
        if(imdbRate != null && imdbRate != NO_RATE)
        {
            this.imdbRate = Double.parseDouble(imdbRate);
            totalOfVoteSources++;
        }

    }

    public String getImdbMaxRate() {
        return imdbMaxRateString;
    }

    public void setImdbMaxRate(String imdbMaxRate) {
        this.imdbMaxRateString = imdbMaxRate;
    }

    public String getMetascore() {
        return metascoreString;
    }

    public void setMetascore(String metascore) {
        if(metascore != null && metascore != NO_RATE){
            this.metascoreString = metascore;
            totalOfVoteSources++;
            this.metascore = Integer.parseInt(metascore);
        }

    }

    public String getMaxMetascore() {
        return maxMetascoreString;
    }

    public void setMaxMetascore(String maxMetascore) {
        this.maxMetascoreString = maxMetascore;
    }

    public String getTmdbRate() {
        return tmdbRateString;
    }

    public void setTmdbRate(String tmdbRate) {
        if(tmdbRate != null && tmdbRate != NO_RATE){
            this.tmdbRateString = tmdbRate;
            totalOfVoteSources++;
            this.tmdbRate = Double.parseDouble(tmdbRate);
        }

    }

    public void setTmdbRate(Double tmdbRate){
        totalOfVoteSources++;
        this.tmdbRate = tmdbRate;
        this.tmdbMaxRateString = tmdbRate.toString();
    }

    public String getTmdbMaxRate() {
        return tmdbMaxRateString;
    }

    public void setTmdbMaxRate(String tmdbMaxRate) {
        this.tmdbMaxRateString = tmdbMaxRate;
    }

    public String getRottenTomatoesPercentage() {
        return rottenTomatoesPercentageString;
    }

    public void setRottenTomatoesPercentage(String rottenTomatoesPercentage) {
        if(rottenTomatoesPercentage != null && rottenTomatoesPercentage != NO_RATE){
            this.rottenTomatoesPercentageString = rottenTomatoesPercentage;
            totalOfVoteSources++;
            this.rottenTomatoesPercentage = Integer.parseInt(rottenTomatoesPercentage.substring(0,3));
        }
    }

    public boolean hasMetascoreAndRottenScore(){
        return metascore != null && rottenTomatoesPercentage != null;
    }
}
