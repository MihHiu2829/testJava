package com.example.testprojectexample.Act.View;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.testprojectexample.Act.Frg.base_Fragment;
import com.example.testprojectexample.ViewModel.base_ViewModel_API;
import com.example.testprojectexample.onMainCallBack;

import java.lang.reflect.Constructor;

public abstract class base_Activity < T extends ViewBinding, M extends base_ViewModel_API>
        extends AppCompatActivity implements View.OnClickListener, onMainCallBack
{
            T binding ;
            M viewModel ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding() ;
        viewModel = new ViewModelProvider(this).get(ClassVM());
        initViews();
        setContentView(binding.getRoot());
    }

@Override
    public void showFragment(String TAG, Object data, boolean isBack) {
        try {
            Class<?> clazz = Class.forName(TAG) ;
            Constructor<?> cons = clazz.getConstructor() ;
            base_Fragment<?,?> frg = (base_Fragment<?, ?>) cons.newInstance();
            frg.setCallBack((onMainCallBack) this);
            frg.setData(data);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction() ;
            if(isBack)
                trans.addToBackStack(null);
            trans.replace(getIDmain(),frg,TAG).commit() ;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void toBackPrevious() {
        onBackPressed();
    }

    protected abstract int getIDmain();

    protected abstract void initViews();

    protected abstract Class<M> ClassVM();


    protected abstract T initViewBinding();


}
