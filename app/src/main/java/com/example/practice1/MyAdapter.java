package com.example.practice1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;

    List<String> ids = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<String> mobile1s = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        final View view;
        if (viewType == TYPE_1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_item, parent, false);
            return new MyViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_contact, parent, false);
            return new MyViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_1)
            ((MyViewHolder) holder).bind(names.get(position));
        else
            ((MyViewHolder2) holder).bind(mobile1s.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (ids.get(position).equals("1"))
            return TYPE_1;
        else
            return TYPE_2;
    }

    public void setUsers(List<String> ids, List<String> names, List<String> mobile1s) {
        this.ids = ids;
        this.names = names;
        this.mobile1s = mobile1s;

        notifyDataSetChanged();
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text);
        }

        public void bind(String name) {
            nameTextView.setText(name);
        }
    }

    private static class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView mobile1TextView;

        public MyViewHolder2(@NonNull @NotNull View itemView) {
            super(itemView);
            mobile1TextView = itemView.findViewById(R.id.mobile1_text);
        }

        public void bind(String mobile1) {
            mobile1TextView.setText(mobile1);
        }
    }
}
