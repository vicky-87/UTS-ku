package com.example.menu_item;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyJSON {
    private String jsonString;
    private String url;
    private int timeOut;
    private Context mContext;
    ArrayList<Menu> semuaMenu;

    private String namaTable;

    public MyJSON(Context context, String url, int timeOut) {
        namaTable = context.getString(R.string.table);
        semuaMenu = new ArrayList<>();
        this.url = url;
        this.timeOut = timeOut;
        this.mContext = context;
        parseJSON(); // Pembuatan objek MyJSON akan langsung memanggil method parseJSON
    }

    //Mendownload JSON. yang didownload berupa teks atau string. (setJsonStringFromUrl)
    private void setJsonStringFromUrl(String url, int timeOut) {
        Log.i("getJsonString", "do");
        HttpURLConnection c = null;
        try {
            URL u = new URL(this.url);
            Log.i("url", url);
            c = (HttpURLConnection) u.openConnection();
            Log.i("HttpUrlConnection", c.toString());
            c.setRequestMethod("GET");
            c.setRequestProperty("content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeOut);
            c.setReadTimeout(timeOut);
            c.connect();
            int status = c.getResponseCode();
            Log.i("c.getResponseCode", status+"");
            switch (status){ // respon 201 berarti sukses terhubung
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line=br.readLine()) != null){
                        sb.append(line+"\n");
                    }
                    br.close();
                    jsonString = sb.toString(); // ini dia pengisian variabel jsonString dengan data JSON yg didownload
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (c!=null){
                c.disconnect();
            }
        }
    }

    private void parseJSON(){
        setJsonStringFromUrl(url, timeOut); // memanggil method setJsonStringFrom url untuk mengisi variabel jsonString
        if (getJsonString() == null){
            Log.i("parseJSON", "Parsing JSON Gagal!");
            return;
        }else{
            try{
                //disesuaikan dengan format JSON yang dibuat.
                JSONObject jObj = new JSONObject(getJsonString()); // objek JSON -> tanda kurung kurawal {}
                JSONArray jArray = jObj.getJSONArray(namaTable);    // array JSON -> tanda kurung siku []

                // formatnya yang saya pakai ada satu objek-> didalam objek ada array-> di dalam array ada objek lagi.
                for (int i=0; i<jArray.length(); i++){ //karena array, maka kita ambil isinya (objek) satu persatu dengan cara ini.
                    JSONObject jsonMenu = jArray.getJSONObject(i);  // inilah objek nya yang ada didalam array.
                    Menu menu = new Menu(); // kita buat objek menu untuk kita masukkan kedalam arrayList semuaMenu.
                    menu.setId(jsonMenu.getInt("id"));          // kita ambil data id yang ada pada objek jsonMenu kemudian diisikan ke data id pada objek menu.
                    menu.setNama(jsonMenu.getString("nama"));   // mirip seperti yang diatas hanya berbeda pada datanya.
                    menu.setJenis(jsonMenu.getInt("jenis"));    // ini juga.
                    menu.setHarga(jsonMenu.getInt("harga"));    // dan ini juga mirip dg yg diatas.
                    menu.setUrlGambar(jsonMenu.getString("gambar")); // mirip yg diatas
                    semuaMenu.add(menu); // kita masukkan objek menu ke dalam arraylist
                    //kembali ke for(). i bertambah satu dst.
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getJsonString() {
        return jsonString;
    }

    public ArrayList<Menu> getSemuaMenu(){
        return semuaMenu;
    }
}
