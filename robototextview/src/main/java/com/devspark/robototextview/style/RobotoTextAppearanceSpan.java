package com.devspark.robototextview.style;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;
import android.util.SparseIntArray;

import com.devspark.robototextview.R;
import com.devspark.robototextview.util.RobotoTypefaceManager;
import com.devspark.robototextview.util.RobotoTypefaceUtils;

/**
 * Sets the text color, size and typeface to match a TextAppearance resource.
 */
public class RobotoTextAppearanceSpan extends MetricAffectingSpan {
    private static final int[] TEXT_ATTRS = new int[]{
            android.R.attr.textSize, android.R.attr.textColor, android.R.attr.textColorLink};

    private final Typeface mTypeface;
    private final int mTextSize;
    private final ColorStateList mTextColor;
    private final ColorStateList mTextColorLink;

    /**
     * Uses the specified TextAppearance resource to determine the
     * text appearance.  The <code>appearance</code> should be, for example,
     * <code>android.R.style.TextAppearance_Small</code>.
     */
    public RobotoTextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
    }

    /**
     * Uses the specified TextAppearance resource to determine the
     * text appearance, and the specified text color resource
     * to determine the color.  The <code>appearance</code> should be,
     * for example, <code>android.R.style.TextAppearance_Small</code>,
     * and the <code>colorList</code> should be, for example,
     * <code>android.R.styleable.Theme_textColorPrimary</code>.
     */
    public RobotoTextAppearanceSpan(Context context, int appearance, int colorList) {
        TypedArray a = context.obtainStyledAttributes(appearance, R.styleable.RobotoTextView);
        mTypeface = RobotoTypefaceUtils.typefaceFromAttrs(context, a);
        a.recycle();

        ColorStateList textColor;

        a = context.obtainStyledAttributes(appearance, TEXT_ATTRS);
        SparseIntArray attrsIndexes = textAttrsIndexes();

        textColor = a.getColorStateList(attrsIndexes.get(android.R.attr.textColor));
        mTextColorLink = a.getColorStateList(attrsIndexes.get(android.R.attr.textColorLink));
        mTextSize = a.getDimensionPixelSize(attrsIndexes.get(android.R.attr.textSize), -1);

        a.recycle();

        if (colorList >= 0) {
            a = context.obtainStyledAttributes(themeResId(context), TEXT_ATTRS);
            textColor = a.getColorStateList(colorList);
            a.recycle();
        }

        mTextColor = textColor;
    }

    /**
     * Makes text be drawn with the specified typeface, size and colors.
     */
    public RobotoTextAppearanceSpan(Context context, int typefaceId, int size,
                                    ColorStateList color, ColorStateList linkColor) {
        mTypeface = RobotoTypefaceManager.obtainTypeface(context, typefaceId);
        mTextSize = size;
        mTextColor = color;
        mTextColorLink = linkColor;
    }

    private int themeResId(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_META_DATA);
            return packageInfo.applicationInfo.theme;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(getClass().getSimpleName(), e);
        }
        return -1;
    }

    private SparseIntArray textAttrsIndexes() {
        SparseIntArray indexes = new SparseIntArray(TEXT_ATTRS.length);
        for (int i = 0; i < TEXT_ATTRS.length; i++) {
            indexes.put(TEXT_ATTRS[i], i);
        }
        return indexes;
    }

    /**
     * Returns the typeface specified by this span.
     */
    @NonNull
    public Typeface getTypeface() {
        return mTypeface;
    }

    /**
     * Returns the text size specified by this span, or <code>-1</code>
     * if it does not specify one.
     */
    public int getTextSize() {
        return mTextSize;
    }

    /**
     * Returns the text color specified by this span, or <code>null</code>
     * if it does not specify one.
     */
    @Nullable
    public ColorStateList getTextColor() {
        return mTextColor;
    }

    /**
     * Returns the link color specified by this span, or <code>null</code>
     * if it does not specify one.
     */
    @Nullable
    public ColorStateList getLinkTextColor() {
        return mTextColorLink;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        updateMeasureState(tp);
        if (mTextColor != null) {
            tp.setColor(mTextColor.getColorForState(tp.drawableState, 0));
        }
        if (mTextColorLink != null) {
            tp.linkColor = mTextColorLink.getColorForState(tp.drawableState, 0);
        }
    }

    @Override
    public void updateMeasureState(TextPaint tp) {
        RobotoTypefaceUtils.setup(tp, mTypeface);
        if (mTextSize > 0) {
            tp.setTextSize(mTextSize);
        }
    }
}