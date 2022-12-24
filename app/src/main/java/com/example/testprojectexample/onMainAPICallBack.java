package com.example.testprojectexample;

public interface onMainAPICallBack {
    void apiSuccess(String key, Object data) ;
    void apiError(String key,int code,Object data ) ;
}
