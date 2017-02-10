package com.devspark.robototextview.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.devspark.robototextview.inflater.RobotoInflater;


public final class InflaterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        RobotoInflater.attach(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);
    }
}
