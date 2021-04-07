package com.example.easyswipetest.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyswipetest.R;
import com.example.easyswipetest.drag.ItemTouchHelperViewHolder;


public class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    TextView textView;
    View contentView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view);
        contentView = itemView.findViewById(R.id.content);
    }

    @Override
    public void onItemSelected() {
        contentView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onItemClear() {
        contentView.setBackgroundColor(Color.TRANSPARENT);
    }
}
