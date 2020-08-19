package com.example.smsscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;

public class BroadcastReceiverHelper extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        sendSMS(intent);
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();
    }
    private void sendSMS(Intent intent){
        Bundle bundle = intent.getExtras();
        SmsManager smsManager = SmsManager.getDefault();

        String message = bundle.getString("message");
        String phone_number = bundle.getString("phone_number");

        smsManager.sendTextMessage(phone_number, null, message, null, null);

    }
}
