package com.example.user.herbalifemvp.presentation.detailcatalog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.presentation.catalog.CatalogContract;
import com.example.user.herbalifemvp.presentation.catalog.CatalogPresenter;

import java.util.ArrayList;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class DetailCatalogActivity extends BaseActivity implements DetailCatalogContract.View {
    @BindView(R.id.nama_tumbuhan)
    TextView namaTumbuhan;
    @BindView(R.id.kegunaan)
    TextView kegunaan;
    @BindView(R.id.gambar)
    ImageView gambar;
    DetailCatalogContract.Presenter mPresenter;
    DetailCatalogPresenter detailCatalogPresenter;
    Catalog catalog;
    String cek;

    protected int getLayoutId() {
        return R.layout.activity_detail_catalog;
    }

    @Override
    public void setPresenter(@NonNull DetailCatalogContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
    }

    @Override
    public void displayDetail()
    {
        namaTumbuhan.setText(catalog.getNama());
        kegunaan.setText(catalog.getKegunaan());
        gambar.setImageBitmap(catalog.getImage());
    }

    @Override
    protected void onResume() {
        super.onResume();
        detailCatalogPresenter = new DetailCatalogPresenter(this, this);
        Intent intent = getIntent();
        cek = intent.getStringExtra("kirim_tumbuhan");
        catalog = detailCatalogPresenter.getDetail(cek);
        displayDetail();
    }
}
