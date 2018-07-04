package com.example.user.herbalifemvp.presentation.diseasesearch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.user.herbalifemvp.R;
import com.example.user.herbalifemvp.base.BaseActivity;
import com.example.user.herbalifemvp.datasource.models.Disease;
import com.example.user.herbalifemvp.presentation.catalog.CatalogActivity;
import com.example.user.herbalifemvp.presentation.detaildisease.DetailDiseaseActivity;
import com.example.user.herbalifemvp.presentation.detaildisease.DetailDiseaseContract;
import com.example.user.herbalifemvp.presentation.detaildisease.DetailDiseasePresenter;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by User on 5/20/2018.
 */

public class DiseaseSearchActivity extends BaseActivity implements TextWatcher, DiseaseSearchContract.View {
    @BindView(R.id.selection)
    TextView selection;
    @BindView(R.id.edit)
    AutoCompleteTextView edit;
    String[] items = { "Batuk Pada Anak", "Sakit Perut","Diare","Mual",
            "Kembung","Wasir","Biduran",
            "Demam","Step","Kencing Batu","Radang Paru-paru","Asma","Mimisan","Hepatitis",
            "Prostat","Keputihan","Diabetes Melitus","Bisul","Jerawat","Gatal berupa bintik-bintik merah bergelembung air",
            "Gatal pada bekas luka yang sudah kering","Nyeri haid","Haid bau anyir","Batuk Kering","Sariawan","Campak",
            "Borok","Jantung Lemah","Gangguan saraf","Rematik","Demam Pada Anak","Masuk Angin","Disentri","Hipertensi",
            "Diabetes","Kutu Air","Sakit Kepala","Flu","Bronkitis","Cacingan","Migrain","Maag","Cantengan","Osteoporosis"};

    DiseaseSearchContract.Presenter mPresenter;
    DiseaseSearchPresenter diseaseSearchPresenter;

    protected int getLayoutId() {
        return R.layout.activity_disease_search;
    }

    @Override
    public void setPresenter(@NonNull DiseaseSearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setView() {
        super.setView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        diseaseSearchPresenter = new DiseaseSearchPresenter(this, this);
        edit.addTextChangedListener(this);
        edit.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,items));
        edit.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Intent tambah = new Intent(DiseaseSearchActivity.this,DetailDiseaseActivity.class);
                String a = edit.getText().toString();
                tambah.putExtra("kirim_penyakit",a);
                startActivity(tambah);
            }

        });

    }

    public void onTextChanged(CharSequence s,int start,
                              int count,int before){
        selection.setText(edit.getText());


    }
    public void beforeTextChanged(CharSequence s,int start,
                                  int count,int after){

    }
    public void afterTextChanged(Editable s){

    }
}
