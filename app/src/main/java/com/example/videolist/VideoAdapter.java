package com.example.videolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<String> blogList;
    Context context;

    public VideoAdapter(List<String> blogList, Context context) {
        this.blogList = blogList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String model = blogList.get(position);
        holder.bindData(model, position);
        holder.setOnVideoItemHolderListener(listener, model, context, position);
    }


    private VideoItemInteraction listener = null;
    public void setListener(VideoItemInteraction listener) {
        this.listener = listener;
    }


    @Override
    public int getItemCount() {
        return blogList.size();
    }
}
