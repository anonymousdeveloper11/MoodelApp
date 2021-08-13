package com.anonymousdevloper.moodelapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST(ApiConstant.LOGIN_USER)
    Call<LoginResponse> userLogin(@Body LoginModel loginModel);
}
