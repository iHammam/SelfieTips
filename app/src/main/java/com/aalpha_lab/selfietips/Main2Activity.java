package com.aalpha_lab.selfietips;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    private LinearLayout mainIndicator;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        context = this;
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        mainIndicator = (LinearLayout) findViewById(R.id.mainIndicator);
        viewPager.setAdapter(adapter);
        controlDots(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {
                // TODO Auto-generated method stub

                controlDots(pos);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


    protected void controlDots(int newPageNumber) {

        try {
            mainIndicator.removeAllViews(); // simple linear layout

            final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(

                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(7, 2, 0, 2);

            final ImageView[] b = new ImageView[7];

            // Log.e("Shop size ", ">>>" + db.getAllShoppingName().size());

            for (int i1 = 0; i1 < 7; i1++) {

                b[i1] = new ImageView(context);

                b[i1].setId(1000 + i1);

                if (newPageNumber == i1) {

                    b[i1].setBackgroundResource(R.drawable.dott);

                } else {

                    b[i1].setBackgroundResource(R.drawable.dot);

                }

                b[i1].setLayoutParams(layoutParams);

                mainIndicator.addView(b[i1]);

            }

        } catch (final Exception e) {

        }

    }

}
