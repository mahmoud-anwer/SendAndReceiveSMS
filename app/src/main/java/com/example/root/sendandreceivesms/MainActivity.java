package com.example.root.sendandreceivesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifyButton = (Button)findViewById(R.id.buttonNotifyMe);
    }

    public void notifyMe(View view) {
        NewMessageNotification notification = new NewMessageNotification();
        notification.notify(this, "test", 50);
    }
}
