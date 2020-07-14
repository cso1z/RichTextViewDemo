package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 * 基于x轴缩放
 */
public class ScaleXActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "基于x轴进行缩放";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ScaleXSpan(1.6F), text.length() - 2, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
