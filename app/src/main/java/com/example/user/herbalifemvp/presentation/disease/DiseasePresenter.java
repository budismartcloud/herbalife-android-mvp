package com.example.user.herbalifemvp.presentation.disease;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.herbalifemvp.datasource.sqlite.SQLiteController;
import com.example.user.herbalifemvp.presentation.main.MainContract;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public class DiseasePresenter implements DiseaseContract.Presenter {
    @NonNull
    DiseaseContract.View mView;
    Context mContext;
    SQLiteController sqliteController;

    public DiseasePresenter(@NonNull DiseaseContract.View view, Context context)
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
    public ArrayList<String> getDiseases()
    {
        ArrayList<String> diseases;
        diseases = new ArrayList<String>();
        try{
            diseases = sqliteController.getDiseases();
            if(diseases.size() > 0){
                Log.d("DISEASES", "Panjang "+diseases.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return diseases;
    }
}
