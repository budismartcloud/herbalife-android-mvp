package com.example.user.herbalifemvp.datasource.sqlite;

import android.content.Context;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.models.Disease;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public class SQLiteController {
    private SQLiteDBHelper sqLiteDBHelper;
    Context context;

    public SQLiteController(Context mContext){
        this.context = mContext;
        sqLiteDBHelper = new SQLiteDBHelper(context);
    }

    public ArrayList<String> getCatalogs(){
        ArrayList<String> catalogs;
        catalogs = new ArrayList<String>();
        try{
            catalogs = sqLiteDBHelper.getCatalogs();

        }catch (Exception e){
            e.printStackTrace();
        }

        return catalogs;
    }

    public Catalog getCatalog(String name){
        Catalog catalog;
        try{
            catalog = sqLiteDBHelper.getCatalog(name);
        }catch (Exception e){
            catalog = new Catalog();
            e.printStackTrace();
        }
        return catalog;
    }

    public ArrayList<String> getDiseases(){
        ArrayList<String> diseases;
        diseases = new ArrayList<String>();
        try{
            diseases = sqLiteDBHelper.getDiseases();

        }catch (Exception e){
            e.printStackTrace();
        }

        return diseases;
    }

    public Disease getDisease(String name){
        Disease disease;
        try{
            disease = sqLiteDBHelper.getDisease(name);
        }catch (Exception e){
            disease = new Disease();
            e.printStackTrace();
        }
        return disease;
    }
}
