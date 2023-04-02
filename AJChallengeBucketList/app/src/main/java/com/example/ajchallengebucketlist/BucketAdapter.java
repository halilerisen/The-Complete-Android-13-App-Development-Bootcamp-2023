package com.example.ajchallengebucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BucketAdapter extends RecyclerView.Adapter<BucketAdapter.BucketViewHolder> {
    Bucket[] bucketList;

    public BucketAdapter(Bucket[] bucketList) {
        this.bucketList = bucketList;
    }

    @NonNull
    @Override
    public BucketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bucket_item, parent, false);
        return new BucketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketViewHolder holder, int position) {
        holder.bind(bucketList[position]);
    }

    @Override
    public int getItemCount() {
        return bucketList.length;
    }

    static class BucketViewHolder extends RecyclerView.ViewHolder {
        TextView appTitle;
        TextView appDescription;
        ImageView appImage;
        RatingBar appRatingBar;

        public BucketViewHolder(@NonNull View itemView) {
            super(itemView);
            appTitle = itemView.findViewById(R.id.text_view_bucket_title);
            appDescription = itemView.findViewById(R.id.text_view_bucket_description);
            appImage = itemView.findViewById(R.id.image_view_bucket_image);
            appRatingBar= itemView.findViewById(R.id.rating_bar_bucket_rating);
        }

        public void bind(Bucket bucket) {
            appTitle.setText(bucket.title);
            appDescription.setText(bucket.description);
            appImage.setImageResource(bucket.image);
            appRatingBar.setRating(bucket.rating);

        }
    }
}
