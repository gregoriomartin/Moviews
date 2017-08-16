package digitalhouse.android.a0317moacns1c_02.DAO;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonImages;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonMovieCredits;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Pablo on 03/06/2017.
 */

public class PersonDAO {
    private TMDBClient client;
    public PersonDAO() {
        client = ServiceGenerator.getInstance().createService(TMDBClient.class, TMDBClient.BASE_URL);
    }
    public void obtainDetails(Integer id, ResultListener<PersonDetails> resultListener) {
        Call<PersonDetails> call = client.obtainPersonDetails(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<PersonDetails>(resultListener));
    }
    public void obtainImages(Integer id, ResultListener<PersonImages> resultListener) {
        Call<PersonImages> call = client.obtainPersonImages(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<PersonImages>(resultListener));
    }
    public void obtainMovieCredits(Integer id, ResultListener<PersonMovieCredits> resultListener) {
        Call<PersonMovieCredits> call = client.obtainPersonMovieCredits(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<PersonMovieCredits>(resultListener));
    }
}
