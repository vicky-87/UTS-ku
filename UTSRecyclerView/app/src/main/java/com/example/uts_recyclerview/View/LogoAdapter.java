package com.example.uts_recyclerview.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uts_recyclerview.R;
import com.example.uts_recyclerview.model.Logo;

import java.util.List;

public class LogoAdapter extends RecyclerView.Adapter<LogoAdapter.ViewHolder> {
    private Context context;
    private List<Logo> items;

    public LogoAdapter(Context context, List<Logo> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_logo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogoAdapter.ViewHolder holder, int position) {
        Logo item = items.get(position);
        // Atur image di baris ini, dapat menggunakan Picasso atau Glide
        Glide.with(context).load(item.getLogo()).into(holder.logoImage);
        holder.nameText.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImage;
        TextView nameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImage = itemView.findViewById(R.id.image_logo);
            nameText = itemView.findViewById(R.id.text_name);
        }
    }
}
