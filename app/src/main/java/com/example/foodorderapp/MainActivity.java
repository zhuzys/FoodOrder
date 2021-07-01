package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodorderapp.adapter.RestaurantAdapter;
import com.example.foodorderapp.databinding.ActivityMainBinding;
import com.example.foodorderapp.model.Restaurant;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

public class MainActivity extends AppCompatActivity implements RestaurantAdapter.ResListClickListener {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Restaurant List");

        List<Restaurant> restaurantList = getRestaurantData();
        init(restaurantList);


    }

    private void init(List<Restaurant> restaurantList) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantList, this);
        binding.recyclerView.setAdapter(restaurantAdapter);

    }

    private List<Restaurant> getRestaurantData() {
        InputStream is = getResources().openRawResource(R.raw.restourent);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } catch (Exception e) {

        }
        String jsonStr = writer.toString();
        Gson gson = new Gson();
        Restaurant[] restaurants = gson.fromJson(jsonStr, Restaurant[].class);
        List<Restaurant> restList = Arrays.asList(restaurants);

        return restList;
    }

    @Override
    public void onItemClick(Restaurant restaurant) {
        Intent intent = new Intent(MainActivity.this, RestaurantMenuActivity.class);
        intent.putExtra("Restaurant", restaurant);
        startActivity(intent);

        }
    }