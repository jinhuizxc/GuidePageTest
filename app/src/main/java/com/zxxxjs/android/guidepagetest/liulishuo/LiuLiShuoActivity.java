package com.zxxxjs.android.guidepagetest.liulishuo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.TimeUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zxxxjs.android.guidepagetest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class LiuLiShuoActivity extends AppCompatActivity {


    @BindView(R.id.videoView)
    PreviewVideoView videoView;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.indicator)
    PreviewIndicator indicator;

    private List<View> mViewList = new ArrayList<>();
    // 图片资源的id
    private int[] mImageResIds = new int[]{R.mipmap.intro_text_1, R.mipmap.intro_text_2, R.mipmap.intro_text_3};
    private CustomPagerAdapter customPagerAdapter;

    private int currentPage = 0;
    private Subscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liulishuo);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        videoView.setVideoURI(Uri.parse(getVideoPath()));

        // 遍历图片资源
        for (int i = 0; i < mImageResIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_preview, null, false);
            ((ImageView)view.findViewById(R.id.iv_intro_text)).setImageResource(mImageResIds[i]);
            mViewList.add(view);
        }

        customPagerAdapter = new CustomPagerAdapter(mViewList);
        viewpager.setAdapter(customPagerAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                indicator.setSelected(position);
                startLoop();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        startLoop();
    }

    private void startLoop() {
        if (null != subscription){
            subscription.unsubscribe();
        }
        subscription = Observable.interval(0, 6*1000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        videoView.seekTo(currentPage * 6 * 1000);
                        if (!videoView.isPlaying()){
                            videoView.start();
                        }
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != subscription){
            subscription.unsubscribe();
        }
    }

    /**
     * 获取视频播放的路径
     * @return
     */
    private String getVideoPath() {
        return "android.resource://" + this.getPackageName() + "/" + R.raw.intro_video;
    }
}
