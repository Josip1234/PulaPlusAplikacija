package com.josip.acer.pulaplusaplikacija;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZnamenitostiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znamenitosti);

    }
    public void createFile(View v) throws IOException,JSONException {
        JSONArray data = new JSONArray();
        JSONObject znam;

        znam = new JSONObject();
        znam.put("Znamenitost:","Pulska Arena");
        znam.put("Cijena:",150);
        data.put(znam);

        znam = new JSONObject();
        znam.put("Znamenitost:","Slavoluk pobjede");
        znam.put("Cijena:","besplatno");
        data.put(znam);

        String text=data.toString();
        FileOutputStream fos=openFileOutput("znamenitosti",MODE_PRIVATE);
        fos.write(text.getBytes());
        fos.close();
        UIHelper.displayText(this, R.id.textView9,"Datoteka je zapisana na disk:\n"+data.toString());
    }
    public void readFile(View v) throws IOException,JSONException{
        FileInputStream fis = openFileInput("znamenitosti");
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();
        while(bis.available()!=0){
            char c= (char) bis.read();
            b.append(c);
        }
        bis.close();
        fis.close();
        JSONArray data= new JSONArray(b.toString());
        StringBuffer znamenitostBuffer = new StringBuffer();
        for(int i=0;i<data.length();i++){
            String znam = data.getJSONObject(i).getString("Znamenitost:");
            String cijena = data.getJSONObject(i).getString("Cijena:");
            znamenitostBuffer.append(znam + "\n" + cijena);
        }
        UIHelper.displayText(this,R.id.textView9,znamenitostBuffer.toString());

    }

}
