package com.example.homework4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework4.databinding.ActivityGameBinding;

public class GameActivity extends AppCompatActivity {
    ActivityGameBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initSetImg();
    }

    private void initSetImg() {
        String animeName = getIntent().getStringExtra("name");
        binding.NameAnime.setText(animeName);
    }
}