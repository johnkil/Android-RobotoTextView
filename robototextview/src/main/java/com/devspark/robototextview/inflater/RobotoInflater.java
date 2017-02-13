package com.devspark.robototextview.inflater;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;

import com.devspark.robototextview.util.RobotoTypefaceUtils;

public class RobotoInflater implements LayoutInflaterFactory {
    private AppCompatDelegate mAppCompatDelegate;

    private RobotoCompatInflater mCompatInflater = new RobotoCompatInflater();

    private Window mWindow;

    private RobotoInflater(AppCompatDelegate delegate, Window window) {
        mAppCompatDelegate = delegate;
        mWindow = window;
    }

    public static void attach(Activity activity) {
        if (activity instanceof AppCompatActivity) {
            LayoutInflaterCompat.setFactory(activity.getLayoutInflater(),
                    new RobotoInflater(((AppCompatActivity) activity).getDelegate(), activity.getWindow()));
        } else {
            final Window window = activity.getWindow();
            final Window.Callback callback = window.getCallback();
            LayoutInflaterCompat.setFactory(activity.getLayoutInflater(),
                    new RobotoInflater(AppCompatDelegate.create(activity, StubAppCompatCallback.INSTANCE), window));
            window.setCallback(callback);
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = mAppCompatDelegate.createView(parent, name, context, attrs);
        if (view == null) {
            final boolean isPre21 = Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP;
            final boolean inheritContext = isPre21 && shouldInheritContext((ViewParent) parent);
            view = mCompatInflater.createView(parent, name, context, attrs, inheritContext, isPre21, VectorEnabledTintResources.shouldBeUsed());
        }

        if (view instanceof TextView) {
            RobotoTypefaceUtils.initView((TextView) view, context, attrs);
        }
        return view;
    }


    private boolean shouldInheritContext(ViewParent parent) {
        if (parent == null) {
            // The initial parent is null so just return false
            return false;
        }
        final View windowDecor = mWindow.getDecorView();
        while (true) {
            if (parent == null) {
                // Bingo. We've hit a view which has a null parent before being terminated from
                // the loop. This is (most probably) because it's the root view in an inflation
                // call, therefore we should inherit. This works as the inflated layout is only
                // added to the hierarchy at the end of the inflate() call.
                return true;
            } else if (parent == windowDecor || !(parent instanceof View)
                    || ViewCompat.isAttachedToWindow((View) parent)) {
                // We have either hit the window's decor view, a parent which isn't a View
                // (i.e. ViewRootImpl), or an attached view, so we know that the original parent
                // is currently added to the view hierarchy. This means that it has not be
                // inflated in the current inflate() call and we should not inherit the context.
                return false;
            }
            parent = parent.getParent();
        }
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
