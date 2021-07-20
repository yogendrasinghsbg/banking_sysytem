package com.news.project.basicbankingapp.userData;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.news.project.basicbankingapp.R;
import com.news.project.basicbankingapp.databinding.ActivitySelectUserForMtBinding;
import com.news.project.basicbankingapp.databinding.ActivityUserDetatilsBinding;
import com.news.project.basicbankingapp.helperClasses.DatabaseHelper;
import com.news.project.basicbankingapp.helperClasses.DialogBox;
import com.news.project.basicbankingapp.helperClasses.SelectedUserDisable;

public class SelectUserForMT extends AppCompatActivity {


    ActivitySelectUserForMtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectUserForMtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // creating data base
        DatabaseHelper helper = new DatabaseHelper(this);
        displayAllUserData();

        DialogBox dialogBox = new DialogBox();
        binding.user1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor_temp = helper.readSingleUserData(11111);
                int accounbalaneIndex = cursor_temp.getColumnIndex(DatabaseHelper.Col3);
                int  nameColIndex = cursor_temp.getColumnIndex(DatabaseHelper.Col2);
                String toUser = cursor_temp.getString(nameColIndex);
                int accountBalance = Integer.parseInt(cursor_temp.getString(accounbalaneIndex));

                dialogBox.setUserCurrentBalance(accountBalance);
                dialogBox.setUserAccountNumber(11111);
                dialogBox.setToUser(toUser);
                dialogBox.show(getSupportFragmentManager() ," Enter amount");

            }
        });

    }
    // displaying all users information  so that user can select whom he/she wants to  transfer money
    private void displayAllUserData()
    {
        Cursor cursor = new DatabaseHelper(this).readAllUsersData();
        int nameColumnIndex = cursor.getColumnIndex(DatabaseHelper.Col2);
        int accuntColumnIndex = cursor.getColumnIndex(DatabaseHelper.Col1);
        int incrementVariable = 0;
        int disableUser = SelectedUserDisable.getAccountNo();
        ///*****************************************
        while (cursor.moveToNext()){
            String userName = cursor.getString(nameColumnIndex);
            int accountNumber = cursor.getInt(accuntColumnIndex);


            Log.i("disable user " , "name is "+disableUser);
            ++incrementVariable;
            switch (incrementVariable){
                case 1:{
                    if(disableUser == accountNumber)
                    {
                        binding.user1btn.setEnabled(false);

                    }
                    binding.user1.setText(userName);
                    binding.user1AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 2:{
                    if(disableUser == accountNumber)
                    {
                        binding.user2btn.setEnabled(false);
                    }
                    binding.user2.setText(userName);
                    binding.user2AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 3:{
                    if(disableUser == accountNumber)
                    {
                        binding.user3btn.setEnabled(false);
                    }
                    binding.user3.setText(userName);

                    binding.user3AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 4:{
                    if(disableUser == accountNumber)
                    {
                        binding.user4btn.setEnabled(false);
                    }
                    binding.user4.setText(userName);
                    binding.user4AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 5:{
                    if(disableUser == accountNumber)
                    {
                        binding.user5btn.setEnabled(false);
                    }
                    binding.user5.setText(userName);
                    binding.user5AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 7:{
                    if(disableUser == accountNumber)
                    {
                        binding.user7btn.setEnabled(false);
                    }
                    binding.user7.setText(userName);
                    binding.user7AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 6:{
                    if(disableUser == accountNumber)
                    {
                        binding.user6btn.setEnabled(false);
                    }
                    binding.user6.setText(userName);
                    binding.user6AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 8:{
                    if(disableUser == accountNumber)
                    {
                        binding.user8btn.setEnabled(false);
                    }
                    binding.user8.setText(userName);
                    binding.user8AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                case 9:{
                    if(disableUser == accountNumber)
                    {
                        binding.user9btn.setEnabled(false);
                    }
                    binding.user9.setText(userName);
                    binding.user9AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
                default:
                {
                    if(disableUser == accountNumber)
                    {
                        binding.user10btn.setEnabled(false);
                    }
                    binding.user10.setText(userName);
                    binding.user10AccountNo.setText("Account no : "+accountNumber);
                    break;
                }
            }
        }

    }


}