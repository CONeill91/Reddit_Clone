package com.naildev.redditclone.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by coneill on 25/06/2015.
 */
public class ChildrenArray {
    @SerializedName("children")
    private List<Children> childrenList;

    public List<Children> getChildrenList(){
        return childrenList;
    }
}
