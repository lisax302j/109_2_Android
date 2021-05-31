package com.example.a106332013_hw12b;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class NotificationJobService extends JobService {


        // Notification channel ID.
        private static final String PRIMARY_CHANNEL_ID =
                "primary_notification_channel";
        // Notification manager.
        NotificationManager mNotifyManager;


    /**
         * Called by the system once it determines it is time to run the job.
         *
         * @param jobParameters Contains the information about the job.
         * @return Boolean indicating whether or not the job was offloaded to a
         * separate thread.
         * In this case, it is false since the notification can be posted on
         * the main thread.
         */
        @Override
        public boolean onStartJob(JobParameters jobParameters) {

            //Create the notification channel
            createNotificationChannel();

            //Set up the notification content intent to launch the app when clicked
            PendingIntent contentPendingIntent = PendingIntent.getActivity
                    (this, 0, new Intent(this, MainActivity.class),
                            PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder
                    (this, PRIMARY_CHANNEL_ID)
                    .setContentTitle("Job Service")
                    .setContentText("Your Job ran to completion!")
                    .setContentIntent(contentPendingIntent)
                    .setSmallIcon(R.drawable.ic_baseline_flip_camera_android_24)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setAutoCancel(true);

            mNotifyManager.notify(0, builder.build());
            return false;
        }


//        public boolean jobFinished(JobParameters jobParameters){
//            return false;
//        }
        /**
         * Called by the system when the job is running but the conditions are no
         * longer met.
         * In this example it is never called since the job is not offloaded to a
         * different thread.
         *
         * @param jobParameters Contains the information about the job.
         * @return Boolean indicating whether the job needs rescheduling.
         */
        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }

        /**
         * Creates a Notification channel, for OREO and higher.
         */
        public void createNotificationChannel() {

            // Create a notification manager object.
            mNotifyManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // Notification channels are only available in OREO and higher.
            // So, add a check on SDK version.
            if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.O) {

                // Create the NotificationChannel with all the parameters.
                NotificationChannel notificationChannel = new NotificationChannel
                        (PRIMARY_CHANNEL_ID,
                                getString(R.string.job_service_notification),
                                NotificationManager.IMPORTANCE_HIGH);

                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.enableVibration(true);
                notificationChannel.setDescription
                        (getString(R.string.notification_channel_description));

                mNotifyManager.createNotificationChannel(notificationChannel);
            }
        }
    private static final String TAG = "AlarmActivity";
    AlarmManager alarmManager;

    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;

    private void deliverNotification(Context context) {
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_android_24)
                .setContentTitle("Performing Work")
                .setContentText("Downloading in progress")

                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults( NotificationCompat.DEFAULT_ALL);

        mNotificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}

class AlarmBroadcastReceiver  {
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;

    // Notification channel ID.
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";


    public void onReceive(Context context , Intent intent) {
        mNotificationManager = (NotificationManager)
                context.getSystemService ( Context.NOTIFICATION_SERVICE );
        deliverNotification ( context );
    }
    private void deliverNotification(Context context) {
        Intent contentIntent = new Intent(context, NotificationJobService.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_android_24)
                .setContentTitle("Performing Work")
                .setContentText("Downloading in progress")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults( NotificationCompat.DEFAULT_ALL);

        mNotificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}


