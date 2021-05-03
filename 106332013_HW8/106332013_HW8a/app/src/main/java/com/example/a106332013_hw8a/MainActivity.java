package com.example.a106332013_hw8a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView battery;
    int level=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery=findViewById(R.id.Battery);
    }

    public void add(View view){
        if (level<5)
            level++;
        battery.setImageLevel(level);
    }

    public void remove (View view){
        if (level>0)
        level--;
        battery.setImageLevel(level);
    }
}