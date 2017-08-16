package digitalhouse.android.a0317moacns1c_02.Model.Series;

import java.util.List;

/**
 * Created by Gregorio Martin on 4/6/2017.
 */

public class SerieResultsContainer {

    private Integer page;
    private List<SerieResult> results;
    private Integer total_results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<SerieResult> getResults() {
        return results;
    }

    public void setResults(List<SerieResult> results) {
        this.results = results;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    private Integer total_pages;
}
