package com.news.project.basicbankingapp.userData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.news.project.basicbankingapp.R;
import com.news.project.basicbankingapp.databinding.ActivityTransactionDetailsBinding;

public class TransactionDetails extends AppCompatActivity {

    ActivityTransactionDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransactionDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}