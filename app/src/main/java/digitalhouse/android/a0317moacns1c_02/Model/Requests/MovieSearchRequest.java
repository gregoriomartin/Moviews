package digitalhouse.android.a0317moacns1c_02.Model.Requests;

/**
 * Created by Gregorio Martin on 27/5/2017.
 */

public class MovieSearchRequest extends BaseSearchRequest {

    private String lenguage = null;
    private Integer page = null;
    private Boolean include_adult = false;
    private String region = null;
    private String year = null;
    private String primary_release_year = null;

    public MovieSearchRequest(String query){
        super(query);
    }


    public MovieSearchRequest(String lenguage, String query, Integer page, Boolean include_adult, String region, String year, String primary_release_year) {
        super(query);
        this.lenguage = lenguage;
        this.page = page;
        this.include_adult = include_adult;
        this.region = region;
        this.year = year;
        this.primary_release_year = primary_release_year;
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

    public Boolean getInclude_adult() {
        return include_adult;
    }

    public void setInclude_adult(Boolean include_adult) {
        this.include_adult = include_adult;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrimary_release_year() {
        return primary_release_year;
    }

    public void setPrimary_release_year(String primary_release_year) {
        this.primary_release_year = primary_release_year;
    }
}
