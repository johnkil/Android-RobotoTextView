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
import android.util.AttributeSet;
import android.widget.DigitalClock;

import com.devspark.robototextview.util.RobotoTextViewUtils;

/**
 * Implementation of a {@link DigitalClock} with native support for all the Roboto fonts.
 *
 * @author Evgeny Shishkin
 */
public class RobotoDigitalClock extends DigitalClock {

    /**
     * Simple constructor to use when creating a widget from code.
     *
     * @param context The Context the widget is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public RobotoDigitalClock(Context context) {
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
     */
    public RobotoDigitalClock(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            RobotoTextViewUtils.initTypeface(this, context, attrs);
        }
    }

}
