package com.example.videolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoItemInteraction {

    RecyclerView recyclerview;
    VideoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);

        List<String> list = new ArrayList<>();
        list.add("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");
        list.add("https://www.sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4");
       
//        list.add("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");
//        list.add("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");
//        list.add("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");
//        list.add("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new VideoAdapter(list, this);
//        adapter.setListener(this);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void notifyDataSetChanged() {

    }
}