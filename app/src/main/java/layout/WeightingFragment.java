package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import student.seanm.classcompanion.R;

public class WeightingFragment extends Fragment {

    public WeightingFragment() {
        // Required empty public constructor
    }

    //returns the weighting fragment
    public static WeightingFragment newInstance() {
        WeightingFragment fragment = new WeightingFragment();
        Bundle args = new Bundle();
        args.putString("Tab Name", "Weighting");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weighting, container, false);
    }
}
