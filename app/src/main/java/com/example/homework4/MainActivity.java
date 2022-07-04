package com.example.homework4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemNotesOnClikc{
    GameAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
    }
    private void initAdapter() {
        ArrayList<GameModel> list = new ArrayList<>();
        list.add(new GameModel("https://ae01.alicdn.com/kf/HTB1zo8dXLLsK1Rjy0Fbq6xSEXXah/Dean-Winchester-Supernatural-Poster-Fantasy-TV-Vintage-Retro-Decorative-DIY-Wall-Canvas-Stickers-Art-Home-Bar.jpg_Q90.jpg_.webp",
                "Dean", "Winchester", "Hunter"));
        list.add(new GameModel("https://upload.wikimedia.org/wikipedia/en/d/db/Daryl_Dixon_Norman_Reedus.png",
                "Daryl", "Dixon", "Archer"));
        list.add(new GameModel("https://www.peoples.ru/character/movie/darth_vader/darth_1.jpeg",
                "Darth", "Vader", "Antihero"));
        list.add(new GameModel("https://static.wikia.nocookie.net/marvel-cinematic/images/3/32/Steve_Rogers_2.jpg/revision/latest?cb=20131025030358",
                "Steve", "Rogers", "Captain America"));
        adapter = new GameAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void itemClick(String name) {
        Intent intent = new Intent(this, GameActivity.class);
        switch (name) {
            case "Dean":
                intent.putExtra("name", "SuperNateral");
                break;
            case "Daryl":
                intent.putExtra("name", "kino");
                break;
            case "Darth":
                intent.putExtra("name", "anime");
                break;
            case "Steve":
                intent.putExtra("name", "film");
                break;
        }
        startActivity(intent);
    }
}