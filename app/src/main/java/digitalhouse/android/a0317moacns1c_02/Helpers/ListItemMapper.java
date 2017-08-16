package digitalhouse.android.a0317moacns1c_02.Helpers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Controller.GenreController;
import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieResult;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonResult;
import digitalhouse.android.a0317moacns1c_02.Model.Series.SerieResult;

/**
 * Created by Pablo on 09/06/2017.
 */

public class ListItemMapper {
    // mapeo MovieResult a ListItem
    public static ListItem map(MovieResult movie){
        ListItem item = new ListItem();
        item.setId(movie.getId());
        item.setTitle(movie.getTitle());
        item.setGenres(GenreController.getInstance().getMovieGenresStringbyIds(movie.getGenre_ids(), ", "));
        item.setYear(movie.getYear());
        item.setRating(movie.getVote_average().toString());
        item.setImageURL(ImageHelper.getPosterURL(movie.getPoster_path(),1));
        item.setType("movie");
        return item;
    }
    // mapeo SerieResult a ListItem
    public static ListItem map(SerieResult serie){
        ListItem item = new ListItem();
        item.setId(serie.getId());
        item.setTitle(serie.getName());
        item.setGenres(GenreController.getInstance().getSerieGenresStringbyIds(serie.getGenreIds(), ", "));
        item.setYear(serie.getYear());
        DecimalFormat df = new DecimalFormat("#.0");
        item.setRating(df.format(serie.getVoteAverage()));
        item.setImageURL(ImageHelper.getPosterURL(serie.getPosterPath(),1));
        item.setType("serieDetails");
        return item;
    }
    // mapeo PersonResult a ListItem
    public static ListItem map(PersonResult person) {
        ListItem item = new ListItem();
        item.setId(person.getId());
        item.setTitle(person.getName());
        DecimalFormat df = new DecimalFormat("#.0");
        item.setRating(df.format(person.getPopularity()));
        item.setImageURL(ImageHelper.getProfileURL(person.getProfile_path(),1));
        item.setType("person");
        return item;
    }


    //mapeo de listas
    public static <T> ArrayList<ListItem> map(List<T> results) {
        ArrayList<ListItem> listItems = new ArrayList<>();
        for (T result : results) {
            if (result instanceof MovieResult) listItems.add(map((MovieResult)result));
            if (result instanceof SerieResult) listItems.add(map((SerieResult)result));
            if (result instanceof PersonResult) listItems.add(map((PersonResult)result));
        }
        return listItems;
    }
}
