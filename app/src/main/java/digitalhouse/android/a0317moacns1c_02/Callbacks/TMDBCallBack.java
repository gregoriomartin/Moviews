package digitalhouse.android.a0317moacns1c_02.Callbacks;

import android.util.Log;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pablo on 03/06/2017.
 */

public class TMDBCallBack<T> implements Callback<T> {
    private ResultListener<T> resultListener;

    public TMDBCallBack(ResultListener<T> resultListener) {
        this.resultListener = resultListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        resultListener.finish(response.body());
    }

    // aquí se deberían handlear los errores de la API
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("Error", t.getMessage());
    }
}
