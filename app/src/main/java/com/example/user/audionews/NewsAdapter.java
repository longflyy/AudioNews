package com.example.user.audionews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 18/10/2015.
 */
public class NewsAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public NewsAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{
        ImageView Pics;
        TextView Titles, mTxtTimes;
    }
    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row,parent, false);
            handler = new DataHandler();
            handler.Pics = (ImageView) row.findViewById(R.id.news_pic);
            handler.Titles = (TextView) row.findViewById(R.id.news_title);
            handler.mTxtTimes = (TextView) row.findViewById(R.id.txtTime);

            row.setTag(handler);
        }else{
            handler = (DataHandler) row.getTag();
        }
        NewsDataProvider dataProvider;
        dataProvider = (NewsDataProvider) this.getItem(position);
        handler.Pics.setImageResource(dataProvider.getNews_pics_resource());
        handler.Titles.setText(dataProvider.getNews_titles());
        handler.mTxtTimes.setText(dataProvider.getTime());


        return row;
    }
}
