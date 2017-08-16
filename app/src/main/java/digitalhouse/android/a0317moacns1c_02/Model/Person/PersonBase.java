package digitalhouse.android.a0317moacns1c_02.Model.Person;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Gregorio Martin on 11/6/2017.
 */

public class PersonBase implements Parcelable, Serializable {

    protected Integer id;
    protected Integer gender;
    protected String profile_path;
    protected String name;

    protected PersonBase(Parcel in) {
        profile_path = in.readString();
        name = in.readString();
        gender = in.readInt();
        id = in.readInt();
        name = in.readString();
    }

    public PersonBase(){

    }

    public static final Creator<PersonBase> CREATOR = new Creator<PersonBase>() {
        @Override
        public PersonBase createFromParcel(Parcel in) {
            return new PersonBase(in);
        }

        @Override
        public PersonBase[] newArray(int size) {
            return new PersonBase[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(profile_path);
        dest.writeInt(gender);
        dest.writeInt(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
