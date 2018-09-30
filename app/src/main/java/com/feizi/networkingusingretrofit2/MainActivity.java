package com.feizi.networkingusingretrofit2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.feizi.networkingusingretrofit2.model.UserInfo;
import com.feizi.networkingusingretrofit2.networking.RetrofitClient;
import com.feizi.networkingusingretrofit2.networking.UserRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private UserRequest userRequest;
    private TextView tvUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserInfo = findViewById(R.id.tv_user_info);
        userRequest = RetrofitClient.getClient().create(UserRequest.class);
        String email = getIntent().getStringExtra("email");
        userRequest.getUserInfo(email).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if(response.body() != null){
                    String userInfo = "Username: "  + response.body().getUserName() + " User Email: " + response.body().getEmail();
                    tvUserInfo.setText(userInfo);

                }

            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed get user info!", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
