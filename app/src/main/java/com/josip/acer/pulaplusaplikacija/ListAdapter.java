package com.josip.acer.pulaplusaplikacija;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HG on 15.12.2016..
 */

public class ListAdapter extends ArrayAdapter<RestoraniModel>{
    SharedPreferences sharedPreferences;

    public ListAdapter(Context context, ArrayList<RestoraniModel> resource) {
        super(context,0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final RestoraniModel model = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row,parent,false);
        TextView ime = (TextView) convertView.findViewById(R.id.bla);
        ime.setText(model.getAddress());

        return convertView;
    }
}

