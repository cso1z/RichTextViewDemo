package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 */
public class SuperscriptActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "上标标:通常在数学公式中使用,例如:\nx2-x1-2=0";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new SuperscriptSpan(), text.indexOf("1"), text.indexOf("1") + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new SuperscriptSpan(), text.indexOf("2"), text.indexOf("2") + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
