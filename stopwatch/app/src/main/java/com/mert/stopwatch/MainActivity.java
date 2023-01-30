package com.mert.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textViewMs;
    TextView textViewSec;
    TextView textViewMin;
    TextView textViewHour;
    TextView textViewDay;

    int ms;
    int sec;
    int min;
    int hour;
    int day;


    Runnable runnableMs;
    Runnable runnableSec;
    Runnable runnableMin;
    Runnable runnableHour;
    Runnable runnableDay;
    Handler handlerMs;
    Handler handlerMin;
    Handler handlerSec;
    Handler handlerHour;
    Handler handlerDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMs=findViewById(R.id.textView5);
        textViewSec=findViewById(R.id.textView4);
        textViewMin=findViewById(R.id.textView3);
        textViewHour=findViewById(R.id.textView2);
        textViewDay=findViewById(R.id.textView);

        button=findViewById(R.id.button);
        ms=0;
        sec=-1;
        min=-1;
        hour=0;
        day=-1;
    }
    public void start(View view){

        handlerMs=new Handler();
        runnableMs=new Runnable() {
            @Override
            public void run() {
                handlerMs.postDelayed(runnableMs,1);
                textViewMs.setText(""+ms);
                ms++;
                if(ms==100){
                    ms=0;
                }
                textViewMs.setText(""+ms);
            }
        };
        handlerMs.post(runnableMs);




        handlerSec=new Handler();
        runnableSec=new Runnable() {
            @Override
            public void run() {
                handlerSec.postDelayed(runnableSec,1000);
                textViewSec.setText(""+sec);
                sec++;
                if(sec==60){
                    sec=0;
                }
                textViewSec.setText(""+sec);
            }
        };
        handlerSec.post(runnableSec);




        handlerHour=new Handler();
        runnableHour=new Runnable() {
            @Override
            public void run() {
                handlerHour.postDelayed(runnableHour,3600000);
                textViewHour.setText(""+hour);
                hour++;


                if(hour==24){
                    hour=0;
                }
                textViewMin.setText(""+hour);
            }
        };
        handlerHour.post(runnableHour);








        button.setEnabled(false);
        handlerMin=new Handler();
        runnableMin=new Runnable() {
            @Override
            public void run() {
                handlerMin.postDelayed(runnableMin,60000);
                textViewMin.setText(""+min);
                min++;
                if(min==60){
                    min=0;
                }
                textViewMin.setText(""+min);
            }
        };
        handlerMin.post(runnableMin);

        handlerDay=new Handler();
        runnableDay=new Runnable() {
            @Override
            public void run() {
                handlerDay.postDelayed(runnableDay,86400000);
                textViewDay.setText(""+day);
                day++;
                textViewDay.setText(""+day);
            }
        };
        handlerDay.post(runnableDay);

    }

    public void reset(View view){

        button.setEnabled(true);
        handlerMs.removeCallbacks(runnableMs);
        handlerSec.removeCallbacks(runnableSec);
        handlerMin.removeCallbacks(runnableMin);
        handlerHour.removeCallbacks(runnableHour);
        handlerDay.removeCallbacks(runnableDay);

        ms=0;
        sec=-1;
        min=-1;
        hour=0;
        day=-1;
        textViewMs.setText(""+ms);
        textViewSec.setText(""+sec);
        textViewMin.setText(""+min);
        textViewHour.setText(""+hour);
        textViewDay.setText(""+day);



    }
}