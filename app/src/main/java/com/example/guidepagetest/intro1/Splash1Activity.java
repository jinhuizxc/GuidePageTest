package com.example.guidepagetest.intro1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.example.guidepagetest.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等！
 * https://github.com/youth5201314/banner
 * <p>
 * <p>
 * 报错:
 * Caused by: java.lang.RuntimeException: [Banner] --> The number of titles and images is different
 */
public class Splash1Activity extends AppCompatActivity {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.btn_learn)
    Button btnLearn;

    private int images[] = new int[]{R.drawable.intro_1, R.drawable.intro_2, R.drawable.intro_3};
    private String[] str_titles = new String[]{"页面1", "页面2", "页面3"};

    private List<String> titles = new ArrayList<>();
    private List<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
        ButterKnife.bind(this);

        // 简单使用
//        simpleUse();

        for (int i = 0; i < images.length; i++) {
            imageList.add(images[i]);
//            titles.add(str_titles[i]);
        }

        // 详细使用
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(false);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == imageList.size() - 1) {
                    btnLearn.setVisibility(View.VISIBLE);
                } else {
                    btnLearn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void simpleUse() {
        banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
//        banner.startAutoPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束轮播
//        banner.stopAutoPlay();
    }

    @OnClick(R.id.btn_learn)
    public void onViewClicked() {
        ToastUtils.showShort("go App");
    }

}
