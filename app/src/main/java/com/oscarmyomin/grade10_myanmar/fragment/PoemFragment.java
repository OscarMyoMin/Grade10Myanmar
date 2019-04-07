package com.oscarmyomin.grade10_myanmar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oscarmyomin.grade10_myanmar.R;
import com.oscarmyomin.grade10_myanmar.adapter.PoemAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PoemFragment extends Fragment {

    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> content = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    PoemAdapter adapter;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.recyclerview, container, false);

        recyclerView = myView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        fetchData();

        adapter = new PoemAdapter(context, title, content);
        recyclerView.setAdapter(adapter);

        return myView;
    }

    private void fetchData(){
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray("data");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject jsonObject = userArray.getJSONObject(i);
                title.add(jsonObject.getString("title"));
                content.add(jsonObject.getString("content"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("poem.json");
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
