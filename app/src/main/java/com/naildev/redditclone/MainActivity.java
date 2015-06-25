package com.naildev.redditclone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.naildev.redditclone.database.DatabaseAccessObject;
import com.naildev.redditclone.model.Listing;
import com.naildev.redditclone.model.Post;

import java.io.IOException;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public final String REDDIT_URL = "http://www.reddit.com/r/all.json?limit=20";
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerListView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, REDDIT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Listing listing = new Gson().fromJson(response, Listing.class);
                        List<Post> postList = listing.getPostList();
                        RedditAdapter adapter = new RedditAdapter(listing.getPostList());
                        DatabaseAccessObject.getInstance().storePosts(MainActivity.this, postList);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Log.d("Error", "On error response");
            }
        });
        // Add the request to the RequestQueue.
        ConnectionManager.getInstance(this).add(stringRequest);




    }


}

/*
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(REDDIT_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("RESPONSE", response.body().string());
            }
        });
*/