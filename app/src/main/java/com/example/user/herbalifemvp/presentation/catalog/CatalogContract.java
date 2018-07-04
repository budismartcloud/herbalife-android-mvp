package com.example.user.herbalifemvp.presentation.catalog;

import com.example.user.herbalifemvp.base.BasePresenter;
import com.example.user.herbalifemvp.base.BaseView;
import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.presentation.main.MainContract;

import java.util.ArrayList;

/**
 * Created by User on 5/20/2018.
 */

public interface CatalogContract {
    interface View extends BaseView<Presenter> {
        //todo
        void displayCatalogList();
    }

    interface Presenter extends BasePresenter {
        //todo
        ArrayList<String> getCatalogs();
    }
}
