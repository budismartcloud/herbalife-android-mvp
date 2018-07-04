package com.example.user.herbalifemvp.presentation.catalog;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.presentation.detailcatalog.DetailCatalogActivity;
import com.example.user.herbalifemvp.presentation.main.MainContract;
import com.example.user.herbalifemvp.presentation.main.MainPresenter;

import java.util.ArrayList;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class CatalogActivity extends BaseActivity implements CatalogContract.View {
    @BindView(R.id.list_tumbuhan)
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> catalogs;
    CatalogContract.Presenter mPresenter;
    CatalogPresenter catalogPresenter;
    int checked = -1;

    protected int getLayoutId() {
        return R.layout.activity_catalog;
    }

    @Override
    public void setPresenter(@NonNull CatalogContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
    }

    @Override
    public void displayCatalogList()
    {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catalogs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
            {
                checked = arg2;
                String tumbuhan = catalogs.get(checked);

                Intent tambah = new Intent(CatalogActivity.this, DetailCatalogActivity.class);
                tambah.putExtra("kirim_tumbuhan",tumbuhan);
                startActivity(tambah);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        catalogPresenter = new CatalogPresenter(this, this);
        catalogs = new ArrayList<String>();
        catalogs = mPresenter.getCatalogs();
        displayCatalogList();
    }
}
