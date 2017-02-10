package com.devspark.robototextview.inflater;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

import com.devspark.robototextview.widget.RobotoAutoCompleteTextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.devspark.robototextview.widget.RobotoCheckBox;
import com.devspark.robototextview.widget.RobotoCheckedTextView;
import com.devspark.robototextview.widget.RobotoChronometer;
import com.devspark.robototextview.widget.RobotoDigitalClock;
import com.devspark.robototextview.widget.RobotoEditText;
import com.devspark.robototextview.widget.RobotoMultiAutoCompleteTextView;
import com.devspark.robototextview.widget.RobotoRadioButton;
import com.devspark.robototextview.widget.RobotoSwitch;
import com.devspark.robototextview.widget.RobotoTextClock;
import com.devspark.robototextview.widget.RobotoTextView;
import com.devspark.robototextview.widget.RobotoToggleButton;

public class RobotoInflater implements LayoutInflaterFactory {
    private static final String TAG_TEXT_VIEW = "TextView";

    private static final String TAG_BUTTON = "Button";

    private static final String TAG_EDIT_TEXT = "EditText";

    private static final String TAG_CHECK_KBOX = "CheckBox";

    private static final String TAG_RADIO_BUTTON = "RadioButton";

    private static final String TAG_CHECKED_TEXT_VIEW = "CheckedTextView";

    private static final String TAG_AUTO_COMPLETE_TEXT_VIEW = "AutoCompleteTextView";

    private static final String TAG_MULTI_AUTO_COMPLETETEXT_VIEW = "MultiAutoCompleteTextView";

    private static final String TAG_CHRONOMETER = "Chronometer";

    private static final String TAG_ROBOTO_DIGITAL_CLOCK = "RobotoDigitalClock";

    private static final String TAG_SWITCH = "Switch";

    private static final String TAG_TEXT_CLOCK = "TextClock";

    private static final String TAG_TOGGLE_BUTTON = "ToggleButton";

    private AppCompatDelegate mAppCompatDelegate;

    private RobotoInflater(AppCompatDelegate delegate) {
        mAppCompatDelegate = delegate;
    }

    public static void attach(AppCompatActivity activity) {
        LayoutInflaterCompat.setFactory(activity.getLayoutInflater(), new RobotoInflater(activity.getDelegate()));
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = null;
        Context originalContext = context;
        if (parent != null) {
            context = parent.getContext();
        }

        switch (name) {
            case TAG_TEXT_VIEW:
                view = new RobotoTextView(context, attrs);
                break;
            case TAG_BUTTON:
                view = new RobotoButton(context, attrs);
                break;
            case TAG_EDIT_TEXT:
                view = new RobotoEditText(context, attrs);
                break;
            case TAG_CHECK_KBOX:
                view = new RobotoCheckBox(context, attrs);
                break;
            case TAG_RADIO_BUTTON:
                view = new RobotoRadioButton(context, attrs);
                break;
            case TAG_CHECKED_TEXT_VIEW:
                view = new RobotoCheckedTextView(context, attrs);
                break;
            case TAG_AUTO_COMPLETE_TEXT_VIEW:
                view = new RobotoAutoCompleteTextView(context, attrs);
                break;
            case TAG_MULTI_AUTO_COMPLETETEXT_VIEW:
                view = new RobotoMultiAutoCompleteTextView(context, attrs);
                break;
            case TAG_CHRONOMETER:
                view = new RobotoChronometer(context, attrs);
                break;
            case TAG_ROBOTO_DIGITAL_CLOCK:
                view = new RobotoDigitalClock(context, attrs);
                break;
            case TAG_SWITCH:
                view = new RobotoSwitch(context, attrs);
                break;
            case TAG_TEXT_CLOCK:
                view = new RobotoTextClock(context, attrs);
                break;
            case TAG_TOGGLE_BUTTON:
                view = new RobotoToggleButton(context, attrs);
                break;
        }


        if (view == null) {
            view = mAppCompatDelegate.createView(parent, name, originalContext, attrs);
        }
        return view;
    }
}
