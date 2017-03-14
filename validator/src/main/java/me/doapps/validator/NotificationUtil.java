package me.doapps.validator;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

import com.example.win10.validator.R;

/**
 * Created by luis on 17/01/17.
 */
public class NotificationUtil {

    public static void simpleNotification(Context context, Class class_, NotificationManager mNotificationManager) {

        Intent resultIntent = new Intent(context, class_);

        // Creating a artifical activity stack for the notification activity
        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(((AppCompatActivity) context));
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(class_);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);

        // Pending intent to the notification manager
        PendingIntent resultPending = stackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Building the notification
        android.support.v4.app.NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                //.setSmallIcon(R.drawable.ic_notification) // notification icon
                .setContentTitle("I'm a simple notification") // main title of the notification
                .setContentText("Toca para más información") // notification text
                .setContentIntent(resultPending); // notification intent

        // mId allows you to update the notification later on.
        mNotificationManager.notify(10, mBuilder.build());
    }

}
