package digitalhouse.android.a0317moacns1c_02.Controller;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.DAO.ConfigDAO;
import digitalhouse.android.a0317moacns1c_02.Model.Configuration.Config;

/**
 * Created by Pablo on 22/05/2017.
 */



public class ConfigController {
    private static ConfigController instance;
    private ConfigDAO configDAO;
    private String imagesBaseURL;
    private ArrayList<String> posterSizes;
    private ArrayList<String> backdropSizes;
    private ArrayList<String> profileSizes;
    private ArrayList<String> changeKeys;


    private ConfigController() {
        this.configDAO = new ConfigDAO();
    }

    public String getImagesBaseURL() {
        return imagesBaseURL;
    }

    public ArrayList<String> getPosterSizes() {
        return posterSizes;
    }

    public ArrayList<String> getBackdropSizes() { return backdropSizes; }

    public ArrayList<String> getProfileSizes() {
        return profileSizes;
    }

    public ArrayList<String> getChangeKeys() {
        return changeKeys;
    }

    public static ConfigController getInstance() {
        if (instance == null) instance = new ConfigController();
        return instance;
    }

    public void loadConfigData(final ResultListener<String> resultListener) {
        //obtener datos config
        configDAO.obtainConfigData(new ResultListener<Config>() {
            @Override
            public void finish(Config config) {
                imagesBaseURL = config.getImages().getBase_url();
                posterSizes = config.getImages().getPoster_sizes();
                backdropSizes = config.getImages().getBackdrop_sizes();
                profileSizes = config.getImages().getProfile_sizes();
                changeKeys = config.getChange_keys();
                resultListener.finish("Config OK");
            }
        });
    }
}
