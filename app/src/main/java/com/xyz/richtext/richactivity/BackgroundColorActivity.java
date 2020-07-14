package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 * 背景色
 */
public class BackgroundColorActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "这个字背景是蓝色的,\n这个字背景是红色的";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new BackgroundColorSpan(0xff00ddff), 6, 8, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new BackgroundColorSpan(0xffcc0000), text.length() - 3, text.length() - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return spannableString;
    }
}
