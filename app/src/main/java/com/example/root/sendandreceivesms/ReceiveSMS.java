package com.example.root.sendandreceivesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by root on 9/15/17.
 */

public class ReceiveSMS extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";

        try{
        if (bundle != null) {
            Object[] smsContent = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[smsContent.length];
            for (int i = 0; i < msgs.length; i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    String format = bundle.getString("format");
                    msgs[i] = SmsMessage.createFromPdu((byte[]) smsContent[i], format);
                }
                str += msgs[i].getMessageBody();
                // create notification for received sms

            }
            //Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        }
        }catch (Exception ex){
            //Toast.makeText(this, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}