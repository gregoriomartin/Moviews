package digitalhouse.android.a0317moacns1c_02.DAO;

import java.io.IOException;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.SeriesClient;
import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Credits;
import digitalhouse.android.a0317moacns1c_02.Model.General.ExternalIDs;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImagesContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Media.VideoContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SeasonDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieOmdb;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Gregorio Martin on 4/6/2017.
 */

public class SerieDAO {
    private SeriesClient client;

    public SerieDAO() {
        this.client = ServiceGenerator.getInstance().createService(SeriesClient.class, TMDBClient.BASE_URL);
    }

    public void obtainPopular(ResultListener<SerieResultsContainer> resultListener){
        Call<SerieResultsContainer> call = client.obtainPopularSeries(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<SerieResultsContainer>(resultListener));
    }

    public void obtainTopRated(ResultListener<SerieResultsContainer> resultListener) {
        Call<SerieResultsContainer> call = client.obtainTopRatedSeries(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<SerieResultsContainer>(resultListener));
    }

    public void obtainAiringToday(ResultListener<SerieResultsContainer> resultListener) {
        Call<SerieResultsContainer> call = client.obtainAiringTodaySeries(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<SerieResultsContainer>(resultListener));
    }

    public void obtainDetails(String ID, ResultListener<SerieDetails> resultListener){
        Call<SerieDetails> call = client.obtainDetails(ID, TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<SerieDetails>(resultListener));
    }

    public void obtainImages(String ID, ResultListener<ImagesContainer> resultListener){
        Call<ImagesContainer> call = client.obtainImages(ID, TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<ImagesContainer>(resultListener));
    }

    public void obtainCredits(String ID, ResultListener<Credits> resultListener){
        Call<Credits> call = client.obtainCredits(ID, TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<Credits>(resultListener));
    }

    public void obtainVideos(String ID, ResultListener<VideoContainer> resultListener){
        Call<VideoContainer> call = client.obtainVideos(ID, TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<VideoContainer>(resultListener));
    }

