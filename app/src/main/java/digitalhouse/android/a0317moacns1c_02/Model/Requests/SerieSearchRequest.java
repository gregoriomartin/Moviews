package digitalhouse.android.a0317moacns1c_02.Model.Requests;

/**
 * Created by Gregorio Martin on 27/5/2017.
 */

public class SerieSearchRequest extends BaseSearchRequest {

    private String lenguage = null;
    private Integer page = null;
    private Integer first_air_date_year = null;

    public SerieSearchRequest(String query){
        super(query);
    }


    public SerieSearchRequest(String lenguage, String query, Integer page, Integer first_air_date_year) {
        super(query);
        this.lenguage = lenguage;
        this.page = page;
        this.first_air_date_year = first_air_date_year;
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

    public Integer getFirst_air_date_year() {
        return first_air_date_year;
    }

    public void setFirst_air_date_year(Integer first_air_date_year) {
        this.first_air_date_year = first_air_date_year;
    }
}
