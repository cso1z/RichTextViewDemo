package com.xyz.richtext.richactivity;

import android.graphics.BlurMaskFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.MaskFilterSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 * 修饰效果
 */
public class MaskFilterActivity extends BaseRichTextActivity {
    @Override
    public CharSequence getText() {
        String text = "想知道修饰效果是什么样的，就看下面这句话:\n修饰效果 NORMAL\n修饰效果 SOLID\n修饰效果 OUTER\n修饰效果 INNER";
        SpannableString spannableString = new SpannableString(text);
        int startIndex = text.indexOf("修饰效果 NORMAL");
        spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(4, BlurMaskFilter.Blur.NORMAL)), startIndex, startIndex + "修饰效果 NORMAL".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = text.indexOf("修饰效果 SOLID");
        spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(4, BlurMaskFilter.Blur.SOLID)), startIndex, startIndex + "修饰效果 SOLID".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = text.indexOf("修饰效果 OUTER");
        spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(4, BlurMaskFilter.Blur.OUTER)), startIndex, startIndex + "修饰效果 OUTER".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = text.indexOf("修饰效果 INNER");
        spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(4, BlurMaskFilter.Blur.INNER)), startIndex, startIndex + "修饰效果 INNER".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}