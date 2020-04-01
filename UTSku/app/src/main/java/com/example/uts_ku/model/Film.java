package com.example.uts_ku.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String nama;
    private String jenis;
    private String deskripsi;
    private String foto;
    private String pemeran;

    public Film(){

    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPemeran() {
        return pemeran;
    }

    public void setPemeran(String pemeran) {
        this.pemeran = pemeran;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.jenis);
        dest.writeString(this.deskripsi);
        dest.writeString(this.foto);
        dest.writeString(this.pemeran);
    }

    protected Film(Parcel in) {
        this.nama = in.readString();
        this.jenis = in.readString();
        this.deskripsi = in.readString();
        this.foto = in.readString();
        this.pemeran = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
