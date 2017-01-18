package com.josip.acer.pulaplusaplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class ZnamenitostiActivity extends AppCompatActivity {
ViewPager viewPager;
PagerAdapter adapter;
    ImageView fashionImg;
    private Button sendMessage;
int [] images;
    String [] znamenitost={"The temple of Augustus","\n" + "Amphitheater in Pula","Tito 's  park","Little Rome Theatre in Pula","Archeologic Museum Istre"};
    String [] cijena={"Price : 10 kn adults, students 5 kn","Price : 50 kn adults, students 25kn","Price: free","Price : free","Price : closed because of construction works"};
    String [] opis={
            "\n" + "The Temple of Augustus is well-preserved Roman temple in the center of Pula in the main square Forum.\n +The temple dedicated to the first Roman Emperor Augustus was built during the emperor's life between 2 pr. Cr. and his death in 14 AD.",
            "\n" + "The amphitheater in Pula or Pula Arena is the largest and best preserved monument of ancient architecture in Croatia.",
            "\n" + "On the northeast of the park is Nimfej, located on the southwestern end of the building of the former printing house where it is today City Library,\n +  while at the southeast end of the park Petar Kresimir IV.",
            "\n" + "Little Roman Theatre, built probably in the 1st century on the eastern slope of the hill at the foot of the Pula old Castrum.\n Occupied a much larger area than today visible, because they are not completed by the end of archaeological research.",
            "The Archaeological Museum is a special museum was established in 1902 in Pula. It covers an area of 3600 m².\n The museum contains three collections: the prehistoric, ancient and late antique and medieval",
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
