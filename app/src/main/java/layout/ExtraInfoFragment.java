package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import student.seanm.classcompanion.ClassInfoActivity;
import student.seanm.classcompanion.R;

public class ExtraInfoFragment extends Fragment {
    public ExtraInfoFragment() {
        // Required empty public constructor
    }

    //returns the extra info  fragment
    public static ExtraInfoFragment newInstance() {
        ExtraInfoFragment fragment = new ExtraInfoFragment();
        Bundle args = new Bundle();
        args.putString("Tab Name", "Extra Info");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_extra_info, container, false);

        //sets main content text based on the course name
        TextView mainText = (TextView) v.findViewById(R.id.frag_extra_tv);
        mainText.setText("Extra information for: " + ClassInfoActivity.courseName);

        return v;
    }
}
