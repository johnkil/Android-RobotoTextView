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

package com.devspark.robototextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.TextView;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Utilities for working with roboto typefaces.
 *
 * @author Evgeny Shishkin
 */
public final class RobotoTypefaces {

    @Retention(SOURCE)
    @IntDef({
            TYPEFACE_ROBOTO_THIN,
            TYPEFACE_ROBOTO_THIN_ITALIC,
            TYPEFACE_ROBOTO_LIGHT,
            TYPEFACE_ROBOTO_LIGHT_ITALIC,
            TYPEFACE_ROBOTO_REGULAR,
            TYPEFACE_ROBOTO_ITALIC,
            TYPEFACE_ROBOTO_MEDIUM,
            TYPEFACE_ROBOTO_MEDIUM_ITALIC,
            TYPEFACE_ROBOTO_BOLD,
            TYPEFACE_ROBOTO_BOLD_ITALIC,
            TYPEFACE_ROBOTO_BLACK,
            TYPEFACE_ROBOTO_BLACK_ITALIC,
            TYPEFACE_ROBOTO_CONDENSED_LIGHT,
            TYPEFACE_ROBOTO_CONDENSED_LIGHT_ITALIC,
            TYPEFACE_ROBOTO_CONDENSED_REGULAR,
            TYPEFACE_ROBOTO_CONDENSED_ITALIC,
            TYPEFACE_ROBOTO_CONDENSED_BOLD,
            TYPEFACE_ROBOTO_CONDENSED_BOLD_ITALIC,
            TYPEFACE_ROBOTO_SLAB_THIN,
            TYPEFACE_ROBOTO_SLAB_LIGHT,
            TYPEFACE_ROBOTO_SLAB_REGULAR,
            TYPEFACE_ROBOTO_SLAB_BOLD,
            TYPEFACE_ROBOTO_MONO_THIN,
            TYPEFACE_ROBOTO_MONO_THIN_ITALIC,
            TYPEFACE_ROBOTO_MONO_LIGHT,
            TYPEFACE_ROBOTO_MONO_LIGHT_ITALIC,
            TYPEFACE_ROBOTO_MONO_REGULAR,
            TYPEFACE_ROBOTO_MONO_ITALIC,
            TYPEFACE_ROBOTO_MONO_MEDIUM,
            TYPEFACE_ROBOTO_MONO_MEDIUM_ITALIC,
            TYPEFACE_ROBOTO_MONO_BOLD,
            TYPEFACE_ROBOTO_MONO_BOLD_ITALIC,
    })
    public @interface RobotoTypeface {}

