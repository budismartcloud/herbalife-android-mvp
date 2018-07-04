package com.example.user.herbalifemvp.presentation.detailcatalog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.sqlite.SQLiteController;
import com.example.user.herbalifemvp.presentation.catalog.CatalogContract;

/**
 * Created by User on 5/20/2018.
 */

public class DetailCatalogPresenter implements DetailCatalogContract.Presenter {

    @NonNull
    DetailCatalogContract.View mView;
    Context mContext;
    SQLiteController sqliteController;

    public DetailCatalogPresenter(@NonNull DetailCatalogContract.View view, Context context)
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
    public Catalog getDetail(String name)
    {
        Catalog catalog;
        catalog = new Catalog();
        try{
            catalog = sqliteController.getCatalog(name);
        }catch (Exception e){
            e.printStackTrace();
        }

        return catalog;
    }
}
