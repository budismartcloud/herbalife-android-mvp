package com.example.user.herbalifemvp.presentation.splashscreen;

import com.example.user.herbalifemvp.base.BasePresenter;
import com.example.user.herbalifemvp.base.BaseView;

/**
 * Created by User on 5/20/2018.
 */

public interface SplashScreenContract {
    interface View extends BaseView<Presenter> {
       //todo
    }

    interface Presenter extends BasePresenter {
        boolean initDb();
    }
}
