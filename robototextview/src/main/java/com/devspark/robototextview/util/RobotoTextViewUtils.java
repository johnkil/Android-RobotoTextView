/*
 * Copyright 2014 Evgeny Shishkin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.devspark.robototextview.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.devspark.robototextview.R;

/**
 * @author Evgeny Shishkin
 */
public class RobotoTextViewUtils {

    private RobotoTextViewUtils() {
    }

    /**
     * Setup Roboto typeface.
     *
     * @param context The Context the widget is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the widget.
     */
    public static void initTypeface(TextView textView, Context context, AttributeSet attrs) {
        Typeface typeface;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RobotoTextView);

            if (a.hasValue(R.styleable.RobotoTextView_typeface)) {
                int typefaceValue = a.getInt(R.styleable.RobotoTextView_typeface, RobotoTypefaceManager.Typeface.ROBOTO_REGULAR);
                typeface = RobotoTypefaceManager.obtainTypeface(context, typefaceValue);
            } else {
                int fontFamily = a.getInt(R.styleable.RobotoTextView_fontFamily, RobotoTypefaceManager.FontFamily.ROBOTO);
                int textWeight = a.getInt(R.styleable.RobotoTextView_textWeight, RobotoTypefaceManager.TextWeight.NORMAL);
                int textStyle = a.getInt(R.styleable.RobotoTextView_textStyle, RobotoTypefaceManager.TextStyle.NORMAL);

                typeface = RobotoTypefaceManager.obtainTypeface(context, fontFamily, textWeight, textStyle);
            }

            a.recycle();
        } else {
            typeface = RobotoTypefaceManager.obtainTypeface(context, RobotoTypefaceManager.Typeface.ROBOTO_REGULAR);
        }

        //For making the font anti-aliased.
        textView.setPaintFlags(textView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        textView.setTypeface(typeface);
    }

}
