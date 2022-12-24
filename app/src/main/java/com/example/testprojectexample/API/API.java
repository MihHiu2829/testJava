package com.example.testprojectexample.API;

import com.example.testprojectexample.API.Req.ReqLogin;
import com.example.testprojectexample.API.Res.GetKey;
import com.example.testprojectexample.API.Res.ResLogin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {

   //https://hackathon.hdbank.com.vn/open-api/vi/swg
    String API_key = "eyJraWQiOiJXcDRGMndiQVpMa1d2WWgyNDhnYjNtUHBLRzZTdDRNcG85Tmc3U2diZ2E0PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI4MWViNDQ4ZS00OWIzLTQzMGQtYWJkOS03ZDMyNWM0ZTkxYmYiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoZWFzdC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoZWFzdC0xX1FiMVE4VFBzVSIsImNvZ25pdG86dXNlcm5hbWUiOiI4MWViNDQ4ZS00OWIzLTQzMGQtYWJkOS03ZDMyNWM0ZTkxYmYiLCJvcmlnaW5fanRpIjoiYzQ4OWNmMmUtZWJjNS00MjAyLTg2OGEtNmRjMDA1OTY1MDhhIiwiYXVkIjoic2lrY25laTR0MmgzbnRrcWo1ZDQ5bHR2ciIsImV2ZW50X2lkIjoiNTc1ODc5NjItNzdiMS00YjI0LWE3M2MtZTY0NzQ2OWFiOTkzIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NzE3OTkwNzEsIm5hbWUiOiJNaW5oIEhp4bq_dSIsImV4cCI6MTY3MTg4NTQ3MiwiaWF0IjoxNjcxNzk5MDcyLCJqdGkiOiJmYWZkM2JjZC02YTY3LTRhYmItOGUxZC1kYjYzZWQzZWMzNjYiLCJlbWFpbCI6Im1oaWV1c3ouMjMuZGtjQGdtYWlsLmNvbSJ9.foNKVqYpixn_MAfTRQ-SausWZM-y7C88vM9u-z8Pg66I4aCCJ-4DXyFx0uJ8-lvVFTJhDDumwyxUBE1M7nfYZSwOwZXSkjBrZqxjDCXzuEYfTJ0ybP70kvP23t_zZX17DIt7Z3y_UkI0KncrUtDaWU3qykvtFMLbiOqQAfAVgpXPByuSE5_Rh8-LgbdL5wLCTGK2uONmeZfrUDdUYYOvn3QUmqOC4_2Dq7av8R-Okt5NV0QjzAbVyuxj_yy7ZvBiAzUq4zOjYHI0Tu-3RXGbXcmPpDpEB_g1xQn9njZEHJ7mnQ30tyxRz3ZRxbH8Ec9f4Qw3BbAUIxhRjI_Pm6_tcw" ;
    @GET("get_key")
    @Headers({"accept: application/json",
            "x-api-key: hutech_hackathon@123456",
            "access-token: "+API_key})
    Call<GetKey>getKeyAuthen() ;
    @POST("login")
    @Headers({"accept: application/json",
            "x-api-key: hutech_hackathon@123456",
            "Content-Type: application/json",
            "access-token: "+API_key})
    Call<ResLogin>getLogin(ReqLogin acc ) ;
}
