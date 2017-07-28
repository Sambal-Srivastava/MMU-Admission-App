package com.example.sambal.mmuadmission;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sambal on 5/31/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "new_admission_records.db";
    private static final String TABLE_NAME = "admission_records";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +  TABLE_NAME  + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,CAMPUS_SELECTION TEXT,SEAT_SELECTION TEXT,APPLICANT_MOBILE INTEGER,APPLICANT_NAME TEXT,APPLICANT_EMAIL TEXT,APPLICANT_FATHERNAME TEXT,APPLICANT_MOTHERNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }


    public boolean insertData(String campus_selection){
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("CAMPUS_SELECTION", campus_selection);



        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean insertData1(String seat_selection){
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("SEAT_SELECTION", seat_selection);



        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }


    public boolean insertData2(int applicant_mobile,String applicant_name,String applicant_email){
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("APPLICANT_NAME", applicant_name);
        contentValues.put("APPLICANT_EMAIL", applicant_email);
        contentValues.put("APPLICANT_MOBILE", applicant_mobile);



        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean insertData3(String applicant_fathername,String applicant_mothername){
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("APPLICANT_FATHERNAME", applicant_fathername);
        contentValues.put("APPLICANT_MOTHERNAME", applicant_mothername);



        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }


    public Cursor getData(String applicat_mobile)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        String query= "SELECT * FROM " + TABLE_NAME + " WHERE APPLICANT_MOBILE = '" + applicat_mobile+"'";

        Cursor cursor=db.rawQuery(query, null);

        return cursor;

    }


}
