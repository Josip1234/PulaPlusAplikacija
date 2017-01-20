package com.josip.acer.pulaplusaplikacija;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Korisnik on 30.11.2016..
 */

public class UIHelper {
    public static void displayText(Activity activity,int id,String text){
        TextView tv = (TextView) activity.findViewById(id);
        tv.setText(text);
    }
    public static String getText(Activity activity,int id){
        EditText et = (EditText) activity.findViewById(id);
        return et.getText().toString();
    }

}