    public static final int TYPEFACE_ROBOTO_THIN = 0;
    public static final int TYPEFACE_ROBOTO_THIN_ITALIC = 1;
    public static final int TYPEFACE_ROBOTO_LIGHT = 2;
    public static final int TYPEFACE_ROBOTO_LIGHT_ITALIC = 3;
    public static final int TYPEFACE_ROBOTO_REGULAR = 4;
    public static final int TYPEFACE_ROBOTO_ITALIC = 5;
    public static final int TYPEFACE_ROBOTO_MEDIUM = 6;
    public static final int TYPEFACE_ROBOTO_MEDIUM_ITALIC = 7;
    public static final int TYPEFACE_ROBOTO_BOLD = 8;
    public static final int TYPEFACE_ROBOTO_BOLD_ITALIC = 9;
    public static final int TYPEFACE_ROBOTO_BLACK = 10;
    public static final int TYPEFACE_ROBOTO_BLACK_ITALIC = 11;
    public static final int TYPEFACE_ROBOTO_CONDENSED_LIGHT = 12;
    public static final int TYPEFACE_ROBOTO_CONDENSED_LIGHT_ITALIC = 13;
    public static final int TYPEFACE_ROBOTO_CONDENSED_REGULAR = 14;
    public static final int TYPEFACE_ROBOTO_CONDENSED_ITALIC = 15;
    public static final int TYPEFACE_ROBOTO_CONDENSED_BOLD = 16;
    public static final int TYPEFACE_ROBOTO_CONDENSED_BOLD_ITALIC = 17;
    public static final int TYPEFACE_ROBOTO_SLAB_THIN = 18;
    public static final int TYPEFACE_ROBOTO_SLAB_LIGHT = 19;
    public static final int TYPEFACE_ROBOTO_SLAB_REGULAR = 20;
    public static final int TYPEFACE_ROBOTO_SLAB_BOLD = 21;
    public static final int TYPEFACE_ROBOTO_MONO_THIN = 22;
    public static final int TYPEFACE_ROBOTO_MONO_THIN_ITALIC = 23;
    public static final int TYPEFACE_ROBOTO_MONO_LIGHT = 24;
    public static final int TYPEFACE_ROBOTO_MONO_LIGHT_ITALIC = 25;
    public static final int TYPEFACE_ROBOTO_MONO_REGULAR = 26;
    public static final int TYPEFACE_ROBOTO_MONO_ITALIC = 27;
    public static final int TYPEFACE_ROBOTO_MONO_MEDIUM = 28;
    public static final int TYPEFACE_ROBOTO_MONO_MEDIUM_ITALIC = 29;
    public static final int TYPEFACE_ROBOTO_MONO_BOLD = 30;
    public static final int TYPEFACE_ROBOTO_MONO_BOLD_ITALIC = 31;

    @Retention(SOURCE)
    @IntDef({
            FONT_FAMILY_ROBOTO,
            FONT_FAMILY_ROBOTO_CONDENSED,
            FONT_FAMILY_ROBOTO_SLAB,
            FONT_FAMILY_ROBOTO_MONO
    })
    public @interface RobotoFontFamily {}

    public static final int FONT_FAMILY_ROBOTO = 0;
    public static final int FONT_FAMILY_ROBOTO_CONDENSED = 1;
    public static final int FONT_FAMILY_ROBOTO_SLAB = 2;
    public static final int FONT_FAMILY_ROBOTO_MONO = 3;

    @Retention(SOURCE)
    @IntDef({
            TEXT_WEIGHT_NORMAL,
            TEXT_WEIGHT_THIN,
            TEXT_WEIGHT_LIGHT,
            TEXT_WEIGHT_MEDIUM,
            TEXT_WEIGHT_BOLD,
            TEXT_WEIGHT_ULTRA_BOLD
    })
    public @interface RobotoTextWeight {}

    public static final int TEXT_WEIGHT_NORMAL = 0;
    public static final int TEXT_WEIGHT_THIN = 1;
    public static final int TEXT_WEIGHT_LIGHT = 2;
    public static final int TEXT_WEIGHT_MEDIUM = 3;
    public static final int TEXT_WEIGHT_BOLD = 4;
    public static final int TEXT_WEIGHT_ULTRA_BOLD = 5;


    @Retention(SOURCE)
    @IntDef({
            TEXT_STYLE_NORMAL,
            TEXT_STYLE_ITALIC
    })
    public @interface RobotoTextStyle {}

    public static final int TEXT_STYLE_NORMAL = 0;
    public static final int TEXT_STYLE_ITALIC = 1;

    /**
     * Array of created typefaces for later reused.
     */
    private static final SparseArray<Typeface> typefacesCache = new SparseArray<>(32);

    private RobotoTypefaces() {}

    /**
     * Obtain typeface.
     *
     * @param context       The Context the widget is running in, through which it can access the current theme, resources, etc.
     * @param typefaceValue The value of "typeface" attribute
     * @return specify {@link Typeface} or throws IllegalArgumentException if unknown `typeface` attribute value.
     */
    @NonNull
    public static Typeface obtainTypeface(@NonNull Context context, @RobotoTypeface int typefaceValue) {
        Typeface typeface = typefacesCache.get(typefaceValue);
        if (typeface == null) {
            typeface = createTypeface(context, typefaceValue);
            typefacesCache.put(typefaceValue, typeface);
        }
        return typeface;
    }

