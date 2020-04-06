package com.example.uts_ku.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.uts_ku.R;
import com.example.uts_ku.model.Film;

public class DetailActivity extends AppCompatActivity {
    public static final String INI_FILM = "ini_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView nama = findViewById(R.id.tv_nama_detail);
        TextView deskripsi = findViewById(R.id.tv_desc_detail);
        TextView jenis = findViewById(R.id.tv_genre_detail);
        TextView pemeran = findViewById(R.id.tv_pemeran_detail);

        Film bioskop = getIntent().getParcelableExtra(INI_FILM);

        Glide.with(this).load(bioskop.getFoto()).into(imageView);
        nama.setText(bioskop.getNama());
        jenis.setText(bioskop.getJenis());
        deskripsi.setText(bioskop.getDeskripsi());
        pemeran.setText(bioskop.getPemeran());
    };
}
