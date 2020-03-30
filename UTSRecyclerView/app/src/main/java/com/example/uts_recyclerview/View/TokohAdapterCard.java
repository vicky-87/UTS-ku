package com.example.uts_recyclerview.View;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TokohAdapterCard extends RecyclerView.Adapter<TokohAdapterCard.CardViewViewHolder>{

    @NonNull
    @Override
    public TokohAdapterCard.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TokohAdapterCard.CardViewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        public CardViewViewHolder(@NonNull View itemView) {

            super(itemView);
        }
    }
}
