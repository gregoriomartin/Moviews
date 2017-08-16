package digitalhouse.android.a0317moacns1c_02.Model.Genres;

import java.io.Serializable;

/**
 * Created by Pablo on 22/05/2017.
 */

public class Genre implements Serializable {
    private Integer id;
    private String name;

    public Genre(){

    }

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
