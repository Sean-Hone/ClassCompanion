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
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 80);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 90);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 76);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 85);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 60);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 90);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Test");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 20);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 90);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Comp261");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Exam");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 50);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 94);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 62);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 6);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Nwen241");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Exam");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 70);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 55);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 99);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 93);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 76.5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Lab");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 15);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 97.42);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Self Assesment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 100);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen221");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Exam");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 60);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 85);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 93);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 2);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 99);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, 87);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 4);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Assignment");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 5);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 3);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Research Project");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 15);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
        list.add(cv);

        cv = new ContentValues();
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COURSE, "Swen223");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_COMPONENT, "Test");
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_NUMBER, 1);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_WEIGHT, 70);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GRADE, -1.0);
        cv.put(CourseDataContract.CourseDataEntry.COLUMN_GOAL, 80);
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
        }
        finally
        {
            db.endTransaction();
        }
    }
}
