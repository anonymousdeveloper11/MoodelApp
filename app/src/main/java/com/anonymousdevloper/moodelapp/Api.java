package com.anonymousdevloper.moodelapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

//    private static Retrofit retrofit;
//    public static Retrofit getRetrofit(){
//
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(ApiConstant.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//
//    public static LoginService getLoginService(){
//        LoginService loginService = getRetrofit().create(LoginService.class);
//        return loginService;
//    }

    private static String BASE_URL = "https://hr.utechitpro.com/api/";
    private static Api mInstance;
    private Retrofit retrofit;

    private Api()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized Api getInstance()
    {
        if(mInstance==null)
        {
            mInstance = new Api();
        }
        return mInstance;
    }

    public ApiService getApiService()
    {
        return retrofit.create(ApiService.class);
    }

}
