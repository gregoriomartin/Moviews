package digitalhouse.android.a0317moacns1c_02.Model.Movie;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;

/**
 * Created by Pablo on 22/05/2017.
 */

public class MovieResultsContainer {
    private Integer page;
    private ArrayList<MovieResult> results;
    private Integer total_results;
    private Integer total_pages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<MovieResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieResult> results) {
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
}
