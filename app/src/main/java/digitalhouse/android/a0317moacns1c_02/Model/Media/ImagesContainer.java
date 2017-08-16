package digitalhouse.android.a0317moacns1c_02.Model.Media;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Helpers.ImageMapper;

/**
 * Created by Pablo on 25/05/2017.
 */

public class ImagesContainer implements Parcelable, Serializable {
    private Integer id;
    private ArrayList<ImageData> backdrops;
    private ArrayList<ImageData> posters;

    public ImagesContainer(){
        backdrops = new ArrayList<>();
        posters = new ArrayList<>();
    }

    protected ImagesContainer(Parcel in) {
        backdrops = in.createTypedArrayList(ImageData.CREATOR);
        posters = in.createTypedArrayList(ImageData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(backdrops);
        dest.writeTypedList(posters);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImagesContainer> CREATOR = new Creator<ImagesContainer>() {
        @Override
        public ImagesContainer createFromParcel(Parcel in) {
            return new ImagesContainer(in);
        }

        @Override
        public ImagesContainer[] newArray(int size) {
            return new ImagesContainer[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ImageData> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(ArrayList<ImageData> backdrops) {
        this.backdrops = backdrops;
    }

    public ArrayList<ImageData> getPosters() {
        return posters;
    }

    public void setPosters(ArrayList<ImageData> posters) {
        this.posters = posters;
    }

    public List<String> getURLsList() {
        ArrayList<String> URLsArray = ImageMapper.map(backdrops);
        return URLsArray;
    }
}
