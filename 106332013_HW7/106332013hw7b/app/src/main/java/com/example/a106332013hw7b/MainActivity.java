package com.example.a106332013hw7b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;

 String s1[],s2[];
 int images[]={R.drawable.c_plus_plus,R.drawable.c_sharp,R.drawable.java,
         R.drawable.javascript,R.drawable.kotlin,R.drawable.pytho,
         R.drawable.ruby,R.drawable.swift,R.drawable.typescript,R.drawable.visual_studio};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        this.recyclerView = findViewById(R.id.recyclerView);

        s1=getResources ().getStringArray ( R.array.programmiing_language );
        s2=getResources ().getStringArray ( R.array.description );

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(myAdapter);}
}