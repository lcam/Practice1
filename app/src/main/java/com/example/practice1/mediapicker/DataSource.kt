package com.example.practice1.mediapicker

import com.example.practice1.R
import com.example.practice1.model.Track
import com.example.practice1.model.Video

class DataSource {
    companion object {

        private val INSTANCE = DataSource()

        private val VIDEOS = listOf(
                Video("Casey Neistat", R.drawable.casey),
                Video("Game of Thrones", R.drawable.got),
                Video("Space Travel", R.drawable.nasa),
                Video("Pulp Fiction", R.drawable.pulp)
        )

        private val TRACKS = listOf(
                Track("Scorpion", "Drake", R.drawable.drake_1),
                Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
                Track("Views", "Drake", R.drawable.drake_3),
                Track("More Life", "Drake", R.drawable.drake_4),
                Track("Scorpion", "Drake", R.drawable.drake_1),
                Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
                Track("Views", "Drake", R.drawable.drake_3),
                Track("More Life", "Drake", R.drawable.drake_4),
                Track("Scorpion", "Drake", R.drawable.drake_1),
                Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
                Track("Views", "Drake", R.drawable.drake_3),
                Track("More Life", "Drake", R.drawable.drake_4),
                Track("Scorpion", "Drake", R.drawable.drake_1),
                Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
                Track("Views", "Drake", R.drawable.drake_3),
                Track("More Life", "Drake", R.drawable.drake_4),
                Track("Scorpion", "Drake", R.drawable.drake_1),
                Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
                Track("Views", "Drake", R.drawable.drake_3),
                Track("More Life", "Drake", R.drawable.drake_4)
        )

        fun getInstance(): DataSource {
            return INSTANCE
        }
    }


    fun getVideos(): List<Video> {
        return VIDEOS
    }

    fun getTracks(): List<Track> {
        return TRACKS
    }
}