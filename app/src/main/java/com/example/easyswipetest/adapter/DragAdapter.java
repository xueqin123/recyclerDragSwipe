package com.example.easyswipetest.adapter;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyswipetest.R;
import com.example.easyswipetest.drag.ItemTouchHelperAdapter;
import com.example.easyswipetest.drag.SimpleItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DragAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemTouchHelperAdapter {
    private List<String> data;
    private ItemTouchHelper helper;

    public DragAdapter(RecyclerView recyclerView) {
        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("第 " + i + " 条数据");
        }
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(this);
        helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        holder.contentView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vib(v.getContext());
                helper.startDrag(holder);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //drag 相关
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        doSwipe(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    private void doSwipe(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i <= toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    private void vib(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
}
