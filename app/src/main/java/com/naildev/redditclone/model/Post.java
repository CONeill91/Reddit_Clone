package com.naildev.redditclone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by coneill on 25/06/2015.
 */
public class Post {
    @SerializedName("title")
    private String title;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("thumbnail")
    private String thumbnail;


    public String getPermalink() {
        return permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {

        return title;
    }
}
