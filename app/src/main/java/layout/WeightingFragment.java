package layout;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import student.seanm.classcompanion.ClassInfoActivity;
import student.seanm.classcompanion.R;
import student.seanm.classcompanion.data.CourseDataContract;

public class WeightingFragment extends Fragment {

    private List<String> courseComponents;
    private List<Integer> componentWeights;

    private PieChart weightsChart;

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

        initialiseComponentInfo();

        initialisePieChartAndKeys(v);

        return v;
    }

    private void initialisePieChartAndKeys(View v){

        //set up reference to pie chart
        weightsChart = (PieChart) v.findViewById(R.id.frag_weigh_pie_chart);

        //allows data set to be a percentage
        weightsChart.setUsePercentValues(true);
        weightsChart.setTouchEnabled(false);

        //sets up inner hole
        weightsChart.setDrawHoleEnabled(true);
        weightsChart.setHoleRadius(20);
        weightsChart.setTransparentCircleRadius(23);

        //remove legend and description
        Description pieDescription = weightsChart.getDescription();
        pieDescription.setEnabled(false);

        Legend pieLegend = weightsChart.getLegend();
        pieLegend.setEnabled(false);

        //add data
        List<PieEntry> componentData = new ArrayList<PieEntry>();
        for(int i=0; i<componentWeights.size(); i++){
            componentData.add(new PieEntry(componentWeights.get(i),i));
        }

        //create dataset object
        PieDataSet dataSet = new PieDataSet(componentData, "   ");

        //set up colors used in pie chart
        List<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.parseColor("#e41a1c")); //red
        colors.add(Color.parseColor("#377eb8")); //grey-blue
        colors.add(Color.parseColor("#4daf4a")); //soft green
        colors.add(Color.parseColor("#984ea3")); //purple
        colors.add(Color.parseColor("#ff7f00")); //orange
        colors.add(Color.parseColor("#ffff33")); //yellow
        colors.add(Color.parseColor("#a65628")); //brown
        colors.add(Color.parseColor("#f781bf")); //pink

        dataSet.setColors(colors);

        //explodes pie chart
        dataSet.setSliceSpace(3);

        //change label text size and adds percent symbol
        dataSet.setValueTextSize(12);
        dataSet.setValueFormatter(new PercentFormatter());

        weightsChart.setData(new PieData(dataSet));

        initialiseKeysList(v, colors);
    }

    private void initialiseKeysList(View v, List<Integer> colors){

        //sets up a grid layout to hold information on
        GridLayout keysListLayout = (GridLayout) v.findViewById(R.id.frag_weigh_key_layout);
        keysListLayout.setColumnCount(2);
        keysListLayout.setRowCount(componentWeights.size());
        keysListLayout.setOrientation(GridLayout.HORIZONTAL);
        keysListLayout.setBackgroundColor(Color.parseColor("#000000"));

        for (int i = 0; i < componentWeights.size(); i++) {

            //finds the size of the screen to limit the length of the key
            WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;

            //create text view for key
            TextView key = new TextView(this.getContext());
            key.setText(courseComponents.get(i));
            key.setBackgroundColor(Color.parseColor("#fffafafa"));  //default whit backgrounbd
            key.setTextSize(18);

            //limits text to fit in grid element
            key.setMaxWidth(width / 3);
            key.setMaxLines(1);

            //sets the paramaters of the key text
            GridLayout.LayoutParams keyParams = new GridLayout.LayoutParams();
            keyParams.columnSpec = GridLayout.spec(0, 2f);
            keyParams.rowSpec = GridLayout.spec(i);
            keyParams.setMargins(0, 0, 0, 1);
            key.setLayoutParams(keyParams);

            //creates text view for the percentage and centers text
            TextView percentage = new TextView((this.getContext()));
            percentage.setText("%" + componentWeights.get(i));
            percentage.setGravity(Gravity.CENTER);
            percentage.setBackgroundColor(colors.get(i));
            percentage.setTextSize(18);

            //sets the paramaters for the percentage text view
            GridLayout.LayoutParams percentageParams = new GridLayout.LayoutParams();
            percentageParams.columnSpec = GridLayout.spec(1, 1f);
            percentageParams.rowSpec = GridLayout.spec(i);
            percentage.setLayoutParams(percentageParams);

            //adds the two views to the grid layout
            keysListLayout.addView(key);
            keysListLayout.addView(percentage);
        }
    }

    private void initialiseComponentInfo(){
        Cursor pieInfoCursor = getPieInfoCursor();

        courseComponents = new ArrayList<String>();
        componentWeights = new ArrayList<Integer>();

        while(true){
            if(!pieInfoCursor.moveToNext()) return;

            String component = pieInfoCursor.getString(pieInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT));
            Integer weight = pieInfoCursor.getInt(pieInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT));

            if(!courseComponents.contains(component)){
                courseComponents.add(component);
                componentWeights.add(weight);
            }
            else{
                Integer componentInd = courseComponents.indexOf(component);
                componentWeights.set(componentInd, componentWeights.get(componentInd) + weight);
            }
        }
    }

    private Cursor getPieInfoCursor(){
        String[] courseCols = new String[2];
        courseCols[0] = CourseDataContract.CourseDataEntry.COLUMN_COMPONENT;
        courseCols[1] = CourseDataContract.CourseDataEntry.COLUMN_WEIGHT;


        return ClassInfoActivity.courseDb.query(
                CourseDataContract.CourseDataEntry.TABLE_NAME,
                courseCols,
                CourseDataContract.CourseDataEntry.COLUMN_COURSE + "= '" + ClassInfoActivity.courseName + "'",
                null,
                null,
                null,
                CourseDataContract.CourseDataEntry.COLUMN_COURSE);
    }
}



