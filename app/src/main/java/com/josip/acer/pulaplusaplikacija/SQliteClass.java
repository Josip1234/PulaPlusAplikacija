package com.josip.acer.pulaplusaplikacija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by HG on 15.12.2016..
 */

public class SQliteClass extends SQLiteOpenHelper {






    public enum databaseTables {
        RESTORANI("restorani");
        public String table;

        databaseTables(String table) {
            this.table = table;
        }
    }
    public enum restoraniColumna{
        ID("id"),
        ADDRESS("address"),
        CONTACT("contact");
        public String column;
        restoraniColumna(String column){
            this.column = column;
        }
    }

    public SQliteClass(Context context) {
        super(context, "dbclass",null,1);
    }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String createRestorani = "CREATE TABLE "+databaseTables.RESTORANI + "(" + restoraniColumna.ID.column + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    restoraniColumna.ADDRESS.column + " VARCHAR, " +
                    restoraniColumna.CONTACT.column + " VARCHAR); ";
            sqLiteDatabase.execSQL(createRestorani);
        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + databaseTables.RESTORANI);
        onCreate(sqLiteDatabase);
    }

    public boolean addRestoran(String contact,String address){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(restoraniColumna.CONTACT.column,contact);
        contentValues.put(restoraniColumna.ADDRESS.column,contact);
        db.replace(databaseTables.RESTORANI.table,null,contentValues);
        db.close();
        return  true;
    }

    public ArrayList<RestoraniModel> restoraniModels(){
        ArrayList<RestoraniModel> restoraniModelArrayListe = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        String queryDb = "SELECT * FROM restorani";
        Cursor cursor = database.rawQuery(queryDb,null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String address = cursor.getString(cursor.getColumnIndex(restoraniColumna.ADDRESS.column));
                String contact = cursor.getString(cursor.getColumnIndex(restoraniColumna.CONTACT.column));

                restoraniModelArrayListe.add(new RestoraniModel(address,contact));
                cursor.moveToNext();
            }
        }
        return restoraniModelArrayListe;

    }
}

