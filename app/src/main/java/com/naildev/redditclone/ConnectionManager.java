package com.naildev.redditclone;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by coneill on 25/06/2015.
 */

/* Singelton Design Pattern, Object is created once & then shared. Only ever one instantiation*/

public class ConnectionManager {

    private static RequestQueue queue;

    // Guarantees Single Instantiation
    public static RequestQueue getInstance(Context context){
        if(queue == null){
            queue = Volley.newRequestQueue(context);
        }
        return queue;
    }

}
