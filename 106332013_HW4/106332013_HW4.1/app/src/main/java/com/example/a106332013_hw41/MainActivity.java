package com.example.a106332013_hw41;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStructure;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private static final String LOG_TAG =MainActivity.class.getSimpleName () ;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        View mReplyHeadTextView = null;
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
        }

        Boolean savedInstanceState = null;
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mShowCount = (TextView) findViewById ( R.id.show_count );
        // Log the start of the onCreate() method.

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        View mMessageEditText = findViewById ( R.id.editText_main );


        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                View mReplyHeadTextView = null;
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                ViewStructure mReplyTextView;
            }
        }
    }


    public void countUp ( View view){
            mCount++;
            if (mShowCount != null)
                mShowCount.setText ( Integer.toString ( mCount ) );
        }
    }


