package com.devspark.robototextview.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.devspark.robototextview.inflater.RobotoInflater;


public class InflaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        RobotoInflater.attach(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);
    }
}