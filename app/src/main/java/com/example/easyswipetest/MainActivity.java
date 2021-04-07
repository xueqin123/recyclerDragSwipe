package com.example.easyswipetest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyswipetest.adapter.DragAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DragAdapter(recyclerView);
        recyclerView.setAdapter(adapter);
    }
}