package digitalhouse.android.a0317moacns1c_02.DAO;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Callbacks.TMDBCallBack;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Credits;
import digitalhouse.android.a0317moacns1c_02.Model.General.RateOmdb;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieOmdb;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieResultsContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImagesContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieVideos;
import digitalhouse.android.a0317moacns1c_02.Services.ServiceGenerator;
import retrofit2.Call;

/**
 * Created by Pablo on 03/06/2017.
 */

public class MovieDAO {
    private TMDBClient client;
    public MovieDAO() {
        this.client = ServiceGenerator.getInstance().createService(TMDBClient.class, TMDBClient.BASE_URL);
    }
    public void obtainPopular(ResultListener<MovieResultsContainer> resultListener) {
        Call<MovieResultsContainer> call = client.obtainPopularMovies(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<MovieResultsContainer>(resultListener));
    }
    public void obtainNowPlaying(ResultListener<MovieResultsContainer> resultListener) {
        Call<MovieResultsContainer> call = client.obtainNowPlayingMovies(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<MovieResultsContainer>(resultListener));
    }
    public void obtainUpcoming(ResultListener<MovieResultsContainer> resultListener) {
        Call<MovieResultsContainer> call = client.obtainUpcomingMovies(TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<MovieResultsContainer>(resultListener));
    }
    public void obtainDetails(Integer id, ResultListener<MovieDetails> resultListener) {
        Call<MovieDetails> call = client.obtainMovieDetails(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<MovieDetails>(resultListener));
    }
    public void obtainCredits(Integer id, ResultListener<Credits> resultListener) {
        Call<Credits> call = client.obtainMovieCredits(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<Credits>(resultListener));
    }
    public void obtainImages(Integer id, ResultListener<ImagesContainer> resultListener) {
        Call<ImagesContainer> call = client.obtainMovieImages(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<ImagesContainer>(resultListener));
    }
    public void obtainVideos(Integer id, ResultListener<MovieVideos> resultListener) {
        Call<MovieVideos> call = client.obtainMovieVideos(id.toString(), TMDBClient.API_KEY);
        call.enqueue(new TMDBCallBack<MovieVideos>(resultListener));
    }

    public MovieOmdb obtainDetailsShort(String title){
        return mockMovieShort();
    }

    public MovieOmdb obtainDetailsLong(String title){
        return mockMovieLong();
    }

    private MovieOmdb mockMovieLong(){
        MovieOmdb mock = new MovieOmdb();
        mock.setTitle("Wonder Woman");
        mock.setYear("2017");
        mock.setRated("PG-13");
        mock.setReleased("02 Jun 2017");
        mock.setRuntime("141 min");
        mock.setGenre("Action, Adventure, Fantasy");
        mock.setDirector("Patty Jenkins");
        mock.setWriter("Allan Heinberg");
        mock.setActors("Gal Gadot, Chris Pine, Connie Nielsen, Robin Wright");
        mock.setPlot("Before she was Wonder Woman, she was Diana, princess of the Amazons, trained to be an unconquerable warrior. Raised on a sheltered island paradise, when a pilot crashes on their shores and tells of a massive conflict raging in the outside world, Diana leaves her home, convinced she can stop the threat. Fighting alongside man in a war to end all wars, Diana will discover her full powers and her true destiny.");
        mock.setLanguage("English, German");
        mock.setCountry("USA, China, Hong Kong");
        mock.setAwards("1 nomination.");
        mock.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BNDFmZjgyMTEtYTk5MC00NmY0LWJhZjktOWY2MzI5YjkzODNlXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_SX300.jpg");
        mock.setMetascore("76");
        mock.setImdbRating("8.3");
        mock.setImdbVotes("61,125");
        mock.setImdbID("tt0451279");
        mock.setType("movie");
        mock.setDvd("N/A");
        mock.setBoxOffice("$103,251,471");
        mock.setProduction("Warner Bros. Pictures");
        mock.setWebsite("http://wonderwomanfilm.com/");
        ArrayList<RateOmdb> listRatings = new ArrayList<>();
        RateOmdb rate = new RateOmdb();
        rate.setSource("Internet Movie Database");
        rate.setValue("8.3/10");
        listRatings.add(rate);
        rate = new RateOmdb();
        rate.setSource("Rotten Tomatoes");
        rate.setValue("93%");
        listRatings.add(rate);
        rate = new RateOmdb();
        rate.setSource("Metacritic");
        rate.setValue("76/100");
        listRatings.add(rate);
        return mock;
    }

    private MovieOmdb mockMovieShort(){
        MovieOmdb mock = new MovieOmdb();
        mock.setTitle("Wonder Woman");
        mock.setYear("2017");
        mock.setRated("PG-13");
        mock.setReleased("02 Jun 2017");
        mock.setRuntime("141 min");
        mock.setGenre("Action, Adventure, Fantasy");
        mock.setDirector("Patty Jenkins");
        mock.setWriter("Allan Heinberg");
        mock.setActors("Gal Gadot, Chris Pine, Connie Nielsen, Robin Wright");
        mock.setPlot("Before she was Wonder Woman she was Diana, princess of the Amazons, trained warrior. When a pilot crashes and tells of conflict in the outside world, she leaves home to fight a war to end all wars, discovering her full powers and true destiny.");
        mock.setLanguage("English, German");
        mock.setCountry("USA, China, Hong Kong");
        mock.setAwards("1 nomination.");
        mock.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BNDFmZjgyMTEtYTk5MC00NmY0LWJhZjktOWY2MzI5YjkzODNlXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_SX300.jpg");
        mock.setMetascore("76");
        mock.setImdbRating("8.3");
        mock.setImdbVotes("61,125");
        mock.setImdbID("tt0451279");
        mock.setType("movie");
        mock.setDvd("N/A");
        mock.setBoxOffice("$103,251,471");
        mock.setProduction("Warner Bros. Pictures");
        mock.setWebsite("http://wonderwomanfilm.com/");
        ArrayList<RateOmdb> listRatings = new ArrayList<>();
        RateOmdb rate = new RateOmdb();
        rate.setSource("Internet Movie Database");
        rate.setValue("8.3/10");
        listRatings.add(rate);
        rate = new RateOmdb();
        rate.setSource("Rotten Tomatoes");
        rate.setValue("93%");
        listRatings.add(rate);
        rate = new RateOmdb();
        rate.setSource("Metacritic");
        rate.setValue("76/100");
        listRatings.add(rate);
        return mock;
    }
}
