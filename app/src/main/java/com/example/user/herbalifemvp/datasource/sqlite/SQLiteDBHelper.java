package com.example.user.herbalifemvp.datasource.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.models.Disease;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public class SQLiteDBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "data2.sqlite";
    private static final int DATABASE_VERSION = 1;
    SQLiteDBHelper helper;

    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase getDb(){
        return getWritableDatabase();
    }

    public ArrayList<String> getCatalogs()
    {
        ArrayList<String> listItem;
        listItem = new ArrayList<String>();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "select * from Katalog";
            Cursor c = db.rawQuery(sql, null);
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast())
            {
                int index = c.getColumnIndex("Nama");
                String nama = c.getString(index);
                listItem.add(nama);
                i++;
                c.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listItem;
    }

    public ArrayList<String> getDiseases()
    {
        ArrayList<String> listItem;
        listItem = new ArrayList<String>();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "select * from data_penyakit";
            Cursor c = db.rawQuery(sql, null);
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast())
            {
                int index = c.getColumnIndex("Nama");
                String nama = c.getString(index);
                listItem.add(nama);
                i++;
                c.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listItem;

    }

    public Catalog getCatalog(String name)
    {
        Catalog catalog;
        catalog = new Catalog();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "select * from Katalog where Nama ='"+name+"'";
            Cursor c = db.rawQuery(sql, null);
            c.moveToFirst();
            int index1 = c.getColumnIndex("Kegunaan");
            int index3 = c.getColumnIndex("Gambar");
            byte[] image_byte = c.getBlob(index3);
            Bitmap image = BitmapFactory.decodeByteArray(image_byte, 0, image_byte.length);
            catalog.setNama(name);
            catalog.setKegunaan(c.getString(index1));
            catalog.setImage(image);

        }catch (Exception e){
            e.printStackTrace();
        }

        return catalog;

    }

    public Disease getDisease(String name)
    {
        Disease disease;
        disease = new Disease();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "select * from data_penyakit where Nama ='"+name+"'";
            Cursor c = db.rawQuery(sql, null);
            c.moveToFirst();
            int index1 = c.getColumnIndex("BahanObat");
            int index2 = c.getColumnIndex("Tutorial");
            String alat = c.getString(index1);
            String tutorial = c.getString(index2);
            disease.setName(name);
            disease.setBahan(alat);
            disease.setTutorial(tutorial);

        }catch (Exception e){
            e.printStackTrace();
        }

        return disease;

    }
}
