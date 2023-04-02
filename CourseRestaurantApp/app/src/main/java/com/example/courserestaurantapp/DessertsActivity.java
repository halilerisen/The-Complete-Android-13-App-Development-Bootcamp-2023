package com.example.courserestaurantapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DessertsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        ListView dessertsListView = findViewById(R.id.list_view_desserts);

        Dish[] dessertsList = {
                new Dish("Dessert1", "Description1", 15),
                new Dish("Dessert2", "Description2", 25)
        };

        ArrayAdapter<Dish> dessertsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dessertsList);
        dessertsListView.setAdapter(dessertsArrayAdapter);
    }
}
