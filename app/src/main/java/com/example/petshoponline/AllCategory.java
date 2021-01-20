package com.example.petshoponline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.petshoponline.adapter.AllCategoryAdapter;
import com.example.petshoponline.adapter.CategoryAdapter;
import com.example.petshoponline.model.AllCategoryModel;
import com.example.petshoponline.model.Category;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView allCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> categoryModelList;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecycler = findViewById(R.id.allCategory);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent( AllCategory.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });


        categoryModelList = new ArrayList<>();
        categoryModelList.add(new AllCategoryModel(1, R.drawable.rabbit));
        categoryModelList.add(new AllCategoryModel(1, R.drawable.dog));
        categoryModelList.add(new AllCategoryModel(1, R.drawable.fish));
        categoryModelList.add(new AllCategoryModel(1, R.drawable.parrot));
        categoryModelList.add(new AllCategoryModel(1, R.drawable.cat));
        categoryModelList.add(new AllCategoryModel(1, R.drawable.reptile));

        setAllCategoryRecycler(categoryModelList);
    }
    private void setAllCategoryRecycler(List<AllCategoryModel> dataList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this,dataList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }
}