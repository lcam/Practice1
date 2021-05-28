package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private TrackAdapter trackAdapter;
//    private DataSource dataSource = new DataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        recyclerView = findViewById(R.id.recycler_view);
//        initRecyclerView();
    }

//    private void initRecyclerView(){
//        trackAdapter = new TrackAdapter();
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
//        recyclerView.setAdapter(trackAdapter);
//        trackAdapter.setTracks(dataSource.getTracks());
//    }

}
