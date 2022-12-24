package com.example.testprojectexample.ViewModel;

import com.example.testprojectexample.API.Req.ReqLogin;
import com.example.testprojectexample.API.Res.GetKey;
import com.example.testprojectexample.API.Res.ResLogin;
import com.example.testprojectexample.App;

public class m001_VM extends base_ViewModel_API
{

    public static final String LOGIN = "LOGIN" ;
    private static final String GET_KEY = "GET_KEY";

    public void  getKey()
    {
        getAPI().getKeyAuthen().enqueue(initHandleResponse(GET_KEY));
    }
    public void LoginAccount(String cre)
    {
        getAPI().getLogin(new ReqLogin(cre)).enqueue(initHandleResponse(LOGIN));
    }

    @Override
    protected void handleSuccess(String key, Object body) {
        super.handleSuccess(key, body);
        if(key.equals(GET_KEY))
        {
            GetKey res = (GetKey) body ;
            App.getInstance().getStorage().key = res.data.key ;
        }if(key.equals(LOGIN))
        {
            ResLogin res = (ResLogin) body ;
            callBack.apiSuccess(LOGIN,res) ;
        }
    }
}
