package com.example.guidepagetest.video.lazyload;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guidepagetest.R;
import com.example.guidepagetest.video.view.CustomVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Guide2Fragment extends LazyLoadFragment {

    @BindView(R.id.customVideoView)
    CustomVideoView customVideoView;
    Unbinder unbinder;
    private int index;

    @Override
    protected int setContentView() {
        return R.layout.fragment_guide2;
    }

    @Override
    protected void lazyLoad() {
        /**获取参数，根据不同的参数播放不同的视频**/
        assert getArguments() != null;
        index = getArguments().getInt("index");
        Uri uri;
        if (index == 1) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }
        /**播放视频**/
        customVideoView.playVideo(uri);
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        if (customVideoView != null){
            customVideoView.stopPlayback();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
