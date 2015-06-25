package com.naildev.redditclone.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coneill on 25/06/2015.
 */
public class Listing {
    @SerializedName("data")
    private ChildrenArray childrenArray;

    public List<Post> getPostList(){
        List<Post> postList  = new ArrayList<>();

        for(Children children: childrenArray.getChildrenList()){
            postList.add(children.getPost());
        }
        return postList;
    }
}
