package digitalhouse.android.a0317moacns1c_02.Model.Configuration;

import java.util.ArrayList;

/**
 * Created by Pablo on 21/05/2017.
 */

// configuracion de imagenes y change keys

public class Config {
    private ImageConfig images; // la API devuelve un objeto con la config de las imagenes
    private ArrayList<String> change_keys;

    public ImageConfig getImages() {
        return images;
    }

    public ArrayList<String> getChange_keys() {
        return change_keys;
    }

    public void setImages(ImageConfig images) {
        this.images = images;
    }

    public void setChange_keys(ArrayList<String> change_keys) {
        this.change_keys = change_keys;
    }
}
