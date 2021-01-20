package com.example.petshoponline.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshoponline.Cart;
import com.example.petshoponline.ProductDetails;
import com.example.petshoponline.R;
import com.example.petshoponline.model.CartModel;
import com.example.petshoponline.model.RecentlyViewed;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    Context context;
    List<CartModel> cartList;

    public CartAdapter(Context context, List<CartModel> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_view_items, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, final int position) {
        holder.namePrice.setText(cartList.get(position).getName() + "$" + cartList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductDetails.class);

                i.putExtra("name", cartList.get(position).getName());
                i.putExtra("price", cartList.get(position).getPrice());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartHolder extends RecyclerView.ViewHolder{

        TextView namePrice;
        ConstraintLayout bg;
        public CartHolder(@NonNull View itemView) {
            super(itemView);
            namePrice = itemView.findViewById(R.id.NamePrice);
            bg = itemView.findViewById(R.id.cartRecycler);

        }
    }
}

