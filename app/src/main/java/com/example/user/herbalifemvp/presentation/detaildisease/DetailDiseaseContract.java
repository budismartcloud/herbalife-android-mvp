package com.example.user.herbalifemvp.presentation.detaildisease;

import com.example.user.herbalifemvp.base.BasePresenter;
import com.example.user.herbalifemvp.base.BaseView;
import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.models.Disease;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogContract;

/**
 * Created by User on 5/20/2018.
 */

public interface DetailDiseaseContract {
    interface View extends BaseView<Presenter> {
        //todo
        void displayDetail();

    }

    interface Presenter extends BasePresenter {
        //todo
        Disease getDetail(String name);

    }
}
