package student.seanm.classcompanion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import student.seanm.classcompanion.data.CourseDataContract;
import student.seanm.classcompanion.data.CourseDataDbHelper;
import student.seanm.classcompanion.data.PopulateCourseDataDb;

public class HomepageActivity extends AppCompatActivity {

    private Intent classIntent; //intent to go to class info page
    private SQLiteDatabase courseDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //set up or check for courseData database
        CourseDataDbHelper dbHelper = new CourseDataDbHelper(this);
        courseDb = dbHelper.getWritableDatabase();

        //method that will populate the  database with all of my mock grades for four subjects
        PopulateCourseDataDb.populateCouseDataDb(courseDb);

        Cursor cursor = getCourseNames();

        //find toolbar and set it as the app bar for this activity
        Toolbar tBar = (Toolbar) findViewById(R.id.homepage_toolBar);
        setSupportActionBar(tBar);

        //main grid view on home page
        GridView gridView = (GridView) findViewById(R.id.homepage_grid);
        gridView.setAdapter(new ClassItemAdapter(this, cursor));

        classIntent = new Intent(this, ClassInfoActivity.class);

        //goes to class info screen passing in the name of the class using intent
        gridView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                classIntent.putExtra("Course", (String)parent.getItemAtPosition(position));
                startActivity(classIntent);
            }
        });
    }

    //returns cursor of the course names column
    private Cursor getCourseNames(){
        String[] courseCols = new String[1];
        courseCols[0] = CourseDataContract.CourseDataEntry.COLUMN_COURSE;

        return courseDb.query(
                CourseDataContract.CourseDataEntry.TABLE_NAME,
                courseCols,
                null,
                null,
                null,
                null,
                CourseDataContract.CourseDataEntry.COLUMN_COURSE);
    }
}