    public VideoContainer obtainVideos(String ID){
        VideoContainer videoContainer;
        try {
            Call<VideoContainer> call = client.obtainVideos(ID, SeriesClient.API_KEY);
            videoContainer = call.execute().body();
            return videoContainer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoContainer = new VideoContainer();
        return videoContainer;
    }

    public ImagesContainer obtainImages(String ID){
        ImagesContainer imagesContainer;
        try {
            Call<ImagesContainer> call = client.obtainImages(ID, SeriesClient.API_KEY);
            imagesContainer = call.execute().body();
            return imagesContainer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagesContainer = new ImagesContainer();
        return imagesContainer;
    }

    public SerieDetails obtainDetails(String ID){
        SerieDetails serieDetails;
        try {
            Call<SerieDetails> call = client.obtainDetails(ID, SeriesClient.API_KEY);
            serieDetails = call.execute().body();
            return serieDetails;
        } catch (IOException e) {
            e.printStackTrace();
        }
        serieDetails = new SerieDetails();
        return serieDetails;
    }

    public Credits obtainCredits(String ID){
        Credits credits;
        try {
            Call<Credits> call = client.obtainCredits(ID, SeriesClient.API_KEY);
            credits = call.execute().body();
            return credits;
        } catch (IOException e) {
            e.printStackTrace();
        }
        credits = new Credits();
        return credits;
    }

    public SeasonDetails obtainSeasonDetails(String serieID, String seasonNumber){
        SeasonDetails seasonDetails;
        try{
            Call<SeasonDetails> call = client.obtainSeasonDetails(serieID, seasonNumber, SeriesClient.API_KEY);
            seasonDetails = call.execute().body();
            return seasonDetails;
        } catch (IOException e){
            e.printStackTrace();
        }
        seasonDetails = new SeasonDetails();
        return seasonDetails;
    }

    public Credits obtainSeasonCredits(String serieID, String seasonNumber){
        Credits credits;
        try{
            Call<Credits> call = client.obtainSeasonCredits(serieID, seasonNumber, SeriesClient.API_KEY);
            credits = call.execute().body();
            return credits;
        } catch (IOException e){
            e.printStackTrace();
        }
        credits = new Credits();
        return credits;
    }

    public ImagesContainer obtainSeasonImages(String serieID, String seasonNumber){
        ImagesContainer images;
        try{
            Call<ImagesContainer> call = client.obtainSeasonImages(serieID, seasonNumber, SeriesClient.API_KEY);
            images = call.execute().body();
            return images;
        } catch (IOException e){
            e.printStackTrace();
        }
        images = new ImagesContainer();
        return images;
    }

    public VideoContainer obtainSeasonVideos(String serieID, String seasonNumber){
        VideoContainer videoContainer;
        try{
            Call<VideoContainer> call = client.obtainSeasonVideos(serieID, seasonNumber, SeriesClient.API_KEY);
            videoContainer = call.execute().body();
            return videoContainer;
        } catch (IOException e){
            e.printStackTrace();
        }
        videoContainer = new VideoContainer();
        return videoContainer;
    }

    public ExternalIDs obtainExternalIDs(String serieID, String seasonNumber){
        ExternalIDs externalIDs;
        try{
            Call<ExternalIDs> call = client.obtainExternalIDs(serieID, seasonNumber, SeriesClient.API_KEY);
            externalIDs = call.execute().body();
            return externalIDs;
        } catch (IOException e){
            e.printStackTrace();
        }
        externalIDs = new ExternalIDs();
        return externalIDs;
    }



    public SerieOmdb obtainDetailsLong(String title){
        return mockSerieLong();
    }

    public SerieOmdb obtainDetailsShort(String title){
        return mockSerieShort();
    }

    public SerieOmdb obtainDetailsLong(Integer imdbID){
        return mockSerieLong();
    }

    public SerieOmdb obtainDetailsShort(Integer imdbID){
        return mockSerieShort();
    }

    private SerieOmdb mockSerieShort(){
        SerieOmdb mock = new SerieOmdb();
        mock.setTitle("Breaking Bad");
        mock.setYear("2008–2013");
        mock.setRated("TV-14");
        mock.setReleased("20 Jan 2008");
        mock.setRuntime("49 min");
        mock.setGenre("Crime, Drama, Thriller");
        mock.setDirector("N/A");
        mock.setWriter("Vince Gilligan");
        mock.setActors("Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris");
        mock.setPlot("A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.");
        mock.setLanguage("English, Spanish");
        mock.setCountry("USA");
        mock.setAwards("Won 2 Golden Globes. Another 139 wins & 223 nominations.");
        mock.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BZDNhNzhkNDctOTlmOS00NWNmLWEyODQtNWMxM2UzYmJiNGMyXkEyXkFqcGdeQXVyNTMxMjgxMzA@._V1_SX300.jpg");
        mock.setMetascore("N/A");
        mock.setImdbRating("9.5");
        mock.setImdbVotes("983,682");
        mock.setImdbID("tt0903747");
        mock.setType("series");
        mock.setTotalSeasons("5");
        return mock;
    }

    private SerieOmdb mockSerieLong(){
        SerieOmdb mock = new SerieOmdb();
        mock.setTitle("Breaking Bad");
        mock.setYear("2008–2013");
        mock.setRated("TV-14");
        mock.setReleased("20 Jan 2008");
        mock.setRuntime("49 min");
        mock.setGenre("Crime, Drama, Thriller");
        mock.setDirector("N/A");
        mock.setWriter("Vince Gilligan");
        mock.setActors("Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris");
        mock.setPlot("When chemistry teacher Walter White is diagnosed with Stage III cancer and given only two years to live, he decides he has nothing to lose. He lives with his teenage son, who has cerebral palsy, and his wife, in New Mexico. Determined to ensure that his family will have a secure future, Walt embarks on a career of drugs and crime. He proves to be remarkably proficient in this new world as he begins manufacturing and selling methamphetamine with one of his former students. The series tracks the impacts of a fatal diagnosis on a regular, hard working man, and explores how a fatal diagnosis affects his morality and transforms him into a major player of the drug trade.");
        mock.setLanguage("English, Spanish");
        mock.setCountry("USA");
        mock.setAwards("Won 2 Golden Globes. Another 139 wins & 223 nominations.");
        mock.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BZDNhNzhkNDctOTlmOS00NWNmLWEyODQtNWMxM2UzYmJiNGMyXkEyXkFqcGdeQXVyNTMxMjgxMzA@._V1_SX300.jpg");
        mock.setMetascore("N/A");
        mock.setImdbRating("9.5");
        mock.setImdbVotes("983,682");
        mock.setImdbID("tt0903747");
        mock.setType("series");
        mock.setTotalSeasons("5");
        return mock;
    }

}
