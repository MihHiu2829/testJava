package com.example.testprojectexample.Act.Frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.testprojectexample.ViewModel.base_ViewModel_API;
import com.example.testprojectexample.onMainAPICallBack;
import com.example.testprojectexample.onMainCallBack;

public abstract class base_Fragment <T extends ViewBinding, M extends base_ViewModel_API>
        extends Fragment implements onMainAPICallBack {

    T binding ;
    M viewModel ;
    Context context ;
    Object data ;
    onMainCallBack callBack ;



    public void setData(Object data) {
        this.data = data;
    }

    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBindings(inflater,container) ;
        viewModel = new ViewModelProvider(this).get(ClassVM());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot() ;

    }

    protected abstract void initViews();

    protected abstract Class<M> ClassVM();

    protected abstract T initViewBindings(LayoutInflater inflater, ViewGroup container);

    @Override
    public void apiSuccess(String key, Object data) {
        // do nothing
    }

    @Override
    public void apiError(String key, int code, Object data) {
        Toast.makeText(context, "Error: ", Toast.LENGTH_SHORT).show();
    }
}
