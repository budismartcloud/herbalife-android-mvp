package com.example.user.herbalifemvp.datasource.models;

import android.graphics.Bitmap;

import java.sql.Blob;

/**
 * Created by User on 5/20/2018.
 */

public class Catalog {
    String nama;
    String kegunaan;
    Bitmap image;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKegunaan(){
        return this.kegunaan;
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan = kegunaan;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
