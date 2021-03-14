package com.example.a106332013_hw32;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import java.util.Random;


public class MainActivity extends Activity {

    TextView t1;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent i = new Intent();
                i.setClass(MainActivity.this, MainActivity2.class);
                startActivity(i);


            }
        });
    }
}
//   setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main);
//        t1 = (TextView) findViewById(R.id.textView);
//    }
//
//    protected void random(View view) {
//        Random x = new Random();
//        a = x.nextInt(49);
//        t1.setText(String.valueOf(a));
//can't complete the move of random



