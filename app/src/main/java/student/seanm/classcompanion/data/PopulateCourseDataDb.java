package student.seanm.classcompanion.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seanm on 10/06/2017.
 */

public class PopulateCourseDataDb {
    public static void populateCouseDataDb(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //list of all courses their components and number
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 76);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 60);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "test");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 20);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 90);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "exam");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 50);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 94);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 62);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "exam");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 70);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 55);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 99);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 93);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "lab");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 15);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 95);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "self-assesment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "test");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 60);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 93);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 99);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 87);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "research project");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 15);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "test");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 70);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, "");
        list.add(cv);

        //insert all courseData in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (CourseDataContract.CourseDataEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(CourseDataContract.CourseDataEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }
    }
}
