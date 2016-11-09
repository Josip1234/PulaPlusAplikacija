package com.josip.acer.pulaplusaplikacija;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONActivity extends AppCompatActivity {
    //u myjson polje spremamo stringove sa servera
    //deklarirani su final stringovi kako bi se dohvatile vrijednosti iz JSON stringa
    String JSONpolje;
    private static final String TAG_RESULTS="reZultat";
    private static final String TAG_ID="id";
    private static final String TAG_IME1="naziv";
    private static final String TAG_IME2="opis";
    private static final String TAG_IME3="adresa";
    //deklarirano json polje u koje će se spremati json polje
    JSONArray pulaplus=null;
    //kreirana je lista polja za kreiranje liste jsona
    //listView  za prikaz liste u aktivnosti
    ListView lista;
    ArrayList<HashMap<String,String>> pulapluslista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }
}
