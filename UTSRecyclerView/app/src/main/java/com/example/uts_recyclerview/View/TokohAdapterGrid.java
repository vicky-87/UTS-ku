package com.example.uts_recyclerview.View;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TokohAdapterGrid extends RecyclerView.Adapter<TokohAdapterGrid.GridViewHolder>{
    @NonNull
    @Override
    public TokohAdapterGrid.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TokohAdapterGrid.GridViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
