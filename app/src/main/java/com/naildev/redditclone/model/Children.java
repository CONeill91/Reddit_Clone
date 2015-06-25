package com.naildev.redditclone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by coneill on 25/06/2015.
 */
public class Children {
    @SerializedName("data")
    private Post post;

    public Post getPost(){
        return post;
    }
}
