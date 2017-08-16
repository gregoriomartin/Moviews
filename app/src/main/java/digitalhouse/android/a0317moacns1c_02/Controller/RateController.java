package digitalhouse.android.a0317moacns1c_02.Controller;

import digitalhouse.android.a0317moacns1c_02.Fragments.RateFragment;
import digitalhouse.android.a0317moacns1c_02.Model.General.RatingsContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Series.Serie;

/**
 * Created by forev on 15-Jun-17.
 */

public class RateController {

    public static RateFragment instanceRateFragment(Serie serie){
        RatingsContainer ratingsContainer = new RatingsContainer();
        ratingsContainer.setImdbMaxRate("/10");
        ratingsContainer.setImdbRate(serie.getImdbRating());
        ratingsContainer.setTmdbMaxRate("/10");
        ratingsContainer.setTmdbRate(serie.getTmdbRating());
        if(serie.getMetascore() != null && serie.getMetascore() != "N/A"){
            ratingsContainer.setMetascore(serie.getMetascore());
            ratingsContainer.setMaxMetascore("100");
        }
        return RateFragment.newInstance(ratingsContainer);
    }

    //temp
    public static RateFragment instanceRateFragment(MovieDetails movieDetails){
        RatingsContainer ratingsContainer = new RatingsContainer();
        ratingsContainer.setImdbMaxRate("/10");
        ratingsContainer.setImdbRate("8");
        ratingsContainer.setTmdbMaxRate("/10");
        ratingsContainer.setTmdbRate(movieDetails.getVote_average());
        ratingsContainer.setMetascore("83");
        ratingsContainer.setMaxMetascore("100");
        ratingsContainer.setRottenTomatoesPercentage("100");
        return RateFragment.newInstance(ratingsContainer);
    }

}
