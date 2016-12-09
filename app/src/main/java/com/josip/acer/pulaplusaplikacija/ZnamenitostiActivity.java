package com.josip.acer.pulaplusaplikacija;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ZnamenitostiActivity extends AppCompatActivity {
ViewPager viewPager;
PagerAdapter adapter;
int [] images;
    String [] znamenitost={"Pulska arena","Slavoluk pobjede"};
    String [] cijena={"Augustov hram je dobro očuvani rimski hram u centru Pule (u rimsko doba Pola) na središnjem gradskom trgu Forum. Hram koji je posvećen prvom rimskom caru Augustu sagrađen je za vrijeme careva života između 2. pr. Kr. i njegove smrti 14. godine nove ere[1]. Nalazi se na podiju s tetrastilnim prostilnim trijemom s korintskim stupovima. Građen je u zahtjevnoj tehnici opus isodomum. Dimenzije hrama su 8 m sa 17.3 m. Bogato urešen friz nalik je onome na većem i starijem hramu Maison Carrée u Nîmesu, Francuska[2].","Amfiteatar u Puli ili Pulska Arena (u narodu poznata i kao Divić-grad) najveći je i najsačuvaniji spomenik antičkog graditeljstva u Hrvatskoj. Uspoređujući ga s više od 200 rimskih amfiteatara, plašt pulskog amfiteatra s četiri stubišna tornja je najsačuvaniji i rijedak primjer jedinstvenih tehničkih i tehnoloških rješenja. Po veličini zauzima 6. mjesto među rimskim amfiteatrima na svijetu, te je jedini u svijetu čija su sva tri rimska arhitektonska reda u potpunosti očuvana. Pulski se amfiteatar stavlja uz bok Koloseju u Rimu, Areni u Veroni, amfiteatrima u Pompejima, Nimesu i Arlesu u Francuskoj i El Džemu u Tunisu. "};
    TextView textView;
    int pozicija=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znamenitosti);
        textView=(TextView) findViewById(R.id.textView9);


        images= new int[]{
                R.drawable.hram,
                R.drawable.aw,

        };

        setText(pozicija);


    }
    void setText(int pozicija){
        pozicija++;
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter= new ImagePageAdapter(ZnamenitostiActivity.this,images);

        viewPager.setAdapter(adapter);
        textView.setText(znamenitost[pozicija]+" "+cijena[pozicija]);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText(znamenitost[position]+" "+cijena[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
