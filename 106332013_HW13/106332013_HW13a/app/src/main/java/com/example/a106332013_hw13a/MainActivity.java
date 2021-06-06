package com.example.a106332013_hw13a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    // Member variables for holding the score
    private int mScore1;
    private int mScore2;

    // Member variables for the two score TextView elements
    private TextView mScoreText1;
    private TextView mScoreText2;

    // Tags to be used as the keys in OnSavedInstanceState
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    //重製按鈕、存檔按鈕跟存檔開關
    private Button reset;
    private Button save;
    private Switch switch1;

    //設置shared preferences
    public static final String SHARED_PREFS="sharedPrefs";
    //儲存數字
    public static final String  MScoreText1="mScoreText1";
    public static final String  MScoreText2="mScoreText2";
    public static final String  SWITCH="switch1";

    private String text1,text2;
    private boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the TextViews by ID
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        reset=findViewById ( R.id.reset_button );
        save=findViewById ( R.id.save_button );
        switch1=findViewById ( R.id.save_switch );



    reset.setOnClickListener ( new View.OnClickListener ( ) {
        @Override
        public void onClick(View v) {
            mScore1=0;
            mScoreText1.setText (String.valueOf(mScore1) );
            mScore2=0;
            mScoreText2.setText (String.valueOf(mScore2) );
        }
    } );


    save.setOnClickListener ( new View.OnClickListener ( ) {
        @Override
        public void onClick(View v) {
            saveData();
        }
    } );

    loadData ();
    updateViews ();

        // Restores the scores if there is savedInstanceState.
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));


        }
    }

    public  void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString(MScoreText1,mScoreText1.getText ().toString ());
        editor.putString(MScoreText2,mScoreText2.getText ().toString ());
        editor.putBoolean ( SWITCH,switch1.isChecked () );

        editor.apply ();

        Toast.makeText (this,"Data saved",Toast.LENGTH_SHORT ).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
        text1=sharedPreferences.getString ( MScoreText1,"" );
        text2=sharedPreferences.getString ( MScoreText2,"" );
        switchOnOff=sharedPreferences.getBoolean (SWITCH, false );
    }

    public void updateViews(){
        mScoreText1.setText(text1);
        mScoreText2.setText(text2);
        switch1.setChecked ( switchOnOff );
    }
    /**
     * Handles the onClick of both the decrement buttons.
     *
     * @param view The button view that was clicked
     */
    public void decreaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            // If it was on Team 1:
            case R.id.decreaseTeam1:
                // Decrement the score and update the TextView.
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            // If it was Team 2:
            case R.id.decreaseTeam2:
                // Decrement the score and update the TextView.
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    /**
     * Handles the onClick of both the increment buttons.
     *
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            // If it was on Team 1:
            case R.id.increaseTeam1:
                // Increment the score and update the TextView.
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            // If it was Team 2:
            case R.id.increaseTeam2:
                // Increment the score and update the TextView.
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }


}