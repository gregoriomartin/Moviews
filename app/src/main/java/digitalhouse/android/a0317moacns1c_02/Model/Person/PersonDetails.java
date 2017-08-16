package digitalhouse.android.a0317moacns1c_02.Model.Person;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import digitalhouse.android.a0317moacns1c_02.Helpers.DateHelper;

/**
 * Created by Pablo on 27/05/2017.
 */

public class PersonDetails extends PersonBase implements Parcelable {
    public static final String tag = "personDetails";
    private Boolean adult;
    private String biography;
    private String birthday;
    private String deathday;
    private String homepage;
    private String imdb_id;
    private String place_of_birth;
    private Double popularity;

    protected PersonDetails(Parcel in) {
        super(in);
        biography = in.readString();
        birthday = in.readString();
        deathday = in.readString();
        homepage = in.readString();
        imdb_id = in.readString();
        name = in.readString();
        place_of_birth = in.readString();
        profile_path = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(biography);
        dest.writeString(birthday);
        dest.writeString(deathday);
        dest.writeString(homepage);
        dest.writeString(imdb_id);
        dest.writeString(name);
        dest.writeString(place_of_birth);
        dest.writeString(profile_path);
        dest.writeInt(gender);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PersonDetails> CREATOR = new Creator<PersonDetails>() {
        @Override
        public PersonDetails createFromParcel(Parcel in) {
            return new PersonDetails(in);
        }

        @Override
        public PersonDetails[] newArray(int size) {
            return new PersonDetails[size];
        }
    };

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public Date getBirthdayDate() {
        return DateHelper.parse(birthday, DateHelper.FORMAT_API);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public Date getDeathdayDate() {
        return DateHelper.parse(deathday, DateHelper.FORMAT_API);
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
