package com.josip.acer.pulaplusaplikacija;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HG on 13.01.2017..
 */

public class RestoraniJSON {
    SQliteClass sQliteClass;
    String contact;
    String address;
  public   SQliteClass sqLiteDatabase;


    public void fetchRestorans(final Context context){
        sQliteClass = new SQliteClass(context);
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, "http://pulaplus.esy.es/restjson.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                JSONObject    jsonArray = new JSONObject(response);
                JSONArray jsonArray1 = jsonArray.getJSONArray("restorani");
                    sQliteClass = new SQliteClass(context);
                    sQliteClass.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + SQliteClass.databaseTables.RESTORANI);
                    String createRestorani = "CREATE TABLE "+ SQliteClass.databaseTables.RESTORANI + "(" + SQliteClass.restoraniColumna.ID.column + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                            SQliteClass.restoraniColumna.ADDRESS.column + " VARCHAR, " +
                            SQliteClass.restoraniColumna.CONTACT.column + " VARCHAR); ";
                    sQliteClass.getWritableDatabase().execSQL(createRestorani);
                    for(int i = 0;i<jsonArray1.length();i++) {
                    try{
                         JSONObject jsonObject = jsonArray1.getJSONObject(i);
                        address = jsonObject.getString("mjesto");
                        contact =  jsonObject.getString("kontakt");
                        sQliteClass.addRestoran(contact, address);

                        if (i == jsonArray.length() - 1) {
                            Intent intent = new Intent(context, RestoranActivity.class);
                            context.startActivity(intent);
                    }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                } catch (JSONException e) {
                        e.printStackTrace();
                    }
               // }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestApp requestApp = new RequestApp();
        requestApp.setContext(context);
        requestApp.getmInstance();
        requestApp.addToReqQueue(jsonRequest);
    }

}
