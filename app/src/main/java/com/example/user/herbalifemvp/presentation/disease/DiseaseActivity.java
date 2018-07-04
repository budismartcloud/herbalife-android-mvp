package com.example.user.herbalifemvp.presentation.disease;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.presentation.catalog.CatalogActivity;
import com.example.user.herbalifemvp.presentation.catalog.CatalogContract;
import com.example.user.herbalifemvp.presentation.catalog.CatalogPresenter;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogActivity;
import com.example.user.herbalifemvp.presentation.detaildisease.DetailDiseaseActivity;
import com.example.user.herbalifemvp.presentation.diseasesearch.DiseaseSearchActivity;

import java.util.ArrayList;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class DiseaseActivity extends BaseActivity implements DiseaseContract.View {
    @BindView(R.id.listpenyakit)
    ListView listView;
    @BindView(R.id.tombol_cari)
    Button buttonCari;
    ArrayAdapter<String> adapter;
    ArrayList<String> diseases;
    DiseaseContract.Presenter mPresenter;
    DiseasePresenter diseasePresenter;
    int checked = -1;
    protected int getLayoutId() {
        return R.layout.activity_disease;
    }

    @Override
    public void setPresenter(@NonNull DiseaseContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
    }

    public void displayDiseaseList()
    {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diseases);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                checked = arg2;
                String penyakit = diseases.get(checked);
                Intent tambah = new Intent(DiseaseActivity.this, DetailDiseaseActivity.class);
                tambah.putExtra("kirim_penyakit",penyakit);
                startActivity(tambah);
            }
        });

        buttonCari.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent tombol = new Intent(DiseaseActivity.this, DiseaseSearchActivity.class);
                startActivity(tombol);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        diseasePresenter = new DiseasePresenter(this, this);
        diseases = new ArrayList<String>();
        diseases = mPresenter.getDiseases();
        displayDiseaseList();

    }
}
