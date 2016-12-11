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
    String [] znamenitost={"Augustov hram","Amfiteatar u Puli","Titov park","Malo rimsko kazalište u Puli","Arheološki muzej Istre"};
    String [] cijena={"10 kn odrasli, učenici/studenti 5 kn","50 kn odrasli, učenici/studenti 25kn","besplatno","besplatno","zatvoreno zbog radova"};
    TextView textView;
    TextView tv;
    int pozicija=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znamenitosti);
        textView=(TextView) findViewById(R.id.textView9);
        tv=(TextView) findViewById(R.id.textView11);

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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
