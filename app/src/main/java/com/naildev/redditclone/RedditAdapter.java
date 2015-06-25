package com.naildev.redditclone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naildev.redditclone.model.Post;

import java.util.List;

/**
 * Created by coneill on 25/06/2015.
 */
public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.MyViewHolder> {

    List<Post> mPostList;

    public RedditAdapter(List<Post> postList){
        mPostList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_post,viewGroup,false);
        return new MyViewHolder( view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.textViewPostName.setText(mPostList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewPostName;

        public MyViewHolder(View itemView) {
            super(itemView);
          textViewPostName =  (TextView) itemView.findViewById(R.id.rowTextViewName);
        }
    }
}