    /**
     * Obtain typeface.
     *
     * @param context    The Context the widget is running in, through which it can access the current theme, resources, etc.
     * @param fontFamily The value of "fontFamily" attribute
     * @param textWeight The value of "textWeight" attribute
     * @param textStyle  The value of "textStyle" attribute
     * @return specify {@link Typeface} or throws IllegalArgumentException.
     */
    @NonNull
    public static Typeface obtainTypeface(@NonNull Context context, @RobotoFontFamily int fontFamily,
            @RobotoTextWeight int textWeight, @RobotoTextStyle int textStyle) {
        @RobotoTypeface int typeface;
        if (fontFamily == FONT_FAMILY_ROBOTO) {
            if (textStyle == TEXT_STYLE_NORMAL) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_REGULAR;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_THIN;
                        break;
                    case TEXT_WEIGHT_LIGHT:
                        typeface = TYPEFACE_ROBOTO_LIGHT;
                        break;
                    case TEXT_WEIGHT_MEDIUM:
                        typeface = TYPEFACE_ROBOTO_MEDIUM;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_BOLD;
                        break;
                    case TEXT_WEIGHT_ULTRA_BOLD:
                        typeface = TYPEFACE_ROBOTO_BLACK;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else if (textStyle == TEXT_STYLE_ITALIC) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_ITALIC;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_THIN_ITALIC;
                        break;
                    case TEXT_WEIGHT_LIGHT:
                        typeface = TYPEFACE_ROBOTO_LIGHT_ITALIC;
                        break;
                    case TEXT_WEIGHT_MEDIUM:
                        typeface = TYPEFACE_ROBOTO_MEDIUM_ITALIC;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_BOLD_ITALIC;
                        break;
                    case TEXT_WEIGHT_ULTRA_BOLD:
                        typeface = TYPEFACE_ROBOTO_BLACK_ITALIC;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else {
                throw new IllegalArgumentException("`textStyle` attribute value " + textStyle +
                        " is not supported for this fontFamily " + fontFamily);
            }
        } else if (fontFamily == FONT_FAMILY_ROBOTO_CONDENSED) {
            if (textStyle == TEXT_STYLE_NORMAL) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_REGULAR;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_LIGHT;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_BOLD;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else if (textStyle == TEXT_STYLE_ITALIC) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_ITALIC;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_LIGHT_ITALIC;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_CONDENSED_BOLD_ITALIC;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else {
                throw new IllegalArgumentException("`textStyle` attribute value " + textStyle +
                        " is not supported for this fontFamily " + fontFamily);
            }
        } else if (fontFamily == FONT_FAMILY_ROBOTO_SLAB) {
            if (textStyle == TEXT_STYLE_NORMAL) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_SLAB_REGULAR;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_SLAB_THIN;
                        break;
                    case TEXT_WEIGHT_LIGHT:
                        typeface = TYPEFACE_ROBOTO_SLAB_LIGHT;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_SLAB_BOLD;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else {
                throw new IllegalArgumentException("`textStyle` attribute value " + textStyle +
                        " is not supported for this fontFamily " + fontFamily);
            }
        } else if (fontFamily == FONT_FAMILY_ROBOTO_MONO) {
            if (textStyle == TEXT_STYLE_NORMAL) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_MONO_REGULAR;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_MONO_THIN;
                        break;
                    case TEXT_WEIGHT_LIGHT:
                        typeface = TYPEFACE_ROBOTO_MONO_LIGHT;
                        break;
                    case TEXT_WEIGHT_MEDIUM:
                        typeface = TYPEFACE_ROBOTO_MONO_MEDIUM;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_MONO_BOLD;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else if (textStyle == TEXT_STYLE_ITALIC) {
                switch (textWeight) {
                    case TEXT_WEIGHT_NORMAL:
                        typeface = TYPEFACE_ROBOTO_MONO_ITALIC;
                        break;
                    case TEXT_WEIGHT_THIN:
                        typeface = TYPEFACE_ROBOTO_MONO_THIN_ITALIC;
                        break;
                    case TEXT_WEIGHT_LIGHT:
                        typeface = TYPEFACE_ROBOTO_MONO_LIGHT_ITALIC;
                        break;
                    case TEXT_WEIGHT_MEDIUM:
                        typeface = TYPEFACE_ROBOTO_MONO_MEDIUM_ITALIC;
                        break;
                    case TEXT_WEIGHT_BOLD:
                        typeface = TYPEFACE_ROBOTO_MONO_BOLD_ITALIC;
                        break;
                    default:
                        throw new IllegalArgumentException("`textWeight` attribute value " + textWeight +
                                " is not supported for this font family " + fontFamily +
                                " and textStyle " + textStyle);
                }
            } else {
                throw new IllegalArgumentException("`textStyle` attribute value " + textStyle +
                        " is not supported for this fontFamily " + fontFamily);
            }
        } else {
            throw new IllegalArgumentException("Unknown `fontFamily` attribute value " + fontFamily);
        }
        return obtainTypeface(context, typeface);
    }

