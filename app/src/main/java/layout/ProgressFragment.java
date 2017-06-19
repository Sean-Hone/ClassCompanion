package layout;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import student.seanm.classcompanion.ClassInfoActivity;
import student.seanm.classcompanion.R;
import student.seanm.classcompanion.data.CourseDataContract;

public class ProgressFragment extends Fragment {

    private List<Float> gradeComponents;
    private List<Float> courseAverages;
    private List<Integer> componentWeights;
    private List<Integer> weightIntervals;
    private List<String> componentNames;

    private TextView graphSelection;
    private TextView courseCompleted;
    private TextView average;
    private TextView goal;
    private TextView requirements;
    private Button updateProgress;

    private float goalPercent;
    private float percentUncompleted;

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

        graphSelection = (TextView) v.findViewById(R.id.frag_pro_selected_tv);
        courseCompleted = (TextView) v.findViewById(R.id.frag_pro_completed_tv);
        average = (TextView) v.findViewById(R.id.frag_pro_average_tv);
        goal = (TextView) v.findViewById(R.id.frag_pro_goal_tv);
        requirements = (TextView) v.findViewById(R.id.frag_pro_requirment_tv) ;

        updateProgress = (Button) v.findViewById(R.id.frag_pro_update_but);


        initialiseLineChartInfo();
        initialiseLineChart(v);

        populateReferenceInfo();

