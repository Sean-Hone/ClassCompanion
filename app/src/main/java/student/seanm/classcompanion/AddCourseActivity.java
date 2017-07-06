package student.seanm.classcompanion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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

    private LinearLayout allComponents;

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

        allComponents = (LinearLayout) findViewById(R.id.add_comp_scroll_LL);

        addComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validComp = true;
                String compName = "";
                int compQuantity = 0;
                int compWeight = 0;
                try{
                    compName = newCompName.getText().toString();
                    compQuantity = Integer.parseInt(newCompQuantity.getText().toString());
                    compWeight = Integer.parseInt(newCompWeight.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                    validComp = false;
                }
                if(validComp){
                    componentNames.add(compName);
                    componentQuantities.add(compQuantity);
                    componentWeights.add(compWeight);
                }

                updateScrollView();
            }
        });

        clearComps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                componentNames = new ArrayList<String>();
                componentQuantities = new ArrayList<Integer>();
                componentWeights = new ArrayList<Integer>();

                allComponents.removeAllViews();
            }
        });

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = newName.getText().toString();
                    int goal = Integer.parseInt(newGoal.getText().toString());
                    addCourseToDB(name, goal);
                }
                catch (Exception e){

                }
            }
        });
    }

    private void updateScrollView(){
        for(int i=0; i<componentNames.size(); i++){
            LinearLayout component = new LinearLayout(this);
            LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            component.setLayoutParams(LLParams);
            component.setWeightSum(1f);

            LinearLayout.LayoutParams nameLP = new LinearLayout.LayoutParams(0, 0, 0.5f);
            TextView name = new TextView(this);
            name.setLayoutParams(nameLP);
            name.setText(componentNames.get(i));

            LinearLayout.LayoutParams quantityLP = new LinearLayout.LayoutParams(0, 0, 0.25f);
            TextView quantity = new TextView(this);
            quantity.setLayoutParams(quantityLP);
            quantity.setText("Q:" + componentQuantities.get(i));

            LinearLayout.LayoutParams weightLP = new LinearLayout.LayoutParams(0, 0, 0.25f);
            TextView weight = new TextView(this);
            weight.setLayoutParams(weightLP);
            weight.setText("%" + componentWeights.get(i));

            component.addView(name);
            component.addView(quantity);
            component.addView(weight);

            allComponents.addView(component);
        }
    }

    private void addCourseToDB(String name, int goal){

    }
}
