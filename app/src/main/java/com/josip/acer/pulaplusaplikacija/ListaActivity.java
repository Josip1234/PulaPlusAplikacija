package com.josip.acer.pulaplusaplikacija;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        LstFragment lstFragment = (LstFragment) getSupportFragmentManager().findFragmentByTag("lstfragment");


        if (lstFragment == null) {
            lstFragment = new LstFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(android.R.id.content, lstFragment, "lstfragment");
            transaction.commit();


        }

    }
}
