package com.example.petshoponline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.petshoponline.adapter.CategoryAdapter;
import com.example.petshoponline.adapter.DiscountedProductAdapter;
import com.example.petshoponline.adapter.RecentlyViewedAdapter;
import com.example.petshoponline.model.Category;
import com.example.petshoponline.model.DiscountedProducts;
import com.example.petshoponline.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;

   DiscountedProductAdapter discountedProductAdapter;
   List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categories;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory;
    ImageView cartView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        cartView = findViewById(R.id.cartId);


        recentlyViewedRecycler = findViewById(R.id.recently_item);


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        cartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Cart.class);
                startActivity(i);
            }
        });

        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.disscount_1));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.disscount_2));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.disscount_3));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.disscount_1));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.disscount_2));
        discountedProductsList.add(new DiscountedProducts(6, R.drawable.disscount_3));


        categories = new ArrayList<>();
        categories.add(new Category(1, R.drawable.dog));
        categories.add(new Category(1, R.drawable.fish));
        categories.add(new Category(1, R.drawable.rabbit));
        categories.add(new Category(1, R.drawable.reptile));

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Whiskas","Your cat will love it", "$ 20","2", "buc", R.drawable.food_cat,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Pedigree","Perfect for your dog", "$ 20","2", "buc", R.drawable.food_dog,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Mexican Spicy","More nutritive", "$ 15","2", "buc", R.drawable.food_parrot,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Nestor","Best price", "$ 40","30", "buc", R.drawable.food_rabbit,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Coller","For the beauty of your cat", "$ 10","30", "buc", R.drawable.collar_cat,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Toy","Exhaust your cat's energy", "$ 10","30", "buc", R.drawable.toy_cat,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Bed","The best place to sleep", "$ 10","30", "buc", R.drawable.bed_cat,R.drawable.food_cat));
        recentlyViewedList.add(new RecentlyViewed("Dust","With a nice smell", "$ 8","30", "buc", R.drawable.dust,R.drawable.food_cat));








        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categories);
        setRecentlyViwedRecycler(recentlyViewedList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,dataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }


    private void setRecentlyViwedRecycler(List<RecentlyViewed> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,dataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

}