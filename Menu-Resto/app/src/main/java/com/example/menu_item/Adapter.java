package com.example.menu_item;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    ArrayList<Menu> list;    // merupakan kumpulan dari objek menu
    Context mContext;       // digunakan pada Glide (gambar)
    String ipImage;

    public Adapter(ArrayList<Menu> semuaMenu, Context context) {
        this.list = semuaMenu;  // list yang ada pada klas ini diisi dengan semua menu makanan (semuaMenu)
        this.mContext = context;
        this.ipImage = context.getString(R.string.ip_image);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nama.setText(list.get(position).getNama());

        if(list.get(position).getJenis() == 1){
            holder.jenis.setText("Jenis: Minuman");
        }else{
            holder.jenis.setText("Jenis: Makanan");
        }

        //penggunaan library glide
        Glide.with(mContext) //konteks bisa didapat dari activity yang sedang berjalan
                .load(list.get(position).getUrlGambar()) // mengambil data dengan cara "list.get(position)" mendapatkan isi berupa objek Menu. kemudian "Menu.geturlGambar"
                .thumbnail(0.5f) // resize gambar menjadi setengahnya
                .crossFade() // animasi ketika muncul
                .into(holder.gambar); // mengisikan ke imageView
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //tambahan
    private String convertRupiah(int harga){
        String rupiah = "";
        String sementara = harga+"";
        String pecahan;
        Log.i("length", sementara.length()+"");
        while ((double)sementara.length()/3>1){
            pecahan = "." + sementara.substring(sementara.length()-3);
            Log.i("Pecahan", pecahan);
            rupiah = pecahan + rupiah;
            Log.i("Rupiah", rupiah);
            sementara = sementara.substring(0, sementara.length()-3);
            Log.i("Sementara", sementara);
        }
        rupiah = sementara + rupiah;
        Log.i("Rupiah", rupiah);
        return rupiah;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nama, jenis, harga;
        public ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
            jenis = (TextView) itemView.findViewById(R.id.jenis);
            harga= (TextView) itemView.findViewById(R.id.harga);
        }
    }
}
