package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodorderapp.adapter.MenuListAdapter;
import com.example.foodorderapp.model.Menu;

import com.example.foodorderapp.model.Restaurant;

import java.util.List;

public class RestaurantMenuActivity extends AppCompatActivity implements MenuListAdapter.MenuListClickListener {
    private List<Menu> menuList = null;
    private MenuListAdapter menuListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);

        Restaurant restaurant = getIntent().getParcelableExtra("Restaurant");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(restaurant.getName());
        actionBar.setSubtitle(restaurant.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(true);
        init();

         menuList = restaurant.getMenus();
         init();

        TextView btnCheckOut= findViewById(R.id.buttonCheckout);
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private  void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        menuListAdapter = new MenuListAdapter(menuList, this);
        recyclerView.setAdapter(menuListAdapter);

    }


    @Override
    public void onAddToCardClick(Menu menu) {

    }


    }


}