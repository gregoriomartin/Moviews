package digitalhouse.android.a0317moacns1c_02.Services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gregorio Martin on 21/5/2017.
 */

/*The ServiceGenerator class uses Retrofit’s Retrofit builder to create a new REST client with the given API base url (BASE_URL).
For example, GitHub’s API base url is located at https://api.github.com/
 and you must update the provided example url with your own url to call your API instead of GitHub’s.

The createService method takes a serviceClass, which is the annotated interface for API requests,
 as a parameter and creates a usable client from it. On the resulting client you'll be able to execute your network requests.*/
public class ServiceGenerator {

    private static ServiceGenerator instance;

    public static ServiceGenerator getInstance() {
        if (instance==null) instance = new ServiceGenerator();
        return instance;
    }


    public <S> S createService(Class<S> serviceClass, String connectionURL) {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(connectionURL)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();

        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }
}
