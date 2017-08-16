package digitalhouse.android.a0317moacns1c_02.Model.Configuration;

import java.util.ArrayList;

/**
 * Created by Pablo on 22/05/2017.
 */

// datos de las imagenes (base url y tamaños disponibles)

public class ImageConfig {
    private String base_url;
    private ArrayList<String> poster_sizes;
    private ArrayList<String> backdrop_sizes;
    private ArrayList<String> profile_sizes;

    public String getBase_url() {
        return base_url;
    }

    public ArrayList<String> getPoster_sizes() {
        return poster_sizes;
    }

    public ArrayList<String> getBackdrop_sizes() {
        return backdrop_sizes;
    }

    public ArrayList<String> getProfile_sizes() {
        return profile_sizes;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public void setPoster_sizes(ArrayList<String> poster_sizes) {
        this.poster_sizes = poster_sizes;
    }

    public void setBackdrop_sizes(ArrayList<String> backdrop_sizes) {
        this.backdrop_sizes = backdrop_sizes;
    }

    public void setProfile_sizes(ArrayList<String> profile_sizes) {
        this.profile_sizes = profile_sizes;
    }
}
