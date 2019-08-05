package com.zxxxjs.android.guidepagetest.liulishuo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zxxxjs.android.guidepagetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 指示器
 */
public class PreviewIndicator extends LinearLayout {

    //指示器个数
    private int INDICATOR_COUNT = 3;
    private List<ImageView> imageViewList = new ArrayList<>();

    public PreviewIndicator(Context context) {
        this(context, null);
    }

    public PreviewIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreviewIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        for (int i = 0; i < INDICATOR_COUNT; i++) {
            ImageView imageView = new ImageView(getContext());
            if (i == 0) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_selected));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_unselected));
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(DensityUtil.dp2px(getContext(), 10), 0, DensityUtil.dp2px(getContext(), 10), 0);
            // 将imageView加载到layoutParams中
            addView(imageView, layoutParams);
            imageViewList.add(imageView);

        }

    }


    public void setSelected(int position){
        for (int i = 0; i < imageViewList.size(); i++) {
            ImageView imageView = imageViewList.get(i);
            if (i == position){
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_selected));
            }else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_unselected));
            }
        }
    }

}
