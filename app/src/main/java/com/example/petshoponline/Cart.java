package com.example.petshoponline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshoponline.adapter.CartAdapter;
import com.example.petshoponline.model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    RecyclerView cartRecyclerView;

    CartAdapter cartAdapter;
    List<CartModel> cartModels;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartRecyclerView = findViewById(R.id.cartsRecycler);

        back = findViewById(R.id.back4);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Cart.this, MainActivity.class);
                startActivity(i);
            }
        });
        Intent intent = getIntent();
        CartModel cartItem = new CartModel(intent.getStringExtra("name"),intent.getStringExtra("price"));
        cartModels = new ArrayList<>();
        cartModels.add(cartItem);


        setDiscountedRecycler(cartModels);


    }
    private void setDiscountedRecycler(List<CartModel> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(this,dataList);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}