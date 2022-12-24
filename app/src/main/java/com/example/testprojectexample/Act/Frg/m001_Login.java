package com.example.testprojectexample.Act.Frg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.testprojectexample.App;
import com.example.testprojectexample.ViewModel.m001_VM;
import com.example.testprojectexample.databinding.ActivityLoginBinding;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class m001_Login extends base_Fragment<ActivityLoginBinding, m001_VM> {

    @Override
    protected void initViews() {
        viewModel.getKey();
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cre = "" ;
              String  un = binding.edtUn.getText().toString() ;
               String pw = binding.edtUn.getText().toString() ;
                String credentialTmp = "{\"username\":\"" + un
                        + "\",\"password\":\"" + pw + "\"\n" +
                        "}";
                try {
                    cre = Base64.getEncoder().encodeToString(encrypt(credentialTmp, App.getInstance().getStorage().key));
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                viewModel.LoginAccount(cre);
            }
        });
    }


    public static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    @Override
    public void apiSuccess(String key, Object data) {
        super.apiSuccess(key, data);
        if(key.equals(m001_VM.LOGIN))
        {
            Toast.makeText(context, "Thanh cong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Class<m001_VM> ClassVM() {
        return m001_VM.class;
    }

    @Override
    protected ActivityLoginBinding initViewBindings(LayoutInflater inflater, ViewGroup container) {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }
}
