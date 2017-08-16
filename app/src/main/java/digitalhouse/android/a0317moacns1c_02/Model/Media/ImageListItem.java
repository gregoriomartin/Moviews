package digitalhouse.android.a0317moacns1c_02.Model.Media;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.io.Serializable;

/**
 * Created by Pablo on 26/05/2017.
 */

public class ImageListItem implements Parcelable, View.OnClickListener, Serializable {
    private Integer id;
    private String title;
    private String subtitle;
    private String imageURL;
    private String imagePath;

    public ImageListItem() {
    }

    protected ImageListItem(Parcel in) {
        id = in.readInt();
        title = in.readString();
        subtitle = in.readString();
        imageURL = in.readString();
        imagePath = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(imageURL);
        dest.writeString(imagePath);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageListItem> CREATOR = new Creator<ImageListItem>() {
        @Override
        public ImageListItem createFromParcel(Parcel in) {
            return new ImageListItem(in);
        }

        @Override
        public ImageListItem[] newArray(int size) {
            return new ImageListItem[size];
        }
    };

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void onClick(View v) {

    }
}
