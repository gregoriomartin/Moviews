package digitalhouse.android.a0317moacns1c_02.DAO;

import java.util.Map;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Pablo on 03/06/2017.
 */

public class SearchDAO {
    private TMDBClient client;


    public SearchDAO() {
        this.client = ServiceGenerator.getInstance().createService(TMDBClient.class, TMDBClient.BASE_URL);
    }

    public void searchMovies(Map<String, String> parameters, ResultListener<MovieResultsContainer> resultListener) {
        Call<MovieResultsContainer> call = client.obtainMovies(parameters);
        call.enqueue(new TMDBCallBack<MovieResultsContainer>(resultListener));
    }

    public void searchSeries(Map<String, String> parameters, ResultListener<SerieResultsContainer> resultListener) {
        Call<SerieResultsContainer> call = client.obtainSeries(parameters);
        call.enqueue(new TMDBCallBack<SerieResultsContainer>(resultListener));
    }

    public void searchPeople(Map<String, String> parameters, ResultListener<PersonResultsContainer> resultListener) {
        Call<PersonResultsContainer> call = client.obtainPeople(parameters);
        call.enqueue(new TMDBCallBack<PersonResultsContainer>(resultListener));
    }
}
