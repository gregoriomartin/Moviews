package digitalhouse.android.a0317moacns1c_02.Model.Person;

import java.util.ArrayList;

import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageData;

/**
 * Created by Pablo on 25/05/2017.
 */

public class PersonImages {
    private Integer id;
    private ArrayList<ImageData> profiles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ImageData> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<ImageData> profiles) {
        this.profiles = profiles;
    }
}
