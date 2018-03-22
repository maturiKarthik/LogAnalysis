package com.example.iosdev.loganalysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startLog;
    Button stopLog;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startLog = (Button)findViewById(R.id.startLog);
        stopLog = (Button)findViewById(R.id.stopLog);

        // Starting a Service

        i = new Intent(getApplicationContext(),ServiceLog.class);



        startLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(i);
                Log.d("Test","StartService");
            }
        });

        stopLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(i);
                Log.d("Test","StopService");
            }
        });




    }



}
