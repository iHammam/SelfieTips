package com.aalpha_lab.selfietips;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter {

    private int[] imageResources = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
    };

    private String[] tipsNumber = {
            "Tips # 1",
            "Tips # 2",
            "Tips # 3",
            "Tips # 4",
            "Tips # 5",
            "Tips # 6",
            "Tips # 7"
    };

    private int[] tipsHeadings = {
            R.string.heading1,
            R.string.heading2,
            R.string.heading3,
            R.string.heading4,
            R.string.heading5,
            R.string.heading6,
            R.string.heading7
    };

    private int[] tipsDetails = {
            R.string.tips1,
            R.string.tips2,
            R.string.tips3,
            R.string.tips4,
            R.string.tips5,
            R.string.tips6,
            R.string.tips7
    };

    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textView_tipsNumber = (TextView) itemView.findViewById(R.id.text_view_tipsNumber);
        TextView textView_tipsHeadings = (TextView) itemView.findViewById(R.id.text_view_tipsHeading);
        TextView textView_tipsDetails = (TextView) itemView.findViewById(R.id.text_view_tipsDetails);

        imageView.setImageResource(imageResources[position]);
        textView_tipsNumber.setText(tipsNumber[position]);
        textView_tipsHeadings.setText(tipsHeadings[position]);
        textView_tipsDetails.setText(tipsDetails[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
