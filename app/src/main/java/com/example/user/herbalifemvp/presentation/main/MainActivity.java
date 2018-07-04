package com.example.user.herbalifemvp.presentation.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.presentation.catalog.CatalogActivity;
import com.example.user.herbalifemvp.presentation.disease.DiseaseActivity;
import com.example.user.herbalifemvp.presentation.splashscreen.SplashScreenContract;
import com.example.user.herbalifemvp.presentation.splashscreen.SplashScreenPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by User on 5/20/2018.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener, MainContract.View {
    @BindView(R.id.btn_catalog) View catalogButton;
    @BindView(R.id.btn_search) View searchButton;
    @BindView(R.id.btn_help) View helpButton;
    @BindView(R.id.btn_exit) View exitButton;

    MainContract.Presenter mPresenter;
    MainPresenter mainPresenter;

    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
        searchButton.setOnClickListener(this);
        catalogButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.btn_search:
                Intent btn_search = new Intent(this, DiseaseActivity.class );
                startActivity(btn_search);
                break;
            case R.id.btn_catalog:
                Intent btn_catalog = new Intent(this, CatalogActivity.class );
                startActivity(btn_catalog);
                break;
            case R.id.btn_help:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("             Herbal Life  \n\n"
                        + "Herbal Life adalah \n"
                        + "aplikasi berbasis android \n"
                        + "yang berisi cara pengobatan penyakit\n"
                        + "terutama menggunakan tumbuhan herbal\n\n"
                        + "Menu Search:\n"
                        + "Digunakan untuk mencari jenis \n"
                        + "penyakit sesuai dengan keyword yang dimasukkan\n\n"
                        + "Menu Katalog:\n"
                        + "Berisi seluruh daftar tumbuhan \n"
                        + "yang bisa digunakan sebagai obat\n\n"
                        + "Application Name :\n\n"
                        + "Herbal Life v1.0.0\n\n" + "Developed By : \n\n"
                        + "Nama : Fajar Teguh \n"
                        + "Nrp    : 2103121006 \n"
                        + "Nama : Abdurachman Rizal    \n"
                        + "Nrp    : 2103121007 \n"
                        + "Nama : Moch Fajar Ramadhan \n"
                        + "Nrp    : 2103121027\n\n")
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                dialog.cancel();
                            }
                        });
                AlertDialog judul = builder.create();
                judul.setIcon(R.drawable.help);
                judul.setTitle("Help");
                judul.show();
                break;
            case R.id.btn_exit:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setMessage("Apakah anda benar-benar ingin keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Tidak",new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Ya",new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                MainActivity.this.finish();
                            }
                        });
                AlertDialog judul2 = builder2.create();
                judul2.setIcon(R.drawable.exit);
                judul2.setTitle("Exit");
                judul2.show();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter = new MainPresenter(this, this);
    }
}
