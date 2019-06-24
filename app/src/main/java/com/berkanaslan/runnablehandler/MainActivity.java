package com.berkanaslan.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*Global variables*/
    TextView textView;
    Runnable runnable;
    Handler handler;
    int number;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        number = 0;
    }

    public void start(View view) {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                number++;
                textView.setText("Time: "+number);
                handler.postDelayed(runnable,1000);
            }
        };

        handler.post(runnable);
        button.setEnabled(false); //Start butonuna tıklanması engelendi.

    }

    public void stop(View view) {
        handler.removeCallbacks(runnable);
        button.setEnabled(true); //Start butonu freeze'den çıktı, aktif oldu.
        number = 0;
        textView.setText("Time: "+number);
    }


}
