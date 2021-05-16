/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * The SimpleAsyncTask class extends AsyncTask to perform a very simple
 * background task -- in this case, it just sleeps for a random amount of time.
 */

public class SimpleAsyncTask extends AsyncTask<Void,Void, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private ProgressBar mProgressBar;
    private ProgressDialog mProgressDialog;
    private Context mContext;
    private boolean isProgressBar=true;

    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(Context context,TextView tv) {
        mContext=context;
        mTextView = new WeakReference<>(tv);
    }

    public  void setProgressBar(ProgressBar proBar){mProgressBar=proBar;}

    @Override
    protected void onPreExecute(){
        super.onPreExecute ();
        mProgressDialog=new ProgressDialog ( mContext );
        mProgressDialog.setTitle ( "Downloading" );
        mProgressDialog.setMessage ( "Please wait..." );

        mProgressDialog.setMax(10);
        mProgressDialog.setButton ( ProgressDialog.BUTTON_NEGATIVE,"Cancel",(View.OnClickListener)(dialog,which)→
        {
            dialog.cancel ( );
            cancel ( true );
        });
            if (!isProgressBar)
                mProgressDialog.show();
        }


    @Override
    protected String doInBackground(Void... voids) {

        try {
            for (int i = 1; i<=10;i++){
                Thread.sleep ( 1000 );
                Log.i ( "Thread" , "Execute" + i );
                publishProgress ( i,i*10);
            }
            return "Successful";
        } catch (InterruptedException e) {
            Log.i ( "Exception" , e.getMessage ( ) );
            return "Failure!";
        }
    }




    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */

    @Override
    protected void onProgressUpdate (Integer...values){
        super.onProgressUpdate (values);
        int myValue1 =values[0];
        int myValue2 =values[1];
        if (!isProgressBar)
            mProgressDialog.setProgress ( myValue1 );
        else {
            mProgressBar.setProgress ( myValue2 );
            mProgressBar.setProgress ( myValue2+10 );
        }
    }

//        // Generate a random number between 0 and 10.
//        Random r = new Random();
//        int n = r.nextInt(11);
//
//        // Make the task take long enough that we have
//        // time to rotate the phone while it is running.
//        int s = n * 200;
//
//        // Sleep for the random amount of time.
//        try {
//            Thread.sleep(s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Return a String result.
//        return "Awake at last after sleeping for " + s + " milliseconds!";
//    }

    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
//    protected void onPostExecute(String result) {
//        mTextView.get().setText(result);
    }

