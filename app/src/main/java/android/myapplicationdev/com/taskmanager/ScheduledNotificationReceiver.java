package android.myapplicationdev.com.taskmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

public class ScheduledNotificationReceiver extends BroadcastReceiver {

    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is
        //receiving an Intent broadcast.


        Intent i = new Intent(context, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, reqCode,
                i, PendingIntent.FLAG_CANCEL_CURRENT);

        //retrieve string from SecondActivity.
        String name = intent.getStringExtra("name");
        String des = intent.getStringExtra("des");

        // build notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(name);
        builder.setContentText(des);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        // sound for notification
        Uri uri= RingtoneManager.getDefaultUri
                (RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

        // Heads-up Notification
        builder.setPriority(Notification.PRIORITY_HIGH);

        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(123, n);

    }
}
