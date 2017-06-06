package layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class WeightingFragment extends Fragment {

    private List<Integer> weightSectors;
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

        //sets main content text based on the course name
        TextView mainText = (TextView) v.findViewById(R.id.frag_weigh_tv);
        mainText.setText("Weigthing for: " + ClassInfoActivity.courseName);

        initialisePieChart(v);

        return v;
    }

    private void initialisePieChart(View v){
        //set up list to hold all weighting data
        weightSectors = new ArrayList<Integer>();
        List<Integer> weights = new ArrayList<Integer>();
        List<String> components = new ArrayList<String>();
        float totalWeight = 0;
        for(int i=0; i<ClassInfoActivity.datClass.length; i++){
            if(ClassInfoActivity.datClass[i].equals(ClassInfoActivity.courseName)){
                weights.add(ClassInfoActivity.datComponentWeight[i]);
                totalWeight += ClassInfoActivity.datComponentWeight[i];

                components.add(ClassInfoActivity.datComponentType[i]);

            }
        }

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
        for(int i=0; i<weights.size(); i++){
            componentData.add(new PieEntry(weights.get(i),i));
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
    }
}



