/*
* Copyright 2013 Evgeny Shishkin
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.devspark.robototextview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.devspark.robototextview.R;

/**
 * Implementation of a {@link TextView} with native support for all the Roboto fonts on all versions of Android.
 *
 * @author e.shishkin
 */
public class RobotoTextView extends TextView {

    /*
     * Permissible values ​​for the "typeface" attribute.
     */
    private final static int ROBOTO_THIN = 0;
    private final static int ROBOTO_THIN_ITALIC = 1;
    private final static int ROBOTO_LIGHT = 2;
    private final static int ROBOTO_LIGHT_ITALIC = 3;
    private final static int ROBOTO_REGULAR = 4;
    private final static int ROBOTO_ITALIC = 5;
    private final static int ROBOTO_MEDIUM = 6;
    private final static int ROBOTO_MEDIUM_ITALIC = 7;
    private final static int ROBOTO_BOLD = 8;
    private final static int ROBOTO_BOLD_ITALIC = 9;
    private final static int ROBOTO_BLACK = 10;
    private final static int ROBOTO_BLACK_ITALIC = 11;
    private final static int ROBOTO_CONDENSED = 12;
    private final static int ROBOTO_CONDENSED_ITALIC = 13;
    private final static int ROBOTO_CONDENSED_BOLD = 14;
    private final static int ROBOTO_CONDENSED_BOLD_ITALIC = 15;

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public RobotoTextView(Context context) {
        super(context);
    }

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p/>
     * <p/>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @see #RobotoTextView(Context, AttributeSet, int)
     */
    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    /**
     * Perform inflation from XML and apply a class-specific base style. This
     * constructor of View allows subclasses to use their own base style when
     * they are inflating.
     *
     * @param context  The Context the view is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param attrs    The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *                 will be applied (beyond what is included in the theme). This may
     *                 either be an attribute resource, whose value will be retrieved
     *                 from the current theme, or an explicit style resource.
     * @see #RobotoTextView(Context, AttributeSet)
     */
    public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);
    }

    /**
     * Parse the attributes.
     *
     * @param context The Context the view is running in, through which it can access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.RobotoTextView);

        int typeface = values.getInt(R.styleable.RobotoTextView_typeface, 0);
        values.recycle();

        Log.i("RobotoTextView", "typeface = " + typeface);

        switch (typeface) {
            case ROBOTO_THIN:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf"));
                break;
            case ROBOTO_THIN_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-ThinItalic.ttf"));
                break;
            case ROBOTO_LIGHT:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf"));
                break;
            case ROBOTO_LIGHT_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-LightItalic.ttf"));
                break;
            case ROBOTO_REGULAR:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf"));
                break;
            case ROBOTO_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Italic.ttf"));
                break;
            case ROBOTO_MEDIUM:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
                break;
            case ROBOTO_MEDIUM_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-MediumItalic.ttf"));
                break;
            case ROBOTO_BOLD:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf"));
                break;
            case ROBOTO_BOLD_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldItalic.ttf"));
                break;
            case ROBOTO_BLACK:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf"));
                break;
            case ROBOTO_BLACK_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BlackItalic.ttf"));
                break;
            case ROBOTO_CONDENSED:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Condensed.ttf"));
                break;
            case ROBOTO_CONDENSED_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-CondensedItalic.ttf"));
                break;
            case ROBOTO_CONDENSED_BOLD:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldCondensed.ttf"));
                break;
            case ROBOTO_CONDENSED_BOLD_ITALIC:
                setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldCondensedItalic.ttf"));
                break;
            default:
                throw new IllegalArgumentException("Unknown `typeface` attribute value " + typeface);
        }
    }

}
