package student.seanm.classcompanion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddCourseActivity extends AppCompatActivity {

    private EditText newName;
    private EditText newGoal;
    private EditText newCompName;
    private EditText newCompQuantity;
    private EditText newCompWeight;

    private Button addComp;
    private Button clearComps;
    private Button addCourse;

    private ScrollView allComponents;

    private List<String> componentNames;
    private List<Integer> componentQuantities;
    private List<Integer> componentWeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        newName = (EditText) findViewById(R.id.add_name_et);
        newGoal = (EditText) findViewById(R.id.add_goal_et);
        newCompName = (EditText) findViewById(R.id.add_compName_et);
        newCompQuantity = (EditText) findViewById(R.id.add_compNum_et);
        newCompWeight = (EditText) findViewById(R.id.add_compWeight_et);

        addComp = (Button) findViewById(R.id.add_comp_but);
        clearComps = (Button) findViewById(R.id.add_clearComp_but);
        addCourse = (Button) findViewById(R.id.add_finish_but);

        componentNames = new ArrayList<String>();
        componentQuantities = new ArrayList<Integer>();
        componentWeights = new ArrayList<Integer>();

        addComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String compName = newCompName.getText().toString();
                    int compQuantity = Integer.parseInt(newCompQuantity.getText().toString());
                    int compWeight = Integer.parseInt(newCompWeight.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearComps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                componentNames = new ArrayList<String>();
                componentQuantities = new ArrayList<Integer>();
                componentWeights = new ArrayList<Integer>();
            }
        });

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = newName.getText().toString();
                    int goal = Integer.parseInt(newGoal.getText().toString());
                    addCourseToDB();
                }
                catch (Exception e){

                }
            }
        });
    }

    private void addCourseToDB(){

    }
}