        return v;
    }

    private void populateReferenceInfo(){
        graphSelection.setHint("Select a point for info...");
        graphSelection.setGravity(Gravity.CENTER);
        graphSelection.setTextSize(20);
        graphSelection.setTextColor(Color.parseColor("#000000"));

        float percentCompleted = 100-percentUncompleted;
        courseCompleted.setText("You've completed %" + percentCompleted + " of the course");
        courseCompleted.setGravity(Gravity.CENTER);
        courseCompleted.setTextSize(16);

        String averageText = String.format("Your course average so far is: %s (%%%.1f)",
                getGradeFromPercent(courseAverages.get(courseAverages.size()-1)), courseAverages.get(courseAverages.size()-1));
        average.setText(averageText);
        average.setGravity(Gravity.CENTER);
        average.setTextSize(16);

        String goalText = String.format("Your goal for this course is: %s (%%%.1f)", getGradeFromPercent(goalPercent), goalPercent);
        goal.setText(goalText);
        goal.setGravity(Gravity.CENTER);
        goal.setTextSize(16);

        //calculating required grade to achieve goal
        float currentMarks = (courseAverages.get(courseAverages.size()-1)*percentCompleted)/100;
        float marksNeeded = goalPercent - currentMarks;
        float requiredPercent = (marksNeeded/percentUncompleted)*100;

        String requiredText = String.format("Try maintain an average of: %s (%%%.1f)", getGradeFromPercent(requiredPercent), requiredPercent);
        requirements.setText(requiredText);
        requirements.setGravity(Gravity.CENTER);
        requirements.setTextSize(16);

        updateProgress.setText("Update Progress Information");
        updateProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "To be implemented later", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void initialiseLineChart(View v){

        //gets reference to the line chart
        LineChart progressChart = (LineChart) v.findViewById(R.id.frag_pro_line_chart);

        //remove legend and description
        Description pieDescription = progressChart.getDescription();
        pieDescription.setEnabled(false);

        Legend pieLegend = progressChart.getLegend();
        pieLegend.setEnabled(false);

        //diable horizontal scaling and double tap zoom
        progressChart.setScaleXEnabled(false);
        progressChart.setDoubleTapToZoomEnabled(false);
        //disable right y axis
        progressChart.getAxisRight().setEnabled(false);

        //manually sets up slection listener for points
        progressChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                float progressMatch =  e.getX();

                if(progressMatch==0f){
                    String emptySelectionText = String.format("Goal of %s (%%%.1f)",getGradeFromPercent(goalPercent), goalPercent);
                    graphSelection.setText(emptySelectionText);
                    return;
                }
                for(int i=0; i<componentNames.size(); i++){
                    if(weightIntervals.get(i)==progressMatch){
                        String selectionText = String.format("%s (%%%.1f) for %s ",
                                getGradeFromPercent(gradeComponents.get(i)), gradeComponents.get(i), componentNames.get(i));
                        graphSelection.setText(selectionText);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected() {
                graphSelection.setText("");
                graphSelection.setHint("Select a point for info...");
            }
        });

        //setup axis for line chart
        YAxis yAxis = progressChart.getAxisLeft();
        XAxis xAxis = progressChart.getXAxis();

        //set dimensions of axis
        yAxis.setStartAtZero(true);
        yAxis.setAxisMaximum(105);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(100);

        //diables x scrolling and scaling
        //move x axis to bottom
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //makes the x axis be a percentage value
        xAxis.setValueFormatter(new PercentFormatter());

        //disable grid lines of axis
        //yAxis.setDrawGridLines(false);
        xAxis.setDrawGridLines(false);

        //makes grid lines dashed
        yAxis.enableGridDashedLine(4,6,5);
        //xAxis.enableGridDashedLine(4,6,5);

        //creates a custom formatter for the y values to show letter grades
        yAxis.setGranularityEnabled(true);
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                String yLabel = getGradeFromPercent(value);
                if(yLabel.equals("")) return yLabel;
                else return (yLabel + " (" + value + ")");
            }
        });

        //creating all entries and populating data set
        List<Entry> data = new ArrayList<Entry>();
        data.add(new Entry(0f, goalPercent));
        int percentage = 0;
        for(int i=0; i<componentWeights.size(); i++){
            percentage+=componentWeights.get(i);
            data.add(new Entry(percentage, courseAverages.get(i)));
        }

        LineDataSet lineDataSet = new LineDataSet(data, "   ");

        //diables point values
        lineDataSet.setDrawValues(false);

        //setting data of chart
        progressChart.setData(new LineData(lineDataSet));
    }

    private void initialiseLineChartInfo(){
        Cursor lineChartInfoCursor = getPChartInfoCursor();

        goalPercent = -1;
        percentUncompleted = 0;
        gradeComponents = new ArrayList<Float>();
        courseAverages = new ArrayList<Float>();
        componentWeights = new ArrayList<Integer>();
        weightIntervals = new ArrayList<Integer>();
        componentNames = new ArrayList<String>();

        int totalWeight = 0;

        while(true){
            if(!lineChartInfoCursor.moveToNext()) return;

            Float grade = lineChartInfoCursor.getFloat(lineChartInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_GRADE));
            Integer weight = lineChartInfoCursor.getInt(lineChartInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT));

            String component = lineChartInfoCursor.getString(lineChartInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT));
            Integer componentNum = lineChartInfoCursor.getInt(lineChartInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_NUMBER));

            Float goal = lineChartInfoCursor.getFloat(lineChartInfoCursor.getColumnIndex(CourseDataContract.CourseDataEntry.COLUMN_GOAL));

            if(goalPercent == -1) goalPercent = goal;

            if(grade != -1.0){
                gradeComponents.add(grade);
                componentWeights.add(weight);
                componentNames.add(component + " " + componentNum);

                //adds an entry for the course average
                float totalPoints = 0;
                float completedPercent = 0;
                for(int i=0; i<componentWeights.size(); i++){
                    totalPoints += componentWeights.get(i)*gradeComponents.get(i);
                    completedPercent += componentWeights.get(i);
                }
                courseAverages.add(totalPoints/completedPercent);

                /*float average = 0;
                for(float f: gradeComponents) average+=f;
                courseAverages.add(average/gradeComponents.size());*/

                //gets the intervals that the entries will be on the graph
                totalWeight+=weight;
                weightIntervals.add(totalWeight);
            }
            else{
                percentUncompleted+=weight;
            }
        }
    }

    private Cursor getPChartInfoCursor(){
        String[] courseCols = new String[5];
        courseCols[0] = CourseDataContract.CourseDataEntry.COLUMN_GRADE;
        courseCols[1] = CourseDataContract.CourseDataEntry.COLUMN_WEIGHT;
        courseCols[2] = CourseDataContract.CourseDataEntry.COLUMN_COMPONENT;
        courseCols[3] = CourseDataContract.CourseDataEntry.COLUMN_NUMBER;
        courseCols[4] = CourseDataContract.CourseDataEntry.COLUMN_GOAL;


        return ClassInfoActivity.courseDb.query(
                CourseDataContract.CourseDataEntry.TABLE_NAME,
                courseCols,
                CourseDataContract.CourseDataEntry.COLUMN_COURSE + "= '" + ClassInfoActivity.courseName + "'",
                null,
                null,
                null,
                CourseDataContract.CourseDataEntry.COLUMN_COURSE);
    }

    private String getGradeFromPercent(float value){
        String grade;
        if(value<40.0)
            grade="E";
        else if(value<50.0)
            grade="D";
        else if(value<55.0)
            grade="C-";
        else if(value<60.0)
            grade="C";
        else if(value<65.0)
            grade="C+";
        else if(value<70.0)
            grade="B-";
        else if(value<75.0)
            grade="B";
        else if(value<80.0)
            grade="B+";
        else if(value<85.0)
            grade="A-";
        else if(value<90.0)
            grade="A";
        else if(value<=100.0)
            grade="A+";
        else
            grade="";
        return grade;
    }
}
