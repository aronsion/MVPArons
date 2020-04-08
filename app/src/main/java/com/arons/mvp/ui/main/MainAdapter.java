package com.arons.mvp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arons.mvp.R;

import java.util.List;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    private final Listener listener;
    private final List<String> items;

    interface Listener{
        void onItemClicked(String name);
    }

    public MainAdapter(List<String> items, Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View)LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        String item = items.get(position);
        holder.mTextView.setText(item);
        holder.mTextView.setOnClickListener((v)-> listener.onItemClicked(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_content);
        }
    }
}
