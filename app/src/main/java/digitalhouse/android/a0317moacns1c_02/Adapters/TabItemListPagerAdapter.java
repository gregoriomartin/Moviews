package digitalhouse.android.a0317moacns1c_02.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import digitalhouse.android.a0317moacns1c_02.Fragments.ItemListFragment;

/**
 * Created by Pablo on 23/05/2017.
 */

public class TabItemListPagerAdapter extends FragmentStatePagerAdapter {
    private Bundle[] bundleList;

    public TabItemListPagerAdapter(FragmentManager fm, Bundle[] bundleList) {
        super(fm);
        this.bundleList = bundleList;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = bundleList[position];
        ItemListFragment itemListFragment = new ItemListFragment();
        itemListFragment.setArguments(bundle);
        return itemListFragment;
    }

    @Override
    public int getCount() {
        return bundleList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return bundleList[position].getString(ItemListFragment.TITLE_KEY);
    }
}
