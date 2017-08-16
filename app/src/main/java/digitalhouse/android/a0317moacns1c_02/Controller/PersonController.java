package digitalhouse.android.a0317moacns1c_02.Controller;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageData;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonCastCreditItem;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonCrewCreditItem;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonImages;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonMovieCredits;
import digitalhouse.android.a0317moacns1c_02.DAO.PersonDAO;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;

/**
 * Created by Pablo on 03/06/2017.
 */

public class PersonController {
    private PersonDAO personDAO;
    private static PersonController instance;

    public static PersonController getInstance() {
        if (instance == null) instance = new PersonController();
        return instance;
    }

    public PersonController() {personDAO = new PersonDAO();}

    public void getDetails(Integer id, ResultListener<PersonDetails> resultListener) {
        personDAO.obtainDetails(id, resultListener);
    }

    public void getImageList(Integer id, final ResultListener<ArrayList<ImageListItem>> resultListener) {
        personDAO.obtainImages(id, new ResultListener<PersonImages>() {
            @Override
            public void finish(PersonImages personImages) {
                ArrayList<ImageListItem> imageList = new ArrayList<>();
                for (ImageData imageData : personImages.getProfiles()) {
                    ImageListItem imageListItem = new ImageListItem();
                    imageListItem.setImagePath(imageData.getFile_path());
                    imageListItem.setImageURL(ImageHelper.getProfileURL(imageData.getFile_path(), 1));
                    imageListItem.setId(0);
                    imageList.add(imageListItem);
                }
                // saca la primer imagen porque es igual a la de la foto de perfil
                if (imageList.size()>0) imageList.remove(0);
                resultListener.finish(imageList);
            }
        });
    }

    public void getMovieCreditsImageList(Integer id, final ResultListener<ArrayList<ImageListItem>> resultListener) {
        personDAO.obtainMovieCredits(id, new ResultListener<PersonMovieCredits>() {
            @Override
            public void finish(PersonMovieCredits movieCredits) {
                ArrayList<ImageListItem> imageList = new ArrayList<ImageListItem>();
                for (PersonCastCreditItem cast : movieCredits.getCast()) {
                    ImageListItem imageListItem = new ImageListItem();
                    imageListItem.setId(cast.getId());
                    imageListItem.setTitle(cast.getTitle());
                    imageListItem.setSubtitle(cast.getCharacter());
                    imageListItem.setImageURL(ImageHelper.getPosterURL(cast.getPoster_path(), 1));
                    imageList.add(imageListItem);
                }
                for (PersonCrewCreditItem crew : movieCredits.getCrew()) {
                    ImageListItem imageListItem = new ImageListItem();
                    imageListItem.setId(crew.getId());
                    imageListItem.setTitle(crew.getTitle());
                    imageListItem.setSubtitle(crew.getJob());
                    imageListItem.setImageURL(ImageHelper.getPosterURL(crew.getPoster_path(), 1));
                    imageList.add(imageListItem);
                }
                resultListener.finish(imageList);
            }
        });
    }


}
