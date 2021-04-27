/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

/***
 * Main Activity for the Scorekeeper app, which keeps score for any game
 * involving two teams. The user can increment or decrement the score
 * for each team using Button views.
 */
public class MainActivity extends AppCompatActivity {

//    // Member variables for holding the score
//    private int mScore1;
//    private int mScore2;
//
//    // Member variables for the two score TextView elements
//    private TextView mScoreText1;
//    private TextView mScoreText2;
//
//    // Tags to be used as the keys in OnSavedInstanceState
//    static final String STATE_SCORE_1 = "Team 1 Score";
//    static final String STATE_SCORE_2 = "Team 2 Score";


    ImageView img;
    ImageButton btn_plus, btn_minus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        btn_plus = (ImageButton) findViewById ( R.id.btn_plus );
        btn_minus = (ImageButton) findViewById ( R.id.btn_minus );
        img = (ImageView) findViewById (R.id.img0);
    }

    int[] s = {
            R.drawable.bat01 ,
            R.drawable.bat02 ,
            R.drawable.bat03 ,
            R.drawable.bat04 ,
            R.drawable.bat05 ,
            R.drawable.bat06 ,
            R.drawable.bat07};


    int i = -1;

    public void btn_minus(View view) {
        i--;
        if (i < 0) {
            i = s.length - 1;
        }
        img.setImageResource ( s[i] );
    }
    public void btn_plus(View view){
        i++;
        if(i==s.length){i=0;}
        img.setImageResource(s[i]);
    }


    /**
     * Creates the night mode menu option.
     *
     * @param menu The menu in the action bar
     * @return True to display the menu, false to hide it
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    /**
     * Handles options menu item clicks.
     *
     * @param item The item that was pressed
     * @return returns true since the item click wa handled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    /**
     * Method that is called when the configuration changes,
     * used to preserve the state of the app.
     *
     * @param outState The bundle that will be passed in to the Activity when it is restored.
     */
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        // Save the scores.
//        outState.putInt(STATE_SCORE_1, mScore1);
//        outState.putInt(STATE_SCORE_2, mScore2);
//        super.onSaveInstanceState(outState);
//    }
}