package com.news.project.basicbankingapp.userData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.news.project.basicbankingapp.R;
import com.news.project.basicbankingapp.databinding.ActivityAllUsersBinding;
import com.news.project.basicbankingapp.helperClasses.DatabaseHelper;
import com.news.project.basicbankingapp.helperClasses.UserInfo;

public class AllUsers extends AppCompatActivity {

    ActivityAllUsersBinding binding;
    UserInfo userInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityAllUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        // database creation
        DatabaseHelper dh = new DatabaseHelper(this);

        displayAllUserData();

        binding.user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user1.getText().toString() ,binding.user1AccountNo.getText().toString() ,
                        binding.user1AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user2.getText().toString() ,binding.user2AccountNo.getText().toString() ,
                        binding.user2AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user3.getText().toString() ,binding.user3AccountNo.getText().toString() ,
                        binding.user3AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user4.getText().toString() ,binding.user4AccountNo.getText().toString() ,
                        binding.user4AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user5.getText().toString() ,binding.user5AccountNo.getText().toString() ,
                        binding.user5AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user6.getText().toString() ,binding.user6AccountNo.getText().toString() ,
                        binding.user6AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user7.getText().toString() ,binding.user7AccountNo.getText().toString() ,
                        binding.user7AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user8.getText().toString() ,binding.user8AccountNo.getText().toString() ,
                        binding.user8AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user9.getText().toString() ,binding.user9AccountNo.getText().toString() ,
                        binding.user9AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });
        binding.user10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo = new UserInfo(binding.user10.getText().toString() ,binding.user10AccountNo.getText().toString() ,
                        binding.user10AccountBalance.getText().toString());
                startActivity(new Intent(AllUsers.this , UserDetatils.class));
            }
        });

    }

    private void displayAllUserData()
    {
        Cursor cursor = new DatabaseHelper(this).readAllUsersData();
        int accountNumberIndex = cursor.getColumnIndex(DatabaseHelper.Col1);
        int nameColumnIndex = cursor.getColumnIndex(DatabaseHelper.Col2);
        int accountBalanceColumnIndex = cursor.getColumnIndex(DatabaseHelper.Col3);

        int incrementVariable = 0;
        while (cursor.moveToNext()){
            String userName = cursor.getString(nameColumnIndex);
            int accountNumber = cursor.getInt(accountNumberIndex);
            int accountBalance = cursor.getInt(accountBalanceColumnIndex);
            ++incrementVariable;
            switch (incrementVariable){
                case 1:{
                    binding.user1.setText(userName);
                    binding.user1AccountBalance.setText( accountBalance);
                    binding.user1AccountNo.setText(""+accountNumber);
                    break;
                }
                case 2:{
                    binding.user2.setText(userName);
                    binding.user2AccountBalance.setText( accountBalance);
                    binding.user2AccountNo.setText(""+accountNumber);
                    break;
                }
                case 3:{
                    binding.user3.setText(userName);
                    binding.user3AccountBalance.setText( accountBalance);
                    binding.user3AccountNo.setText(""+accountNumber);
                    break;
                }
                case 4:{
                    binding.user4.setText(userName);
                    binding.user4AccountBalance.setText( accountBalance);
                    binding.user4AccountNo.setText(""+accountNumber);
                    break;
                }
                case 5:{
                    binding.user5.setText(userName);
                    binding.user5AccountBalance.setText( accountBalance);
                    binding.user5AccountNo.setText(""+accountNumber);
                    break;
                }
                case 7:{
                    binding.user7.setText(userName);
                    binding.user7AccountBalance.setText( accountBalance);
                    binding.user7AccountNo.setText(""+accountNumber);
                    break;
                }
                case 6:{
                    binding.user6.setText(userName);
                    binding.user6AccountBalance.setText( +accountBalance);
                    binding.user6AccountNo.setText(""+accountNumber);
                    break;
                }
                case 8:{
                    binding.user8.setText(userName);
                    binding.user8AccountBalance.setText( +accountBalance);
                    binding.user8AccountNo.setText(""+accountNumber);
                    break;
                }
                case 9:{
                    binding.user9.setText(userName);
                    binding.user9AccountBalance.setText( accountBalance);
                    binding.user9AccountNo.setText(""+accountNumber);
                    break;
                }
                default:
                {
                    binding.user10.setText(userName);
                    binding.user10AccountBalance.setText(accountBalance);
                    binding.user10AccountNo.setText(""+accountNumber);
                    break;
                }
            }
        }
    }
}