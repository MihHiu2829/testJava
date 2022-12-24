package com.example.testprojectexample.API.Res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResLogin implements Serializable {
    @SerializedName("response")
    public response response ;
    @SerializedName("data")
    public data data ;
    public static  class  data
    {
        @SerializedName("data")
        public String data ;
    }
    public static class response{
        @SerializedName("responseId")
        public String responseId ;
        @SerializedName("responseCode")
        public String responseCode ;
        @SerializedName("responseMessage")
        public String responseMessage ;
        @SerializedName("responseTime")
        public String responseTime ;


    }
}
