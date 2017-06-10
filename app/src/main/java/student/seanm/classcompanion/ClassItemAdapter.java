package student.seanm.classcompanion;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seanm on 14/05/2017.
 */

public class ClassItemAdapter extends BaseAdapter {

    private Context adapterContext;
    private Cursor dbCursor;
    private List<String> courseNames;

    public ClassItemAdapter(Context c, Cursor cursor){
        adapterContext = c;
        dbCursor = cursor;

        setCourseNames();
    }

    //returns the amount of classes in the program
    public int getCount(){
        //return itemNames.length;
        return courseNames.size();
    }

    //returns the object at given position
    public Object getItem(int position){

        //return itemNames[position];
        return courseNames.get(position);
    }

    //returns position as id of text is not needed
    public long getItemId(int position){
        return position;
    }

    //Makes and returns the view at the given position
    public View getView(int position, View convertView, ViewGroup parent){
        TextView itemView;
        if(convertView == null){
            //initially only text view
            itemView = new TextView(adapterContext);

            //Height of view wraps content. Width matches the parent which is a signal grid element
            ViewGroup.LayoutParams layoutParams = new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(layoutParams);

            //Layout changes adding padding and centering text
            itemView.setPadding(15,50,15,50);
            itemView.setGravity(Gravity.CENTER);
        }
        else itemView = (TextView) convertView;

        //itemView.setText(itemNames[position]);
        itemView.setText(courseNames.get(position));
        return itemView;
    }

    //sets the list of unique course names that appear in the courseData database
    private void setCourseNames(){

        if(dbCursor.getCount()<=0) return;

        courseNames = new ArrayList<String>();

        while(true){
            if(!dbCursor.moveToNext()) return;

            String courseName = dbCursor.getString(0);

            if(!courseNames.contains(courseName)) {
                courseNames.add(courseName);
            }
        }
    }
}
