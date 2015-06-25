package com.naildev.redditclone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.OkHttpClient;


public class MainActivity extends ActionBarActivity {

    public final String REDDIT_URL = "www.reddit.com/r/all.json?limit=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();

    }


}