    /**
     * Create typeface from assets.
     *
     * @param context  The Context the widget is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param typeface The value of "typeface" attribute
     * @return Roboto {@link Typeface} or throws IllegalArgumentException if unknown `typeface` attribute value.
     */
    @NonNull
    private static Typeface createTypeface(@NonNull Context context, @RobotoTypeface int typeface) {
        String path;
        switch (typeface) {
            case TYPEFACE_ROBOTO_THIN:
                path = "fonts/Roboto-Thin.ttf";
                break;
            case TYPEFACE_ROBOTO_THIN_ITALIC:
                path = "fonts/Roboto-ThinItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_LIGHT:
                path = "fonts/Roboto-Light.ttf";
                break;
            case TYPEFACE_ROBOTO_LIGHT_ITALIC:
                path = "fonts/Roboto-LightItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_REGULAR:
                path = "fonts/Roboto-Regular.ttf";
                break;
            case TYPEFACE_ROBOTO_ITALIC:
                path = "fonts/Roboto-Italic.ttf";
                break;
            case TYPEFACE_ROBOTO_MEDIUM:
                path = "fonts/Roboto-Medium.ttf";
                break;
            case TYPEFACE_ROBOTO_MEDIUM_ITALIC:
                path = "fonts/Roboto-MediumItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_BOLD:
                path = "fonts/Roboto-Bold.ttf";
                break;
            case TYPEFACE_ROBOTO_BOLD_ITALIC:
                path = "fonts/Roboto-BoldItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_BLACK:
                path = "fonts/Roboto-Black.ttf";
                break;
            case TYPEFACE_ROBOTO_BLACK_ITALIC:
                path = "fonts/Roboto-BlackItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_LIGHT:
                path = "fonts/RobotoCondensed-Light.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_LIGHT_ITALIC:
                path = "fonts/RobotoCondensed-LightItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_REGULAR:
                path = "fonts/RobotoCondensed-Regular.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_ITALIC:
                path = "fonts/RobotoCondensed-Italic.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_BOLD:
                path = "fonts/RobotoCondensed-Bold.ttf";
                break;
            case TYPEFACE_ROBOTO_CONDENSED_BOLD_ITALIC:
                path = "fonts/RobotoCondensed-BoldItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_SLAB_THIN:
                path = "fonts/RobotoSlab-Thin.ttf";
                break;
            case TYPEFACE_ROBOTO_SLAB_LIGHT:
                path = "fonts/RobotoSlab-Light.ttf";
                break;
            case TYPEFACE_ROBOTO_SLAB_REGULAR:
                path = "fonts/RobotoSlab-Regular.ttf";
                break;
            case TYPEFACE_ROBOTO_SLAB_BOLD:
                path = "fonts/RobotoSlab-Bold.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_THIN:
                path = "fonts/RobotoMono-Thin.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_THIN_ITALIC:
                path = "fonts/RobotoMono-ThinItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_LIGHT:
                path = "fonts/RobotoMono-Light.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_LIGHT_ITALIC:
                path = "fonts/RobotoMono-LightItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_REGULAR:
                path = "fonts/RobotoMono-Regular.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_ITALIC:
                path = "fonts/RobotoMono-Italic.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_MEDIUM:
                path = "fonts/RobotoMono-Medium.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_MEDIUM_ITALIC:
                path = "fonts/RobotoMono-MediumItalic.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_BOLD:
                path = "fonts/RobotoMono-Bold.ttf";
                break;
            case TYPEFACE_ROBOTO_MONO_BOLD_ITALIC:
                path = "fonts/RobotoMono-BoldItalic.ttf";
                break;
            default:
                throw new IllegalArgumentException("Unknown `typeface` attribute value " + typeface);
        }
        return Typeface.createFromAsset(context.getAssets(), path);
    }

