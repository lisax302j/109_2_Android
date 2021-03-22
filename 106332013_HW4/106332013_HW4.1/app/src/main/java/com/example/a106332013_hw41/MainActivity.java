package com.example.a106332013_hw41;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = ;
    private TextView txtShow;
    private Button btnDo;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        final int onCreate = Log.d (LOG_TAG, "onCreate");

        @Override
        public void onStart(){
            super.onStart();
            Log.d(LOG_TAG, "onStart");
        }
        
        txtShow = (TextView) findViewById(R.id.textView2);
        btnDo = (Button) findViewById(R.id.btnDo);

        btnDo.findViewById(R.id.btnDo);

        btnDo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count ++;
                txtShow.setText(String.valueOf(count));

        //btnDo.setOnClickListener(btnDotListener);
        //Button btnDo =(Button)findViewById(R.id.btnDo)
        //btnDo.setOnClickListener(btnDotListener());
        //Button OnClickListener btnCountListener = new Button.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {

        //    }

            //Button.OnClickListener getCount;
                    //getCount = new Button.OnClickListener(){

                @Override
                public void countup;
                ( ) {
                    countup ( );
                }

            @Override
                    public void countup(View v) {
                        count++;
                        if (txtShow != null)
                            txtShow.setText(Integer.toString(count));
                        //txtShow.setText(count);
                    }
                };
    }

    private OnClickListener btnDotListener() {
        return btnDotListener();
    }

    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),
                "onRestart", Toast.LENGTH_SHORT).show();
        }
};
