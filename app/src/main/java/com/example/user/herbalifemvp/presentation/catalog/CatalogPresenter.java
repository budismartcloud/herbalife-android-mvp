package com.example.user.herbalifemvp.presentation.catalog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.sqlite.SQLiteController;
import com.example.user.herbalifemvp.datasource.sqlite.SQLiteDBHelper;
import com.example.user.herbalifemvp.presentation.main.MainContract;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public class CatalogPresenter implements CatalogContract.Presenter {
    @NonNull
    CatalogContract.View mView;
    Context mContext;
    SQLiteController sqliteController;

    public CatalogPresenter(@NonNull CatalogContract.View view, Context context)
    {
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        sqliteController = new SQLiteController(context);
    }

    @Override
    public void start()
    {
        //todo
    }

    @Override
    public ArrayList<String> getCatalogs()
    {
        ArrayList<String> catalogs;
        catalogs = new ArrayList<String>();
        try{
            catalogs = sqliteController.getCatalogs();
            if(catalogs.size() > 0){
                Log.d("CATALOG", "Panjang "+catalogs.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return catalogs;
    }
}
