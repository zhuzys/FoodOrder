package com.example.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderapp.R;
import com.example.foodorderapp.model.Menu;
import com.example.foodorderapp.model.Restaurant;

import java.util.List;

public class MenuListAdapter extends  RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {
    private List<Menu> menuList;
    private MenuListClickListener clickListener;

    public MenuListAdapter(List<Menu> menuList, MenuListClickListener clickListener) {
        this.menuList = menuList;
        this.clickListener = clickListener;
    }

    public void updateData(List<Menu> menuList) {
        this.menuList = menuList;

    }

    public MenuListAdapter .MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_row, parent, false);
        return new MenuListAdapter .MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.menuName.setText(menuList.get(position).getName());
        holder.menuPrice.setText("Price: $" +menuList.get(position).getPrice());
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onAddToCardClick(menuList.get(position));

            }
        });
        Glide.with(holder.thImage)
                .load(menuList.get(position).getUrl()).into(holder.thImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onAddToCardClick(menuList.get(position));
            }
        });
        Glide.with(holder.thImage).load(menuList.get(position).getUrl()).into(holder.thImage);
    }




    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView menuName;
        TextView menuPrice, addToCartButton;
        ImageView thImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menuName = itemView.findViewById(R.id.menuName);
            menuPrice = itemView.findViewById(R.id.menuPrice);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            thImage = itemView.findViewById(R.id.thumbImage);
        }


    }
    public interface  MenuListClickListener {
        public void onAddToCardClick(Menu menu);
    }
}


