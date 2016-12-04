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
    String [] cijena={"150","besplatno"};
    TextView textView;
    int pozicija=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znamenitosti);
        textView=(TextView) findViewById(R.id.textView9);


        images= new int[]{
                R.drawable.hram,
                R.drawable.shop,

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
