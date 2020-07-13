package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.SubscriptSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 */
public class SubscriptActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "下标:通常在数学公式中使用,例如:\nx1-x2-2=0";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new SubscriptSpan(), text.indexOf("1"), text.indexOf("1") + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new SubscriptSpan(), text.indexOf("2"), text.indexOf("2") + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
