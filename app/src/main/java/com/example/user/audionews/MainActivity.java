package com.example.user.audionews;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView  mTxtTimes;
    ListView listView;
    int[] news_pics_resource = {R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3};
    String[] news_titles;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.news_list);
        news_titles = getResources().getStringArray(R.array.news_title);
        mTxtTimes = (TextView) findViewById(R.id.txtTime);


        runAdapter();

    }



    private void runAdapter(){
        int i=0;
        adapter = new NewsAdapter(getApplicationContext(), R.layout.single_row);
        listView.setAdapter(adapter);
        for (String titles: news_titles){
            NewsDataProvider dataProvider = new NewsDataProvider(news_pics_resource[i],
                    titles);
            adapter.add(dataProvider);
            i++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
