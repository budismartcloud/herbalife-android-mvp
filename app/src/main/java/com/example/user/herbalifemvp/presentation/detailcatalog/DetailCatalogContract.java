package com.example.user.herbalifemvp.presentation.detailcatalog;

import com.example.user.herbalifemvp.base.BasePresenter;
import com.example.user.herbalifemvp.base.BaseView;
import com.example.user.herbalifemvp.datasource.models.Catalog;

/**
 * Created by User on 5/20/2018.
 */

public interface DetailCatalogContract {
    interface View extends BaseView<Presenter> {
        //todo
        void displayDetail();

    }

    interface Presenter extends BasePresenter {
        //todo
        Catalog getDetail(String name);

    }
}
