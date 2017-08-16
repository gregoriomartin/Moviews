package digitalhouse.android.a0317moacns1c_02.DAO;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Genres.Genres;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Pablo on 03/06/2017.
 */

public class GenreDAO {
    private TMDBClient client;
    public GenreDAO() {
        this.client = ServiceGenerator.getInstance().createService(TMDBClient.class, TMDBClient.BASE_URL);
    }
    public void obtainMovieGenres(ResultListener<Genres> resultListener) {
        Call<Genres> call = client.obtainMovieGenres(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<Genres>(resultListener));
    }
    public void obtainSerieGenres(ResultListener<Genres> resultListener) {
        Call<Genres> call = client.obtainSerieGenres(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<Genres>(resultListener));
    }
}
