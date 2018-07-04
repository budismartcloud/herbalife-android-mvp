package com.example.user.herbalifemvp.presentation.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.presentation.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class SplashScreenActivity extends BaseActivity implements SplashScreenContract.View {

    @BindView(R.id.prog)
    ProgressBar progressBar;
    @BindView(R.id.load)
    TextView loadTextView;
    int total=0;
    Intent intent;
    boolean isRunning=false;
    SplashScreenContract.Presenter mPresenter;
    SplashScreenPresenter splashScreenPresenter;

    protected int getLayoutId() {
        return R.layout.splash_screen;
    }

    @Override
    public void setPresenter(@NonNull SplashScreenContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
        progressBar.setProgress(0);
        Thread background=new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i=0;i<5 && isRunning;i++) {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());
                    }
                    isRunning = false;
                    finish();
                }
                catch (Throwable t) {

                }

                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }

        });
        isRunning=true;
        background.start();
    }

    Handler handler=new Handler()
    {
        //coding ini yang akan menampilkan berapa persen progress yang telah dijalani.
        @Override
        public void handleMessage(Message msg)
        {
            total=total+20;
            String perc = String.valueOf(total).toString();
            loadTextView.setText(perc+"% Completed");
            progressBar.incrementProgressBy(20);
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        splashScreenPresenter = new SplashScreenPresenter(this, this);
        if(splashScreenPresenter.initDb()){
            Log.d("INIT DB", "SUKSES");
        }else{
            Log.d("INIT DB", "GAGAL");
        }
    }

}
