package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 * 中划线
 */
public class StrikethroughActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "如果想注释某些不需要的文字，\n可以使用中划线";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new StrikethroughSpan(), text.length() - 3, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
