package com.{company_name}.android.{app_package_name_prefix}.activity;

import android.content.Context;
import android.os.Bundle;

import com.{company_name}.android.{app_package_name_prefix}.R;
import com.{company_name}.android.{app_package_name_prefix}.mvp.presenter.Presenter;

import butterknife.InjectView;
import butterknife.OnPageChange;

public class HomeActivity extends PresentableActivity<Presenter> {

    @Override
    protected Presenter createPresenter() {
        // TODO!
        throw new IllegalStateException("Not implemented!");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.act_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
