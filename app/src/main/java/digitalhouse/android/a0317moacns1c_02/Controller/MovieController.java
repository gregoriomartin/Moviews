package digitalhouse.android.a0317moacns1c_02.Controller;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Callbacks.MovieResultsCallback;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Cast;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Credits;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImagesContainer;
import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageData;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageListItem;
import digitalhouse.android.a0317moacns1c_02.DAO.MovieDAO;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageMapper;
import digitalhouse.android.a0317moacns1c_02.Model.Movie.MovieDetails;

/**
 * Created by Pablo on 03/06/2017.
 */

public class MovieController {
    private MovieDAO movieDAO;
    private static MovieController instance;

    public static MovieController getInstance() {
        if (instance == null) instance = new MovieController();
        return instance;
    }

    public MovieController() {
        movieDAO = new MovieDAO();
    }

    public void getPopular(ResultListener<ArrayList<ListItem>> resultListener) {
        movieDAO.obtainPopular(new MovieResultsCallback(resultListener));
    }
    public void getNowPlaying(ResultListener<ArrayList<ListItem>> resultListener) {
        movieDAO.obtainNowPlaying(new MovieResultsCallback(resultListener));
    }
    public void getUpcoming(ResultListener<ArrayList<ListItem>> resultListener) {
        movieDAO.obtainUpcoming(new MovieResultsCallback(resultListener));
    }

    public void getDetails(Integer id, ResultListener<MovieDetails> resultListener) {
        movieDAO.obtainDetails(id, resultListener);
    }

    public void getImages(Integer id, ResultListener<ImagesContainer> resultListener) {
        movieDAO.obtainImages(id, resultListener);
    }

    public void getBackdropsURLs(Integer id, final ResultListener<List<String>> resultListener) {
        getImages(id, new ResultListener<ImagesContainer>() {
            @Override
            public void finish(ImagesContainer imagesContainer) {
                List<ImageData> imageList = imagesContainer.getBackdrops();
                ArrayList<String> URLsArray = ImageMapper.map(imageList);
                resultListener.finish(URLsArray);
            }
        });
    }

    public void getCredits(Integer id, ResultListener<Credits> resultListener) {
        movieDAO.obtainCredits(id, resultListener);
    }

    public ArrayList<ImageListItem> getCastImageList(Credits credits) {
        ArrayList<ImageListItem> imageList = new ArrayList<>();
        for (Cast cast : credits.getCast()) {
            ImageListItem imageListItem = new ImageListItem();
            imageListItem.setId(cast.getId());
            imageListItem.setTitle(cast.getName());
            imageListItem.setSubtitle(cast.getCharacter());
            String url = ImageHelper.getProfileURL(cast.getProfile_path(), 1);
            imageListItem.setImageURL(url);
            imageList.add(imageListItem);
        }
        return imageList;
    }

}
