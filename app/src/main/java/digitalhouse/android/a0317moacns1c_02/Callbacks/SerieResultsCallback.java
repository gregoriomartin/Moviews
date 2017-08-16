package digitalhouse.android.a0317moacns1c_02.Callbacks;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Helpers.ListItemMapper;
import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieResultsContainer;

/**
 * Created by Pablo on 10/06/2017.
 */

public class SerieResultsCallback implements ResultListener<SerieResultsContainer> {
    private ResultListener<ArrayList<ListItem>> resultListener;

    public SerieResultsCallback(ResultListener<ArrayList<ListItem>> resultListener) {
        this.resultListener = resultListener;
    }

    @Override
    public void finish(SerieResultsContainer serieResults) {
        resultListener.finish(ListItemMapper.map(serieResults.getResults()));
    }
}
