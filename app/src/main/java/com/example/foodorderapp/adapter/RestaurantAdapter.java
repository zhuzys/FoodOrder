package com.example.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.example.foodorderapp.MainActivity;
import com.example.foodorderapp.R;
import com.example.foodorderapp.model.Restaurant;

import java.util.List;

import static androidx.appcompat.widget.AppCompatDrawableManager.get;

public class RestaurantAdapter  extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    private List<Restaurant> restaurantList;
    private ResListClickListener clickListener;

    public RestaurantAdapter(List<Restaurant> restaurantList, ResListClickListener clickListener) {
        this.restaurantList = restaurantList;
        this.clickListener = clickListener;
    }

    public void updateData(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.MyViewHolder holder, int position) {
        holder.resName.setText(restaurantList.get(position).getName());
        holder.resAddress.setText("Address: " +restaurantList.get(position).getAddress());
        holder.resHours.setText("Today's hours:"+restaurantList.get(position).getHours().getTodayHours());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(restaurantList.get(position));
            }
        });
        Glide.with(holder.thImage).load(restaurantList.get(position).getImage()).into(holder.thImage);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    static class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView resName;
        TextView resAddress, resHours;
        ImageView thImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resName = itemView.findViewById(R.id.restaurantName);
            resAddress = itemView.findViewById(R.id.restaurantAddress);
            resHours = itemView.findViewById(R.id.restaurantHours);
            thImage = itemView.findViewById(R.id.thumbImage);


        }


    }
    public interface  ResListClickListener {
        public void onItemClick(Restaurant restaurant);
    }
}
