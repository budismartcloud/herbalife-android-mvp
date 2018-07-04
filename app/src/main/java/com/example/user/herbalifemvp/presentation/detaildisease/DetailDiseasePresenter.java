package com.example.user.herbalifemvp.presentation.detaildisease;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.models.Disease;
import com.example.user.herbalifemvp.datasource.sqlite.SQLiteController;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogContract;

/**
 * Created by User on 5/20/2018.
 */

public class DetailDiseasePresenter implements DetailDiseaseContract.Presenter {
    @NonNull
    DetailDiseaseContract.View mView;
    Context mContext;
    SQLiteController sqliteController;

    public DetailDiseasePresenter(@NonNull DetailDiseaseContract.View view, Context context)
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
    public Disease getDetail(String name)
    {
        Disease disease;
        disease = new Disease();
        try{
            disease = sqliteController.getDisease(name);
        }catch (Exception e){
            e.printStackTrace();
        }

        return disease;
    }
}
