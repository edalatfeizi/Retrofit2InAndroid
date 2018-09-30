package com.feizi.networkingusingretrofit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feizi.networkingusingretrofit2.model.CreateUserResponse;
import com.feizi.networkingusingretrofit2.model.UserInfo;
import com.feizi.networkingusingretrofit2.networking.RetrofitClient;
import com.feizi.networkingusingretrofit2.networking.UserRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText etUserName,etEmail;
    private Button btnSignUp;
    private UserRequest userRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUserName = findViewById(R.id.et_user_name);
        etEmail = findViewById(R.id.et_email);
        btnSignUp = findViewById(R.id.btn_sign_up);
        userRequest = RetrofitClient.getClient().create(UserRequest.class);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final UserInfo userInfo = new UserInfo();
                userInfo.setUserName(etUserName.getText().toString());
                userInfo.setEmail(etEmail.getText().toString());
                userRequest.sendUserInfo(userInfo).enqueue(new Callback<CreateUserResponse>() {
                    @Override
                    public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                        if (response.body() != null && response.body().isUserCreated()){
                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            intent.putExtra("email",userInfo.getEmail());
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
