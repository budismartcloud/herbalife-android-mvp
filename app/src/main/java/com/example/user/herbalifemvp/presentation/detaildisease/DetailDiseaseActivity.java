package com.example.user.herbalifemvp.presentation.detaildisease;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.datasource.models.Catalog;
import com.example.user.herbalifemvp.datasource.models.Disease;
import com.example.user.herbalifemvp.presentation.catalog.CatalogActivity;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogContract;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogPresenter;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class DetailDiseaseActivity extends BaseActivity implements DetailDiseaseContract.View {
    @BindView(R.id.bahan)
    TextView bahan;
    @BindView(R.id.tutorial)
    TextView tutorial;
    @BindView(R.id.daftar_penyakit)
    TextView nama;
    @BindView(R.id.button1)
    Button catalogButton;

    DetailDiseaseContract.Presenter mPresenter;
    DetailDiseasePresenter detailDiseasePresenter;
    Disease disease;
    String cek;

    protected int getLayoutId() {
        return R.layout.activity_detail_disease;
    }

    @Override
    public void setPresenter(@NonNull DetailDiseaseContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
    }

    @Override
    public void displayDetail()
    {
        bahan.setText(disease.getBahan());
        tutorial.setText(disease.getTutorial());
        nama.setText(disease.getName());
        catalogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent tombol = new Intent(DetailDiseaseActivity.this, CatalogActivity.class);
                startActivity(tombol);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        detailDiseasePresenter = new DetailDiseasePresenter(this, this);
        Intent intent = getIntent();
        cek = intent.getStringExtra("kirim_penyakit");
        disease = detailDiseasePresenter.getDetail(cek);
        displayDetail();
    }

}
