package com.example.user.herbalifemvp.presentation.diseasesearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.sqlite.SQLiteController;
import com.example.user.herbalifemvp.presentation.disease.DiseaseContract;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public class DiseaseSearchPresenter implements DiseaseSearchContract.Presenter {
    @NonNull
    DiseaseSearchContract.View mView;
    Context mContext;
    SQLiteController sqliteController;

    public DiseaseSearchPresenter(@NonNull DiseaseSearchContract.View view, Context context)
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
}

