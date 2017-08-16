package digitalhouse.android.a0317moacns1c_02.Model.Person;

import java.util.ArrayList;

/**
 * Created by Pablo on 28/05/2017.
 */

public class PersonMovieCredits {
    private Integer id;
    private ArrayList<PersonCastCreditItem> cast;
    private ArrayList<PersonCrewCreditItem> crew;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<PersonCastCreditItem> getCast() {
        return cast;
    }

    public void setCast(ArrayList<PersonCastCreditItem> cast) {
        this.cast = cast;
    }

    public ArrayList<PersonCrewCreditItem> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<PersonCrewCreditItem> crew) {
        this.crew = crew;
    }
}
