package layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import student.seanm.classcompanion.ClassInfoActivity;
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
        View v = inflater.inflate(R.layout.fragment_weighting, container, false);

        //sets main content text based on the course name
        TextView mainText = (TextView) v.findViewById(R.id.frag_weigh_tv);
        mainText.setText("Weigthing for: " + ClassInfoActivity.courseName);

        RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.frag_weigh_draw);
        relativeLayout.addView(new DrawView(getActivity()));

        return v;
    }
}

class DrawView extends View{
    private Paint paint;

    public DrawView(Context c){
        super(c);
        paint = new Paint();
    }

    @Override
    public void onDraw(Canvas canvas){
        paint.setColor(Color.GREEN);
        Rect rect = new Rect(20, 56, 200, 112);
        canvas.drawRect(rect, paint );
    }
}
