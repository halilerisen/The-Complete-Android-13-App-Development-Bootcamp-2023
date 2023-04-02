package com.example.ajchallengebucketlist;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Bucket[] placesList = {
                new Bucket("Aurora Lights", "The northern lights, or the aurora borealis, are beautiful dancing waves of light that have captivated people for millennia. But for all its beauty, this spectacular light show is a rather violent event. ", R.drawable.aurora_lights, 3.5f),
                new Bucket("Australia", "Australia, officially the Commonwealth of Australia, is a sovereign country comprising the mainland of the Australian continent, the island of Tasmania, and numerous smaller islands. With an area of 7,617,930 square kilometres, Australia is the largest country by area in Oceania and the world's sixth-largest country.", R.drawable.australia, 3.9f),
                new Bucket("Canada", "Canada is a country in North America. Its ten provinces and three territories extend from the Atlantic Ocean to the Pacific Ocean and northward into the Arctic Ocean, covering over 9.98 million square kilometres, making it the world's second-largest country by total area", R.drawable.canada, 2.5f),
                new Bucket("Cappadocia", "Cappadocia, a semi-arid region in central Turkey, is known for its distinctive “fairy chimneys,” tall, cone-shaped rock formations clustered in Monks Valley, Göreme and elsewhere. Other notables sites include Bronze Age homes carved into valley walls by troglodytes (cave dwellers) and later used as refuges by early Christians. The 100m-deep Ihlara Canyon houses numerous rock-face churches", R.drawable.cappadocia, 3.5f),
                new Bucket("Maldives", "Maldives, officially the Republic of Maldives, is an archipelagic state located in Southern Asia, situated in the Indian Ocean. It lies southwest of Sri Lanka and India, about 750 kilometres from the Asian continent's mainland.", R.drawable.maldives, 4.5f),
                new Bucket("Miami", "Miami, officially the City of Miami, is a major city and coastal metropolis located in Miami-Dade County in southeastern Florida.", R.drawable.miami, 3.5f),
                new Bucket("New Zeland", "New Zealand is an island country in the southwestern Pacific Ocean. It consists of two main landmasses—the North Island and the South Island —and over 700 smaller islands. It is the sixth-largest island country by area, covering 268,021 square kilometres.", R.drawable.new_zeland, 3.5f),
                new Bucket("Pyramids", "The Egyptian pyramids are ancient masonry structures located in Egypt. Sources cite at least 118 identified \"Egyptian\" pyramids. Approximately 80 pyramids were built within the Kingdom of Kush, now located in the modern country of Sudan", R.drawable.pyramids, 3.5f),
                new Bucket("Rome", "Rome is the capital city of Italy. It is also the capital of the Lazio region, the centre of the Metropolitan City of Rome, and a special comune named Comune di Roma Capitale.", R.drawable.rome, 3.5f),
                new Bucket("Russia", "No WAR", R.drawable.russia, 1.0f),
        };
        RecyclerView recyclerView = findViewById(R.id.recycler_view_places);

        BucketAdapter bucketAdapter = new BucketAdapter(placesList);

        recyclerView.setAdapter(bucketAdapter);

    }
}
