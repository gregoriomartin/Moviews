package digitalhouse.android.a0317moacns1c_02.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Controller.GenreController;
import digitalhouse.android.a0317moacns1c_02.Helpers.ActivityStackManager;
import digitalhouse.android.a0317moacns1c_02.R;
import digitalhouse.android.a0317moacns1c_02.Controller.ConfigController;


public class MainActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private boolean configDataLoaded;
    private boolean movieGenresLoaded;
    private boolean serieGenresLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationView = (LottieAnimationView) findViewById(R.id.animationViewMainActivity);
        ActivityStackManager.getInstance().addActivity(this);
        //Carga los datos generales de la API
        //TODO: debería bloquearse la ejecución hasta obtener los datos
        ConfigController.getInstance().loadConfigData(new ResultListener<String>() {
            @Override
            public void finish(String result) {
                configDataLoaded = true;
                startTabsActivity();
            }
        });
        //Carga la lista de generos de peliculas
        //TODO: debería bloquearse la ejecución hasta obtener los datos
        GenreController.getInstance().loadMovieGenres(new ResultListener<String>() {
            @Override
            public void finish(String result) {
                movieGenresLoaded = true;
                startTabsActivity();
            }
        });
        //Carga la lista de generos de peliculas
        //TODO: debería bloquearse la ejecución hasta obtener los datos
        GenreController.getInstance().loadSerieGenres(new ResultListener<String>() {
            @Override
            public void finish(String result) {
                serieGenresLoaded = true;
                startTabsActivity();
            }
        });


    }

    private void startTabsActivity(){
        if(isLoadFinished()){
            Intent intent = new Intent(this, ItemTabsActivity.class);
            startActivity(intent);
        }
    }

    private boolean isLoadFinished(){
        return configDataLoaded && movieGenresLoaded && serieGenresLoaded;
    }

}
