package com.news.project.basicbankingapp.helperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.project.basicbankingapp.R;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.holder> {

    String data [];

    public MyAdapter(String[] data) {
        this.data = data;
    }


    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_user ,parent , false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAdapter.holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class holder extends RecyclerView.ViewHolder{

        TextView from_user , to_user , amount_send;
        public holder(@NonNull @NotNull View itemView) {
            super(itemView);
            from_user = (TextView)itemView.findViewById(R.id.sender);
            to_user = (TextView)itemView.findViewById(R.id.reciver);
            amount_send = (TextView)itemView.findViewById(R.id.amount_send);
        }
    }
}
