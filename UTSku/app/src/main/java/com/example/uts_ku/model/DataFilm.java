package com.example.uts_ku.model;

import java.util.ArrayList;

public class DataFilm {
    public static String[][] data = new String[][] {

            {"JANGKRIK BOSS (2018)",
                    "Film Comedy",
                    "Menceritakan kembali film warkop pada zaman tahun 90 an yang diperani oleh Indro, Kasino, dan Dono.",
                    "https://upload.wikimedia.org/wikipedia/id/1/10/What%27s_Wrong_with_Secretary_Kim.jpg",
                    "Tora Sudiro, Indro Warkop, "},

    };

    public static ArrayList<Film> getListData() {
        Film bioskop;
        ArrayList<Film> list = new ArrayList<>();

        for (String[] mData : data) {
            bioskop = new Film();
            bioskop.setNama(mData[0]);
            bioskop.setJenis(mData[1]);
            bioskop.setDeskripsi(mData[2]);
            bioskop.setFoto(mData[3]);
            bioskop.setPemeran(mData[4]);

            list.add(bioskop);
        }
        return list;
    }
}
