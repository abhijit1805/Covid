package com.example.covichart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String temp, String oxygen, String pulse)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TEMP, temp);
        contentValues.put(myDbHelper.OXYGEN, oxygen);
        contentValues.put(myDbHelper.PULSE, pulse);
        contentValues.put(myDbHelper.TIME_STAMP, System.currentTimeMillis()+"");
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public Record[] getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.TEMP,myDbHelper.OXYGEN, myDbHelper.PULSE, myDbHelper.TIME_STAMP};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        Record records[] = new Record[100];
        int i = 0;
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String temperature =cursor.getString(cursor.getColumnIndex(myDbHelper.TEMP));
            String  oxygen =cursor.getString(cursor.getColumnIndex(myDbHelper.OXYGEN));
            String  pulse =cursor.getString(cursor.getColumnIndex(myDbHelper.PULSE));
            String  timeStamp =""+cursor.getString(cursor.getColumnIndex(myDbHelper.TIME_STAMP));
            records[i] = new Record(timeStamp, temperature, oxygen, pulse);
            i++;
        }
        return records;
    }





    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "CovidDB";    // Database Name
        private static final String TABLE_NAME = "CovidTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version

        private static final String UID="_id";     // Column I (Primary Key)
        private static final String TEMP = "Temperature";    //Column II
        private static final String OXYGEN= "Oxygen";    // Column III
        private static final String PULSE= "Pulse";    // Column III
        private static final String TIME_STAMP= "TimeStamp";    // Column III

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+
                UID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TEMP+ " VARCHAR(255) ,"+
                OXYGEN+ " VARCHAR(225) ,"+
                PULSE+ " VARCHAR(255) ,"+
                TIME_STAMP+ " VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}