package com.xyz.richtext.richactivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;

/**
 * created by shenyonghui on 2020/7/13
 */
public class TextAppearanceActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        String text = "文本外貌是什么样式";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new TextAppearanceSpan(this, R.style.style_black), text.length() - 2, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
