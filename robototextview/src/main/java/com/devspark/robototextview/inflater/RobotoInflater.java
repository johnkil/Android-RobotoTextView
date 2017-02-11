package com.devspark.robototextview.inflater;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.devspark.robototextview.util.RobotoTypefaceUtils;

public class RobotoInflater implements LayoutInflaterFactory {
    private AppCompatDelegate mAppCompatDelegate;

    private RobotoInflater(AppCompatDelegate delegate) {
        mAppCompatDelegate = delegate;
    }

    public static void attach(Activity activity) {
        if (activity instanceof AppCompatActivity) {
            LayoutInflaterCompat.setFactory(activity.getLayoutInflater(),
                    new RobotoInflater(((AppCompatActivity) activity).getDelegate()));
        } else {
            final Window window = activity.getWindow();
            final Window.Callback callback = window.getCallback();
            LayoutInflaterCompat.setFactory(activity.getLayoutInflater(),
                    new RobotoInflater(AppCompatDelegate.create(activity, StubAppCompatCallback.INSTANCE)));
            window.setCallback(callback);
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = mAppCompatDelegate.createView(parent, name, context, attrs);
        if (view instanceof TextView) {
            RobotoTypefaceUtils.initView((TextView) view, context, attrs);
        }
        return view;
    }

    private static class StubAppCompatCallback implements AppCompatCallback {
        static final StubAppCompatCallback INSTANCE = new StubAppCompatCallback();

        private StubAppCompatCallback() {
        }

        @Override
        public void onSupportActionModeStarted(ActionMode mode) {

        }

        @Override
        public void onSupportActionModeFinished(ActionMode mode) {

        }

        @Nullable
        @Override
        public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
            return null;
        }
    }
}
