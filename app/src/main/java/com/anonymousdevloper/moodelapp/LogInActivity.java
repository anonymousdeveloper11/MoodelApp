package com.anonymousdevloper.moodelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.anonymousdevloper.moodelapp.databinding.ActivityLogInBinding;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {




    private ActivityLogInBinding binding;

    //private SharedPrefHandler sp;
    private PreferenceManager preferenceManager;

    //private static final String TAG ="LOGIN_PROFILE"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferenceManager = new PreferenceManager(getApplicationContext());
        if(preferenceManager.getBoolean(ApiConstant.KEY_IS_SIGNED_IN)){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
//        sp = SharedPrefHandler.getInstance(getApplicationContext());
//
//        if(sp.isLoggedIn()){
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        }

        binding.newUserTv.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);

        });

        binding.skipTv.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

    }

    private String username="", password="";
    private void validateData() {
        
        username = binding.emailEt.getText().toString().trim();
        password = binding.passwordEt.getText().toString().trim();
        
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        } else {
            loginUser(username, password);
        }


        
        
    }

    private void loginUser(String username, String password) {


//        LoginModel loginModel = new LoginModel();
//        loginModel.setUsername(binding.emailEt.getText().toString());
//        loginModel.setPassword(binding.passwordEt.getText().toString());
//
//        Call<LoginResponse> loginResponseCall = Api.getLoginService().userLogin(loginModel);
//        loginResponseCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(response.isSuccessful()){
//                    //Log.d(TAG, "onResponse: Profile Login"+);
//                    Toast.makeText(LogInActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
//                    //LoginResponse loginResponse = response.body();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        }
//                    },200);
//                }
//                else {
//                    Toast.makeText(LogInActivity.this, "Failed"+response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//
//                Toast.makeText(LogInActivity.this, "Failed"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        Call<LoginResponse> call = Api.getInstance().getApiService().login(username,password);
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(response.isSuccessful()){
//                    //Log.d(TAG, "onResponse: Profile Login"+);
//                    Toast.makeText(LogInActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
//                    //LoginResponse loginResponse = response.body();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        }
//                    },200);
//                }
//                else {
//                    Toast.makeText(LogInActivity.this, "Failed"+response.message(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                                Toast.makeText(LogInActivity.this, "Failed"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
        Call<LoginModel> call = Api.getInstance().getApiService().login(username, password);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.isSuccessful()){
                    //Log.d(TAG, "onResponse: Profile Login"+);
                    LoginModel loginModel = response.body();
                    preferenceManager.putBoolean(ApiConstant.KEY_IS_SIGNED_IN, true);
                    preferenceManager.putString(ApiConstant.KEY_USERNAME, preferenceManager.getString(ApiConstant.KEY_USERNAME));
                    Toast.makeText(LogInActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                    //LoginResponse loginResponse = response.body();
                    //LoginModel model = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //sp.saveLogin(model);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    },100);
                }
                else {
                    Toast.makeText(LogInActivity.this, "Failed"+response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                                Toast.makeText(LogInActivity.this, "Failed"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}