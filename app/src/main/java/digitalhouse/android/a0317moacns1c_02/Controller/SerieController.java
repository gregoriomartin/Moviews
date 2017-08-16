package digitalhouse.android.a0317moacns1c_02.Controller;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.SerieResultsCallback;
import digitalhouse.android.a0317moacns1c_02.DAO.SerieDAO;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Credits;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImagesContainer;
import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Media.VideoContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Series.Season;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SeasonDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Series.Serie;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieOmdb;

/**
 * Created by Gregorio Martin on 4/6/2017.
 */

public class SerieController {
    private SerieDAO seriesDAO;
    private static SerieController instance;

    public static SerieController getInstance(){
        if(instance == null) instance = new SerieController();
        return instance;
    }

    protected SerieController(){
        this.seriesDAO = new SerieDAO();
    }

    public void getPopular(ResultListener<ArrayList<ListItem>> resultListener) {
        seriesDAO.obtainPopular(new SerieResultsCallback(resultListener));
    }
    public void getTopRated(ResultListener<ArrayList<ListItem>> resultListener) {
        seriesDAO.obtainTopRated(new SerieResultsCallback(resultListener));
    }
    public void getAiringToday(ResultListener<ArrayList<ListItem>> resultListener) {
        seriesDAO.obtainAiringToday(new SerieResultsCallback(resultListener));
    }
    public void getDetails(String ID, ResultListener<SerieDetails> resultListener){
        seriesDAO.obtainDetails(ID, resultListener);
    }

    public void getImages(String ID, ResultListener<ImagesContainer> resultListener){
        seriesDAO.obtainImages(ID, resultListener);
    }

    public void getCredits(String ID, ResultListener<Credits> resultListener){
        seriesDAO.obtainCredits(ID, resultListener);
    }

    public void getVideos(String ID, ResultListener<VideoContainer> resultListener){
        seriesDAO.obtainVideos(ID, resultListener);
    }

    public SerieOmdb getSerieOmdbShort(String title){
        return seriesDAO.obtainDetailsShort(title);
    }

    public Serie getSerieSync(String ID){
        Serie serie = new Serie();
        serie.setVideoContainer(seriesDAO.obtainVideos(ID));
        serie.setImagesContainer(seriesDAO.obtainImages(ID));
        serie.setSerieDetails(seriesDAO.obtainDetails(ID));
        serie.setSerieOmdb(seriesDAO.obtainDetailsShort(ID));
        serie.setCredits(seriesDAO.obtainCredits(ID));
        serie.setVideoContainer(seriesDAO.obtainVideos(ID));
        return serie;
    }

    public Season getSeasonSync(String ID, String seasonNumber){
        Season season = new Season();
        season.setSeasonDetails(seriesDAO.obtainSeasonDetails(ID, seasonNumber));
        return season;
    }
}
