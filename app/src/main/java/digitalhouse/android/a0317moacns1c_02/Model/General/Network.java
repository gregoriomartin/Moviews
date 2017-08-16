package digitalhouse.android.a0317moacns1c_02.Model.General;

import java.io.Serializable;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Model.Misc.Company;

/**
 * Created by Gregorio Martin on 11/6/2017.
 */

public class Network implements Serializable {
    protected Integer id;
    protected String name;

    public Network(){

    }

    public Network(Integer id, String name) {
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

    public static String getNetworksInString(List<Network> networkList, String separator){
        String companies = "";
        if (!networkList.isEmpty()) {
            companies = networkList.get(0).getName();
            for (int i=1; i<networkList.size(); i++) {
                companies += separator + networkList.get(i).getName();
            }
        }
        return companies;
    }
}
