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

package com.example.a106332013_hw11a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.shape.OffsetEdgeTreatment;

/**
 * Broadcast Receiver implementation that delivers a custom Toast
 * message when it receives any of the registered broadcasts.
 */
public class CustomReceiver extends BroadcastReceiver {
TextView t1;

    // String constant that defines the custom broadcast Action.
//    private static final String ACTION_CUSTOM_BROADCAST =
//            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
/*
    Intent intent = new Intent("unique_name");
    //put whatever data you want to send, if any
    intent.putExtra("message", message);

    //send broadcast
    context.sendBroadcast(intent);
    */
    /**
     * This callback method gets called when the Broadcast Receiver receives a
     * broadcast that it is registered for.
     *
     * @param context The context in which broadcast receiver is running.
     * @param intent  The broadcast is delivered in the form of an intent which
     *                contains the broadcast action.
     */
    @Override
    public void onReceive(Context context , Intent intent) {
        String intentAction = intent.getAction ( );

        Bundle bundle = getResultExtras(false);
        String setSTRING= bundle.getString ( "t1");
        bundle.putString ( "t1*t1",setSTRING );
        setResultExtras ( bundle );
        t1.setText ( setSTRING );
        Toast.makeText(context, "Custom Broadcast Received Square of the Random"+setSTRING,
                Toast.LENGTH_LONG).show();


        if (intentAction != null) {
            String toastMessage = context.getString(R.string.unknown_action);

            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_connected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage =
                            context.getString(R.string.power_disconnected);
                    break;
//                case ACTION_CUSTOM_BROADCAST:
//                    toastMessage =
//                            context.getString(R.string.custom_broadcast_toast);
//                    break;
            }Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }
}




