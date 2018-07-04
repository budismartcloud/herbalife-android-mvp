package com.example.user.herbalifemvp.presentation.splashscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.sqlite.SQLiteDBHelper;

/**
 * Created by User on 5/20/2018.
 */

public class SplashScreenPresenter implements SplashScreenContract.Presenter {
    @NonNull SplashScreenContract.View mView;
    Context mContext;
    SQLiteDBHelper sqLiteDBHelper;

    public SplashScreenPresenter(@NonNull SplashScreenContract.View view, Context context)
    {
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        sqLiteDBHelper = new SQLiteDBHelper(context);
    }

    @Override
    public boolean initDb()
    {
        try{
            sqLiteDBHelper.getDb();
            return true;
        }catch (Exception e){
            Log.d("INIT DB GAGAL", e.toString());
            return false;
        }
    }

    @Override
    public void start()
    {
        //todo
    }
}
