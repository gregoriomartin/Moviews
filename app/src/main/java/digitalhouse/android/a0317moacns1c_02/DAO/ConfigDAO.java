package digitalhouse.android.a0317moacns1c_02.DAO;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Configuration.Config;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Pablo on 03/06/2017.
 */

public class ConfigDAO {
    private TMDBClient client;
    public ConfigDAO() {
        this.client = ServiceGenerator.getInstance().createService(TMDBClient.class, TMDBClient.BASE_URL);
    }
    public void obtainConfigData(ResultListener<Config> resultListener) {
        Call<Config> call = client.obtainConfiguration(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<Config>(resultListener));
    }
}
