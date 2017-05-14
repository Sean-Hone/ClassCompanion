package student.seanm.classcompanion;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by seanm on 14/05/2017.
 */

public class ClassItemAdapter extends BaseAdapter {

    private Context adapterContext;
    private int[] itemNames;

    public ClassItemAdapter(Context c){
        adapterContext = c;
        itemNames = new int[4];
        itemNames[0] = R.string.Grid_00;
        itemNames[1] = R.string.Grid_10;
        itemNames[2] = R.string.Grid_01;
        itemNames[3] = R.string.Grid_11;
    }

    public int getCount(){
        return itemNames.length;
    }

    public Object getItem(int position){
        return adapterContext.getString(itemNames[position]);
    }

    public long getItemId(int position){
        return itemNames[position];
    }

    public View getView(int position, View convertView, ViewGroup parent){
        TextView itemView;
        if(convertView == null){
            itemView = new TextView(adapterContext);
            ViewGroup.LayoutParams layoutParams = new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(layoutParams);
            itemView.setPadding(15,50,15,50);
            itemView.setGravity(Gravity.CENTER);
        }
        else itemView = (TextView) convertView;

        itemView.setText(adapterContext.getString(itemNames[position]));
        return itemView;
    }
}
