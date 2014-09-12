package com.devspark.robototextview.style;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import com.devspark.robototextview.util.RobotoTypefaceManager;

/**
 * Span for replacing typeface
 */
public class RobotoTypefaceSpan extends MetricAffectingSpan {

    /**
     * Created typefaces.
     */
    private final Typeface mTypeface;

    /**
     * Constructor to use with default typeface (regular).
     *
     * @param context The Context the span is using in, through which it can access the current theme, resources, etc.
     */
    public RobotoTypefaceSpan(Context context) {
        this(context, RobotoTypefaceManager.Typeface.ROBOTO_REGULAR);
    }

    /**
     * Constructor to use with Typeface Id.
     *
     * @param context    The Context the span is using in, through which it can access the current theme, resources, etc.
     * @param typefaceId Typeface Id ({@link com.devspark.robototextview.util.RobotoTypefaceManager.Typeface})
     */
    public RobotoTypefaceSpan(Context context, int typefaceId) {
        mTypeface = RobotoTypefaceManager.obtainTypeface(context, typefaceId);
    }

    /**
     * Constructor to use with set of parameters
     *
     * @param context    The Context the span is using in, through which it can access the current theme, resources, etc.
     * @param fontFamily The value of "fontFamily" attribute ({@link com.devspark.robototextview.util.RobotoTypefaceManager.FontFamily})
     * @param textWeight The value of "textWeight" attribute ({@link com.devspark.robototextview.util.RobotoTypefaceManager.TextWeight})
     * @param textStyle  The value of "textStyle" attribute ({@link com.devspark.robototextview.util.RobotoTypefaceManager.TextStyle})
     */
    public RobotoTypefaceSpan(Context context, int fontFamily, int textWeight, int textStyle) {
        mTypeface = RobotoTypefaceManager.obtainTypeface(context, fontFamily, textWeight, textStyle);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mTypeface);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mTypeface);
    }

    /**
     * Setting typeface to the TextPaint.
     *
     * @param paint    TextPain to modification.
     * @param typeface Created typefaces.
     */
    private static void apply(Paint paint, Typeface typeface) {
        paint.setTypeface(typeface);
    }
}