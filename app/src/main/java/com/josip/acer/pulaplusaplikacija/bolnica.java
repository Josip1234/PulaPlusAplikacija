package com.josip.acer.pulaplusaplikacija;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bolnica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolnica);
    }
    public void createFileBolnica(View v) throws IOException,JSONException {
        JSONArray data = new JSONArray();
        JSONObject bol;

        bol = new JSONObject();
        bol.put("Bolnica:","Opća bolnica Pula");
        bol.put("Adresa:","Zagrebacka 30");
        bol.put("Telefon:","052-376-000");
        data.put(bol);



        String text=data.toString();
        FileOutputStream fos=openFileOutput("bolnice",MODE_PRIVATE);
        fos.write(text.getBytes());
        fos.close();
        UIHelper.displayText(this, R.id.tx1,"Datoteka je zapisana na disk:\n"+data.toString());
    }
    public void readFileBolnica(View v) throws IOException,JSONException{
        FileInputStream fis = openFileInput("bolnice");
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
            String bolnica = data.getJSONObject(i).getString("Bolnica:");
            String adresa = data.getJSONObject(i).getString("Adresa:");
            String telefon = data.getJSONObject(i).getString("Telefon:");
            znamenitostBuffer.append(bolnica + "\n" + adresa);
        }
        UIHelper.displayText(this,R.id.tx1,znamenitostBuffer.toString());

    }
}
