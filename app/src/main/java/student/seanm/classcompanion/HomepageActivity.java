package student.seanm.classcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class HomepageActivity extends AppCompatActivity {

    private Intent classIntent; //intent to go to class info page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //main grid view on home page
        GridView gridView = (GridView) findViewById(R.id.homepage_grid);
        gridView.setAdapter(new ClassItemAdapter(this));

        classIntent = new Intent(this, ClassInfoActivity.class);

        //goes to class info screen passing in the name of the class using intent
        gridView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                classIntent.putExtra("Class", (String)parent.getItemAtPosition(position));
                startActivity(classIntent);
            }
        });
    }
}
