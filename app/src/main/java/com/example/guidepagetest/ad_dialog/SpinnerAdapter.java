package com.example.guidepagetest.ad_dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.guidepagetest.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    public List<DataBean> mList;
    public Context mContext;
    private LayoutInflater inflate;

    public SpinnerAdapter(List<DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        this.inflate = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
//            View view = mContext.getLayoutInflater().inflate(R.layout.adapter_item, null);
            View view = inflate.inflate(R.layout.adapter_item, null, false);
            TextView textView = (TextView) view.findViewById(R.id.adapter_item_text);
            textView.setText(mList.get(position).getAnimName());
            return textView;
        } else {
            return convertView;
        }
    }
}
