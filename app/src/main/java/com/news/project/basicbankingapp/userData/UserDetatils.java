package com.news.project.basicbankingapp.userData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.news.project.basicbankingapp.R;
import com.news.project.basicbankingapp.databinding.ActivityUserDetatilsBinding;
import com.news.project.basicbankingapp.helperClasses.DialogBox;
import com.news.project.basicbankingapp.helperClasses.SelectedUserDisable;
import com.news.project.basicbankingapp.helperClasses.UserInfo;

public class UserDetatils extends AppCompatActivity {

    ActivityUserDetatilsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityUserDetatilsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.textView3.setText(UserInfo.getUsername());
        binding.textView5.setText(UserInfo.getAccountNumber());
        binding.textView7.setText(UserInfo.getCurrentBalance());

       // SelectedUserDisable.name = UserInfo.getUsername();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no = Integer.parseInt(UserInfo.getAccountNumber());
                SelectedUserDisable sUser = new SelectedUserDisable(no);
                startActivity(new Intent(UserDetatils.this , SelectUserForMT.class));
                }
        });


    }
}