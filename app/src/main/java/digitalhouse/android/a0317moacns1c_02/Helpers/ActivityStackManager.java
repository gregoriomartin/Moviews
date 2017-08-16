package digitalhouse.android.a0317moacns1c_02.Helpers;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Activities.MainActivity;

/**
 * Created by Pablo on 29/05/2017.
 */

public class ActivityStackManager {
    // El próposito de esta clase es almacenar un stack de activities para ir cerrandolas
    // una vez que se alcanza el máximo de activities que pueden estar abiertas
    // para ello en las activities que se quieran limitar (por ejemplo MovieDetailsActivity,
    // PersonDetailsActivity) se debe agregar al onCreate:

    // ActivityStackManager.getInstance().addActivity(this)

    // y al onDestroy:

    // ActivityStackManager.getInstance().removeLastActivity();

    // De esta manera el manager va a llamar al método finish() de la actividad más vieja
    // una vez que la cantidad de activities supera el máximo permitido.

    // aqui se puede setear el máximo de activities que pueden estar abiertas
    private final Integer maxActivities = 3;

    private static ActivityStackManager instance;
    private List<Activity> activities;

    public ActivityStackManager() {
        activities = new ArrayList<>();
    }

    public static ActivityStackManager getInstance() {
        if (instance == null) instance = new ActivityStackManager();
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
        if (activities.size()>maxActivities) {
            activities.get(0).finish();
            activities.remove(0);
        }
    }

    public void removeLastActivity() {
        if (activities.size()>0) activities.remove(activities.size()-1);
    }

    public void removeMainActivity() {
        for(Activity activity : activities){
            if(activity instanceof MainActivity) activity.finish();
        }
    }
}
