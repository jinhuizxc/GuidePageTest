package com.example.guidepagetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.adlibrary.bean.AdInfo;
import com.example.guidepagetest.ad_dialog.AdActivity;
import com.example.guidepagetest.liulishuo.LiuLiShuoActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 欢迎页->显示图片、视频等
 * 引导页场景测试；
 * <p>
 * Android酷炫欢迎页播放视频,仿蚂蜂窝自由行和慕课网
 * https://github.com/linglongxin24/WelcomeVideoPager
 * <p>
 * 手摸手带你用VideoView实现英语流利说炫酷引导页
 * https://github.com/JeasonWong/LiulishuoPreview
 * <p>
 * Android 启动页与广告页
 * https://github.com/zonezoen/ForGitHubProject
 * <p>
 * 简书对应的jsGuidePage的demo
 * https://github.com/mamumu/jsGuidePage
 * <p>
 * <p>
 * 一个简单，强大的广告活动弹窗控件
 * https://github.com/yipianfengye/android-adDialog
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_liulishuo)
    Button btLiulishuo;
    @BindView(R.id.bt_splash)
    Button btSplash;
    @BindView(R.id.bt_adDialog)
    Button btAdDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_liulishuo, R.id.bt_splash, R.id.bt_adDialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_liulishuo:
                ActivityUtils.startActivity(LiuLiShuoActivity.class);
                break;
            case R.id.bt_splash:
                break;
            case R.id.bt_adDialog:
                ActivityUtils.startActivity(AdActivity.class);
                break;
        }
    }

}
