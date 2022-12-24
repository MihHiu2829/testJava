package com.example.testprojectexample.Act.View;

import android.view.View;

import com.example.testprojectexample.Act.Frg.m001_Login;
import com.example.testprojectexample.R;
import com.example.testprojectexample.ViewModel.base_ViewModel_API;
import com.example.testprojectexample.databinding.M001MainBinding;

public class MainActivity extends base_Activity<M001MainBinding, Common> {


    @Override
    protected int getIDmain() {
        return R.id.ln_main;
    }

    @Override
    protected void initViews() {
        showFragment(m001_Login.class.getName(),null,false);
    }

    @Override
    protected Class<Common> ClassVM() {
        return Common.class;
    }

    @Override
    protected M001MainBinding initViewBinding() {
        return M001MainBinding.inflate(getLayoutInflater()) ;
    }

    @Override
    public void onClick(View view) {

    }
}