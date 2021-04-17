package com.example.a106332013_hw61;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {
    CheckBox chk1,chk2,chk3,chk4,chk5;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        chk1=(CheckBox)findViewById (R.id.checkBox);
        chk2=(CheckBox)findViewById (R.id.checkBox3);
        chk3=(CheckBox)findViewById (R.id.checkBox4);
        chk4=(CheckBox)findViewById (R.id.checkBox5);
        chk5=(CheckBox)findViewById (R.id.checkBox6);
        btn1=(Button)findViewById (R.id.button);

        btn1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View view) {

            StringBuilder result=new StringBuilder();
            result.append("Toppings:");

            if(chk1.isChecked()){
                result.append(" Chocolate syrup");
            }
            if(chk2.isChecked()){
                result.append(" Sprinkles");

            }
            if(chk3.isChecked()){
                result.append(" Crushed nuts");

            }
            if(chk4.isChecked()){
                result.append(" Cherries");

            }
            if(chk5.isChecked()){
                result.append(" Orio cookie crumbles");

            }

            makeText(getApplicationContext(), result.toString(), LENGTH_LONG).show();
        }

    });
}}

