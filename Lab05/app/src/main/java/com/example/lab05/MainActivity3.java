package com.example.lab05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    List<MyModel> myModelList;

    Button button;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button) findViewById(R.id.act);
        button.setOnClickListener(this);
        displayItems();
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        myModelList = new ArrayList<>();
        myModelList.add(new MyModel("Evan", 25));
        myModelList.add(new MyModel("QWE", 40));
        myModelList.add(new MyModel("ASD", 46));
        myModelList.add(new MyModel("ZXC", 80));
        myModelList.add(new MyModel("RTY", 16));
        myModelList.add(new MyModel("FGH", 43));
        myModelList.add(new MyModel("VBN", 35));
        myModelList.add(new MyModel("UIO", 31));
        myModelList.add(new MyModel("JKL", 28));
        customAdapter = new CustomAdapter(this, myModelList);
        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity3.this, MainActivity.class));
    }
}
