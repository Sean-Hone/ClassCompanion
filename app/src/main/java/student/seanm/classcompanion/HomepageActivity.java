package student.seanm.classcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class HomepageActivity extends AppCompatActivity {

    private Intent classIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        GridView gridView = (GridView) findViewById(R.id.homepage_grid);
        gridView.setAdapter(new ClassItemAdapter(this));

        classIntent = new Intent(this, ClassInfoActivity.class);

        gridView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                classIntent.putExtra("Class", (String)parent.getItemAtPosition(position));
                startActivity(classIntent);
            }
        });
    }
}
