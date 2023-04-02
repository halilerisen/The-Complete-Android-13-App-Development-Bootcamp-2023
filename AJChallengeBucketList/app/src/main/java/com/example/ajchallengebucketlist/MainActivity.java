package com.example.ajchallengebucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView placesWantToGoCardView;
    CardView thinsToDoCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placesWantToGoCardView = findViewById(R.id.card_view_places_want_to_go);
        thinsToDoCardView = findViewById(R.id.card_view_things_to_do);

        placesWantToGoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent placesIntent = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(placesIntent);
            }
        });

        thinsToDoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thingsIntent = new Intent(MainActivity.this, ThingsActivity.class);
                startActivity(thingsIntent);
            }
        });
    }
}