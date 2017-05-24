package student.seanm.classcompanion;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by seanm on 14/05/2017.
 */

public class ClassItemAdapter extends BaseAdapter {

    private Context adapterContext;
    private String[] itemNames;

    public ClassItemAdapter(Context c){
        adapterContext = c;

        //array of all class names
        itemNames = adapterContext.getResources().getStringArray(R.array.classes);

        /*itemNames = new int[4]; //list of all class names
        itemNames[0] = R.string.Grid_00; //string is has grid position in reference name
        itemNames[1] = R.string.Grid_10;
        itemNames[2] = R.string.Grid_01;
        itemNames[3] = R.string.Grid_11;*/
    }

    //returns the amount of classes in the program
    public int getCount(){
        return itemNames.length;
    }

    //returns the object at given position
    public Object getItem(int position){
        return itemNames[position];
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

        itemView.setText(itemNames[position]);
        return itemView;
    }
}
