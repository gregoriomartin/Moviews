package digitalhouse.android.a0317moacns1c_02.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Activities.SearchActivity;

/**
 * Created by Gregorio Martin on 27/5/2017.
 */

public class SearchPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public SearchPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        fragments = new ArrayList<>();
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public List<Fragment> getFragments() {
        return fragments;
    }
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
