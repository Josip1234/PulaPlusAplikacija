package com.josip.acer.pulaplusaplikacija;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.josip.acer.pulaplusaplikacija.R.drawable.bus;

public class ListaActivity extends AppCompatActivity {
private Button b1;
private Button b2;
private Button b3;
private Button b4;
private Button b5;
private Button b6;


    private Button bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trgovine();
            }
        });
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dogadaj();
            }
        });
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Booking();
            }
        });
        b5=(Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Znamenitosti();
            }
        });


        b4=(Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restoran();
            }
        });

        b6=(Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bolnica();
            }
        });

        bus=(Button) findViewById(R.id.bus);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusActivity();
            }
        });



    }

    public void Bolnica() {
        Intent i = new Intent(this, bolnica.class);
        startActivity(i);
    }

    public void Trgovine(){
    Intent i = new Intent(this,TrgovineActivity.class);
    startActivity(i);
}




public void Dogadaj(){
        Intent p= new Intent(this,DogadjajActivity.class);
        startActivity(p);
        }
public void Booking(){
        Intent a = new Intent(this,BookingActivity.class);
        startActivity(a);
        }
    public void Znamenitosti(){
        Intent u = new Intent(this,ZnamenitostiActivity.class);
        startActivity(u);
    }
    public void Restoran(){
        RestoraniJSON restoraniJSON = new RestoraniJSON();
        restoraniJSON.fetchRestorans(this);
       // Intent restoran = new Intent(this,RestoranActivity.class);
        //startActivity(restoran);
    }


    public void BusActivity(){
        Intent bus = new Intent(this,BusActivity.class);
        startActivity(bus);
    }



}
