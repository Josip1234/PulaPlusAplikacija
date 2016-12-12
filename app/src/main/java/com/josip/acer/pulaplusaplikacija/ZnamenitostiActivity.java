package com.josip.acer.pulaplusaplikacija;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class ZnamenitostiActivity extends AppCompatActivity {
ViewPager viewPager;
PagerAdapter adapter;
    ImageView fashionImg;
    private Button sendMessage;
int [] images;
    String [] znamenitost={"Augustov hram","Amfiteatar u Puli","Titov park","Malo rimsko kazalište u Puli","Arheološki muzej Istre"};
    String [] cijena={"Cijena : 10 kn odrasli, učenici/studenti 5 kn","Cijena : 50 kn odrasli, učenici/studenti 25kn","Cijena: besplatno","Cijena : besplatno","Cijena : zatvoreno zbog radova"};
    String [] opis={
            "Augustov hram je dobro očuvani rimski hram u centru Pule na središnjem gradskom trgu Forum. \n Hram koji je posvećen prvom rimskom caru Augustu sagrađen je za vrijeme careva života između 2. pr. Kr. i njegove smrti 14. godine nove ere.",
            "Amfiteatar u Puli ili Pulska Arena najveći je i najsačuvaniji spomenik antičkog graditeljstva u Hrvatskoj.",
            "Sa sjeveroistoka parka nalazi se Nimfej, na jugozapadnom kraju smještena je zgrada bivše tiskare u kojoj se danas nalazi Gradska knjižnica i čitaonica,\n dok se na jugoistočnom kraju nalazi park Petra Krešimira IV.",
            "Malo rimsko kazalište u Puli izgrađeno je vjerojatno u 1. stoljeću na istočnoj padini pulskog brežuljka podno starog Castruma.\n Zauzimalo je znatno veći prostor od onog danas vidljivog, jer nisu do kraja završena arheološka istraživanja.",
            "Arheološki muzej Istre je specijalni muzej osnovan 1902. godine u Puli. Prostire se na površini od 3600 m².\n Muzej sadrži tri zbirke: prapovijesnu, antičku, te kasnoantičku i srednjovjekovnu",
    };
    TextView textView;
    TextView tv;
    TextView o;
    int pozicija=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znamenitosti);


        // Locate the button in activity_main.xml
       sendMessage= (Button) findViewById(R.id.sendMessage);

        // Capture button clicks
        sendMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(ZnamenitostiActivity.this,
                        znam.class);
                startActivity(myIntent);
            }
        });





    textView=(TextView) findViewById(R.id.textView9);
        tv=(TextView) findViewById(R.id.textView11);
        o=(TextView) findViewById(R.id.textView12);

        images= new int[]{
                R.drawable.hram,
                R.drawable.pulskaarena6,
                R.drawable.titovpark,
                R.drawable.rimskokazaliste,
                R.drawable.arhmuzistrepula,

        };

        setText(pozicija);


    }
    void setText(int pozicija){
        pozicija++;
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter= new ImagePageAdapter(ZnamenitostiActivity.this,images);

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText(znamenitost[position]);
                tv.setText(cijena[position]);
                o.setText(opis[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




}
