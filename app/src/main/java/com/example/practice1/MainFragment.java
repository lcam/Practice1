package com.example.practice1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.mediapicker.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    TrackAdapter trackAdapter;
    MyAdapter myAdapter;
    DataSource dataSource = new DataSource();

    List<String> ids = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> mobile1s = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        parseJSON();

        recyclerView = view.findViewById(R.id.recycler_view2);
        initRecyclerView();
    }

    private void initRecyclerView(){
        trackAdapter = new TrackAdapter();
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setAdapter(trackAdapter);
        //trackAdapter.setTracks(dataSource.getTracks());
        recyclerView.setAdapter(myAdapter);
        myAdapter.setUsers(ids, names, mobile1s);
    }

    private void parseJSON() {
        try {
            JSONArray inputarray = new JSONArray(loadJSONFromAsset());
            JSONObject obj = inputarray.getJSONObject(0);

            //JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("users");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("id"));
                ids.add(jo_inside.getString("id"));
                names.add(jo_inside.getString("name"));
                emails.add(jo_inside.getString("email"));

                JSONObject contact = jo_inside.getJSONObject("contact");
                mobile1s.add(contact.getString("mobile1"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJSON2() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("users");
            ArrayList<HashMap<String, String>> formList = new ArrayList<>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("id"));
                String id_value = jo_inside.getString("id");
                String name_value = jo_inside.getString("name");
                String email_value = jo_inside.getString("email");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<>();
                m_li.put("id", id_value);
                m_li.put("name", name_value);
                m_li.put("email", email_value);

                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("inputdata.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
