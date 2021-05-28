package com.example.practice1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.model.Track;

public class TrackViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    ImageView imageView;

    public TrackViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.track_text);
        imageView = itemView.findViewById(R.id.artist_image);
    }

    public void bind(Track track){
        String musicText = String.format("%s - %s", track.getArtist(), track.getTitle());
        textView.setText(musicText);
        imageView.setImageResource(track.getImageRes());
    }
}
