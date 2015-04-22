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

package com.devspark.robototextview.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.devspark.robototextview.util.RobotoTextViewUtils;

/**
 * Implementation of a {@link AutoCompleteTextView} with native support for all the Roboto fonts.
 *
 * @author Evgeny Shishkin
 */
public class RobotoAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /**
     * Simple constructor to use when creating a widget from code.
     *
     * @param context The Context the widget is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public RobotoAutoCompleteTextView(Context context) {
        this(context, null);
    }

    /**
     * Constructor that is called when inflating a widget from XML. This is called
     * when a widget is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p>
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the widget is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the widget.
     * @see #RobotoAutoCompleteTextView(Context, android.util.AttributeSet, int)
     */
    public RobotoAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            RobotoTextViewUtils.initTypeface(this, context, attrs);
        }
    }

    /**
     * Perform inflation from XML and apply a class-specific base style. This
     * constructor of View allows subclasses to use their own base style when
     * they are inflating.
     *
     * @param context  The Context the widget is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param attrs    The attributes of the XML tag that is inflating the widget.
     * @param defStyle The default style to apply to this widget. If 0, no style
     *                 will be applied (beyond what is included in the theme). This may
     *                 either be an attribute resource, whose value will be retrieved
     *                 from the current theme, or an explicit style resource.
     * @see #RobotoAutoCompleteTextView(Context, AttributeSet)
     */
    public RobotoAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            RobotoTextViewUtils.initTypeface(this, context, attrs);
        }
    }

}
