package com.devspark.robototextview.style;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;
import android.util.SparseIntArray;

import com.devspark.robototextview.util.RobotoTextViewUtils;
import com.devspark.robototextview.util.RobotoTypefaceManager;

/**
 * @author Rovkin Max
 */
public class RobotoTextAppearanceSpan extends MetricAffectingSpan {
    private final int[] textAttr = new int[]{android.R.attr.textSize, android.R.attr.textColor, android.R.attr.textColorLink};
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
        ColorStateList textColor;
        final SparseIntArray indexArray = getIndexesArray();

        mTypeface = initRoboto(context, appearance);
        TypedArray a = context.obtainStyledAttributes(appearance, textAttr);

        textColor = a.getColorStateList(indexArray.get(android.R.attr.textColor));
        mTextColorLink = a.getColorStateList(indexArray.get(android.R.attr.textColorLink));
        mTextSize = a.getDimensionPixelSize(indexArray.get(android.R.attr.textSize), -1);

        a.recycle();

        if (colorList >= 0) {
            int themeID = getThemeResId(context);
            if (themeID >= 0) {
                a = context.obtainStyledAttributes(themeID, textAttr);
                textColor = a.getColorStateList(colorList);
                a.recycle();
            }
        }
        mTextColor = textColor;
    }

    private int getThemeResId(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_META_DATA);
            return packageInfo.applicationInfo.theme;
        } catch (Exception e) {
            Log.d(getClass().getSimpleName(), e.getMessage(), e);
        }
        return -1;
    }

    @NonNull
    private SparseIntArray getIndexesArray() {
        final SparseIntArray intArray = new SparseIntArray();
        for (int i = 0; i < textAttr.length; i++) {
            intArray.put(textAttr[i], i);
        }
        return intArray;
    }

    private Typeface initRoboto(Context context, int appearance) {
        Typeface typeface;
        final TypedArray roboto = context.obtainStyledAttributes(appearance, com.devspark.robototextview.R.styleable.RobotoTextView);
        if (roboto.hasValue(com.devspark.robototextview.R.styleable.RobotoTextView_typeface)) {
            int typefaceValue = roboto.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_typeface, RobotoTypefaceManager.Typeface.ROBOTO_REGULAR);
            typeface = RobotoTypefaceManager.obtainTypeface(context, typefaceValue);
        } else {
            int fontFamily = roboto.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_fontFamily, RobotoTypefaceManager.FontFamily.ROBOTO);
            int textWeight = roboto.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_textWeight, RobotoTypefaceManager.TextWeight.NORMAL);
            int textStyle = roboto.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_textStyle, RobotoTypefaceManager.TextStyle.NORMAL);

            typeface = RobotoTypefaceManager.obtainTypeface(context, fontFamily, textWeight, textStyle);
        }
        roboto.recycle();
        return typeface;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        updateMeasureState(ds);

        if (mTextColor != null) {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        }

        if (mTextColorLink != null) {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        }
    }

    @Override
    public void updateMeasureState(TextPaint ds) {
        RobotoTextViewUtils.setTypeface(ds, mTypeface);
        if (mTextSize > 0) {
            ds.setTextSize(mTextSize);
        }
    }
}


