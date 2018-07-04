package com.example.user.herbalifemvp.presentation.main;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.herbalifemvp.datasource.sqlite.SQLiteDBHelper;
import com.example.user.herbalifemvp.presentation.splashscreen.SplashScreenContract;

/**
 * Created by User on 5/20/2018.
 */

public class MainPresenter implements MainContract.Presenter {

    @NonNull
    MainContract.View mView;
    Context mContext;

    public MainPresenter(@NonNull MainContract.View view, Context context)
    {
        mView = view;
        mView.setPresenter(this);
        mContext = context;
    }

    @Override
    public void start(){
        //todo
    }
}
