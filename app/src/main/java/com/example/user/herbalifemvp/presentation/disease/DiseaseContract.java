package com.example.user.herbalifemvp.presentation.disease;

import com.example.user.herbalifemvp.base.BasePresenter;
import com.example.user.herbalifemvp.base.BaseView;
import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogContract;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public interface DiseaseContract {
    interface View extends BaseView<Presenter> {
        //todo
        void displayDiseaseList();

    }

    interface Presenter extends BasePresenter {
        //todo
        ArrayList<String> getDiseases();

    }
}
