package com.example.petshoponline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    Button buyButton;
    ImageView img, back;
    TextView proName, proPrice, proDesc;
    ImageView cartView;

    String name, price, desc;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.food_cat);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");

        buyButton = findViewById(R.id.buyButton);
        cartView = findViewById(R.id.cartId2);
        proName = findViewById(R.id.prodName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.prodImage);
        back = findViewById(R.id.back2);


        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);



        img.setImageResource(image);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        cartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, Cart.class);
                startActivity(i);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, Cart.class);
                i.putExtra("name", name);
                i.putExtra("price", price);
                i.putExtra("imageUrl", image);

                startActivity(i);
            }
        });

    }
}