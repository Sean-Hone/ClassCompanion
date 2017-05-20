package student.seanm.classcompanion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.WeightingFragment;

/**
 * Created by seanm on 14/05/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter{

    public SectionsPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position){
        //returns the fragment realting to the current tab based on position
        return WeightingFragment.newInstance();
    }

    //only 3 tabs
    @Override
    public int getCount(){
        return 3;
    }

    //returns the name of the current tab based on position
    @Override
    public String getPageTitle(int position) {
        switch (position) {
            case 0: return "Weighting";
            case 1: return "Progress";
            case 2: return "Extra Info";
        }
        return null;
    }
}
