package com.zzh.calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zzh.calendar.parameter.Parameter;

public class MainActivity extends AppCompatActivity {

    private SwitchBroadcastReceiver switchBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Parameter.BORADCAST_OPEN);
        intentFilter.addAction(Parameter.BORADCAST_CLOSE);
        switchBroadcastReceiver = new SwitchBroadcastReceiver();
        registerReceiver(switchBroadcastReceiver , intentFilter);
    }

    class SwitchBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null){
                switch (intent.getAction()){
                    case Parameter.BORADCAST_OPEN:
                        break;
                    case Parameter.BORADCAST_CLOSE:
                        break;
                    default:
                }

            }

        }
    }
}
