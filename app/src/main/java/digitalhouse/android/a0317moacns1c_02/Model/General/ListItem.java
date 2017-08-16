package digitalhouse.android.a0317moacns1c_02.Model.General;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pablo on 22/05/2017.
 */

public class ListItem implements Parcelable {
    private Integer id;
    private String title;
    private String year;
    private String genres;
    private String rating;
    private String imageURL;
    private String type;

    public ListItem() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected ListItem(Parcel in) {
        id = in.readInt();
        title = in.readString();
        year = in.readString();
        genres = in.readString();
        rating = in.readString();
        imageURL = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(genres);
        dest.writeString(rating);
        dest.writeString(imageURL);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };
}
