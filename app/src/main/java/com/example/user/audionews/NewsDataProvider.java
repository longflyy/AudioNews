package com.example.user.audionews;

import java.util.Calendar;

/**
 * Created by USER on 18/10/2015.
 */
public class NewsDataProvider {
    private int news_pics_resource;
    private String news_titles, mTxtTimes;
    private String AM_PM = "";
    int year,month,day,hour, min;

    public NewsDataProvider(int news_pics_resource, String news_titles){
        this.setNews_pics_resource(news_pics_resource);
        this.setNews_titles(news_titles);
        this.setTimes(mTxtTimes);
    }

    public int getNews_pics_resource() {
        return news_pics_resource;
    }

    public void setNews_pics_resource(int news_pics_resource) {
        this.news_pics_resource = news_pics_resource;
    }

    public String getNews_titles() {
        return news_titles;
    }

    public void setNews_titles(String news_titles) {
        this.news_titles = news_titles;
    }

    public String getTime(){
        Calendar c= Calendar.getInstance();
        if (c.get(Calendar.AM_PM) == 0) {
            AM_PM = "AM";
        } else {
            AM_PM = "PM";
        }
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        min = c.get(Calendar.MINUTE);
        String s = year + "/" + month + "/" + day + "," + hour + ":" + min + " " + AM_PM;
        System.out.println(s);
        return s;

    }

    public void setTimes(String mTxtTimes) {
        this.mTxtTimes = mTxtTimes;
    }

}
