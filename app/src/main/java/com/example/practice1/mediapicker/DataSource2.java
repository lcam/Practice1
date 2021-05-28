package com.example.practice1.mediapicker;

import com.example.practice1.R;
import com.example.practice1.model.Track;

import java.util.ArrayList;
import java.util.List;

public class DataSource2 {

    List<Track> tracks;

    public DataSource2() {
        tracks = new ArrayList<>();
        tracks.add(new Track("Scorpion", "Drake", R.drawable.drake_1));
        tracks.add(new Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2));
        tracks.add(new Track("Views", "Drake", R.drawable.drake_3));
    }

    public List<Track> getTracks(){
        return tracks;
    }
}
