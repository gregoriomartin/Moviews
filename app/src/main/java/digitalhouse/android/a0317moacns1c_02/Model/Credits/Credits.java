package digitalhouse.android.a0317moacns1c_02.Model.Credits;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Fragments.ImageListFragment;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageListItem;

/**
 * Created by Pablo on 25/05/2017.
 */

public class Credits implements Parcelable, Serializable {
    private Integer id;
    private ArrayList<Cast> cast;
    private ArrayList<Crew> crew;

    public Credits(){

    }

    protected Credits(Parcel in) {
        cast = in.createTypedArrayList(Cast.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cast);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Credits> CREATOR = new Creator<Credits>() {
        @Override
        public Credits createFromParcel(Parcel in) {
            return new Credits(in);
        }

        @Override
        public Credits[] newArray(int size) {
            return new Credits[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public ArrayList<Crew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<Crew> crew) {
        this.crew = crew;
    }

    public ArrayList<ImageListItem> getImageListItems(){
        ArrayList<ImageListItem> imageList = new ArrayList<>();
        for (Cast castPerson : cast) {
            ImageListItem imageListItem = new ImageListItem();
            imageListItem.setId(castPerson.getId());
            imageListItem.setTitle(castPerson.getName());
            imageListItem.setSubtitle(castPerson.getCharacter());
            String url = ImageHelper.getProfileURL(castPerson.getProfile_path(), 1);
            imageListItem.setImageURL(url);
            imageList.add(imageListItem);
        }
        return imageList;
    }

}