    /**
     * Obtain typeface from attributes.
     *
     * @param context The Context the widget is running in, through which it can access the current theme, resources, etc.
     * @param attrs   The styled attribute values in this Context's theme.
     * @return specify {@link Typeface}
     */
    @NonNull
    public static Typeface obtainTypeface(@NonNull Context context, @NonNull TypedArray attrs) {
        if (attrs.hasValue(R.styleable.RobotoTextView_typeface)) {
            @RobotoTypeface int typefaceValue = attrs.getInt(R.styleable.RobotoTextView_typeface, TYPEFACE_ROBOTO_REGULAR);
            return obtainTypeface(context, typefaceValue);
        } else {
            @RobotoFontFamily int fontFamily = attrs.getInt(R.styleable.RobotoTextView_fontFamily, FONT_FAMILY_ROBOTO);
            @RobotoTextWeight int textWeight = attrs.getInt(R.styleable.RobotoTextView_textWeight, TEXT_WEIGHT_NORMAL);
            @RobotoTextStyle int textStyle = attrs.getInt(R.styleable.RobotoTextView_textStyle, TEXT_STYLE_NORMAL);
            return obtainTypeface(context, fontFamily, textWeight, textStyle);
        }
    }

    /**
     * Set up typeface for TextView from the attributes.
     *
     * @param textView The roboto text view
     * @param context  The context the widget is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param attrs    The attributes of the XML tag that is inflating the widget.
     */
    public static void setUpTypeface(@NonNull TextView textView, @NonNull Context context, @Nullable AttributeSet attrs) {
        Typeface typeface;
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RobotoTextView);
            try {
                typeface = obtainTypeface(context, a);
            } finally {
                a.recycle();
            }
        } else {
            typeface = obtainTypeface(context, TYPEFACE_ROBOTO_REGULAR);
        }
        setUpTypeface(textView, typeface);
    }

    /**
     * Set up typeface for TextView. Wrapper over {@link TextView#setTypeface(Typeface)}
     * for making the font anti-aliased.
     *
     * @param textView The text view
     * @param typeface The specify typeface
     */
    public static void setUpTypeface(@NonNull TextView textView, @NonNull Typeface typeface) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        textView.setTypeface(typeface);
    }

    /**
     * Set up typeface for Paint. Wrapper over {@link Paint#setTypeface(Typeface)}
     * for making the font anti-aliased.
     *
     * @param paint    The paint
     * @param typeface The specify typeface
     */
    public static void setUpTypeface(@NonNull Paint paint, @NonNull Typeface typeface) {
        paint.setFlags(paint.getFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        paint.setTypeface(typeface);
    }
}