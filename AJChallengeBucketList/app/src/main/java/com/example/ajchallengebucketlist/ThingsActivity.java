package com.example.ajchallengebucketlist;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things);

        Bucket[] thingsToDoList = {
                new Bucket("JAVA", "Learn Android Java", R.drawable.java, 4.0f),
                new Bucket("KOTLIN", "Learn Android Kotlin", R.drawable.kotlin, 5.0f),
                new Bucket("SWIFT", "Learn Swift IOS", R.drawable.swift, 5.0f),
                new Bucket("English", "Improve English", R.drawable.english, 4.0f),

        };
        RecyclerView recyclerView = findViewById(R.id.recycler_view_things_to_do);

        BucketAdapter bucketAdapter = new BucketAdapter(thingsToDoList);

        recyclerView.setAdapter(bucketAdapter);

    }
}
