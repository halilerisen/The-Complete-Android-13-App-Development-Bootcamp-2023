package com.example.courseportfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_projects);


        Project[] projects = {
                new Project("Project1", "This is a description of project", R.drawable.getting_started),
                new Project("Project2", "This is a description of project", R.drawable.quote),
                new Project("Project3", "This is a description of project", R.drawable.calculator),
                new Project("Project4", "This is a description of project", R.drawable.tape),
                new Project("Project5", "This is a description of project", R.drawable.hungry_developer),
                new Project("Project5", "This is a description of project", R.drawable.hungry_developer),
                new Project("Project5", "This is a description of project", R.drawable.hungry_developer)
        };

      ProjectsAdapter projectsAdapter = new ProjectsAdapter(projects);

      recyclerView.setAdapter(projectsAdapter);

    }
}