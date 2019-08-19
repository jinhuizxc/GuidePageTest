package com.example.guidepagetest.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guidepagetest.R;
import com.example.guidepagetest.video.view.CustomVideoView;

public class GuideFragment extends Fragment {

    private CustomVideoView customView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        customView = new CustomVideoView(getContext());
        // 获取参数，根据不同的参数播放不同的视频
        int index = getArguments().getInt("index");
        Uri uri;
        if (index == 1){
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
        }else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }
        // 播放视频
        customView.playVideo(uri);
        return customView;
    }

    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (customView != null){
            customView.stopPlayback();
        }
    }
}
