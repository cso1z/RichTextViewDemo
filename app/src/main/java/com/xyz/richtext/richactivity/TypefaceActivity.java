package com.xyz.richtext.richactivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.TypefaceSpan;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.weight.TypefaceUtil;

/**
 * created by shenyonghui on 2020/7/14
 * 设置文字字体
 * 本文自定义字体来自：http://www.ypppt.com/ziti/
 */
public class TypefaceActivity extends BaseRichTextActivity {

    @Override
    public SpannableString getText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        SpannableString customText0 = new SpannableString("这是自定义字体1\n");
        CustomTypefaceSpan customTypefaceSpan0 = new CustomTypefaceSpan(TypefaceUtil.load(this, "asset:text.ttf", 0));
        customText0.setSpan(customTypefaceSpan0, 0, customText0.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString customText1 = new SpannableString("这是自定义字体2\n");
        CustomTypefaceSpan customTypefaceSpan1 = new CustomTypefaceSpan(TypefaceUtil.load(this, "asset:text1.ttf", 0));
        customText1.setSpan(customTypefaceSpan1, 0, customText1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        SpannableString monospaceText = new SpannableString("这是monospace字体\n");
        TypefaceSpan monospace = new TypefaceSpan("monospace");
        monospaceText.setSpan(monospace, 0, monospaceText.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        SpannableString serifText = new SpannableString("这是serif字体\n");
        TypefaceSpan serif = new TypefaceSpan("serif");
        serifText.setSpan(serif, 0, serifText.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        SpannableString sansSerifText = new SpannableString("这是sans-serif字体\n");
        TypefaceSpan sansSerif = new TypefaceSpan("sans-serif");
        sansSerifText.setSpan(sansSerif, 0, sansSerifText.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        textView.setText(spannableStringBuilder.append(customText0).append(customText1).append(monospaceText).append(serifText).append(sansSerifText));
        return null;
    }


    static class CustomTypefaceSpan extends MetricAffectingSpan {

        private final Typeface typeface;

        CustomTypefaceSpan(final Typeface typeface) {
            this.typeface = typeface;
        }

        @Override
        public void updateDrawState(final TextPaint drawState) {
            apply(drawState);
        }

        @Override
        public void updateMeasureState(final TextPaint paint) {
            apply(paint);
        }

        private void apply(final Paint paint) {
            final Typeface oldTypeface = paint.getTypeface();
            final int oldStyle = oldTypeface != null ? oldTypeface.getStyle() : 0;
            final int fakeStyle = oldStyle & ~typeface.getStyle();

            if ((fakeStyle & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fakeStyle & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }

            paint.setTypeface(typeface);
        }
    }
}
