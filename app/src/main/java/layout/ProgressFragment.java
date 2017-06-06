package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import student.seanm.classcompanion.ClassInfoActivity;
import student.seanm.classcompanion.R;

public class ProgressFragment extends Fragment {
    public ProgressFragment() {
        // Required empty public constructor
    }

    //returns the weighting fragment
    public static ProgressFragment newInstance() {
        ProgressFragment fragment = new ProgressFragment();
        Bundle args = new Bundle();
        args.putString("Tab Name", "Progress");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress, container, false);

        //sets main content text based on the course name
        TextView mainText = (TextView) v.findViewById(R.id.frag_pro_tv);
        mainText.setText("Progress for: " + ClassInfoActivity.courseName);

        return v;
    }
}
