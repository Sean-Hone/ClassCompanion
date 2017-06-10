package student.seanm.classcompanion.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by seanm on 09/06/2017.
 */

public class CourseDataDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "courseData.db";
    private static final int DATABASE_VERSION = 1;

    public CourseDataDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        final String SQL_CREATE_COURSEDATA_TABLE = "CREATE TABLE " +
                CourseDataContract.CourseDataEntry.TABLE_NAME + " (" +
                CourseDataContract.CourseDataEntry.COLUMN_COURSE + " TEXT NOT NULL," +
                CourseDataContract.CourseDataEntry.COLUMN_COMPONENT + " TEXT NOT NULL," +
                CourseDataContract.CourseDataEntry.COLUMN_NUMBER + " INTEGER NOT NULL," +
                CourseDataContract.CourseDataEntry.COLUMN_WEIGHT + " FLOAT NOT NULL," +
                CourseDataContract.CourseDataEntry.COLUMN_GRADE + " FLOAT, PRIMARY KEY (" +
                CourseDataContract.CourseDataEntry.COLUMN_COURSE + ", " +
                CourseDataContract.CourseDataEntry.COLUMN_COMPONENT + ", " +
                CourseDataContract.CourseDataEntry.COLUMN_NUMBER + "));";

        sqLiteDatabase.execSQL(SQL_CREATE_COURSEDATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        //eventaully will upgrade database version if database is changed
    }
}
